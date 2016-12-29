/*
 * Document   : Model Component of JavaClub Application
 * Created on : July 27, 2016
 * Updated on : August 02, 2016
 * Author     : Sung Woo Lee (leeduris@gmail.com)
 */

package javaclub;

import ejd.JdbcHelper;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDatabase
{
    // constances for DB access
    private static final String DB_URL = "jdbc:mysql://***********";
    private static final String DB_USER = "**********";
    private static final String DB_PASS = "**********";      

    // instance vars
    private JdbcHelper jdbc;        
    
    // ctors
    public UserDatabase()
    { 
        jdbc = new JdbcHelper();  
    }
    
    // login validation
    public boolean isValid(String id, String pw)
    {
        // local var
        boolean valid = false;
        
        // exercute SQL statement
        jdbc.connect(DB_URL, DB_USER, DB_PASS);
        String sql = "SELECT * FROM jcuser";       
        
        // validate a null value of executing sql
        try(ResultSet rs = jdbc.query(sql);)
        {
            while(rs.next())
            {
                String userId = rs.getString("id");
                String password = rs.getString("password");
                    
                valid = id != null && !id.isEmpty()
                        && userId.equals(id)
                        && pw != null && !pw.isEmpty() 
                        && BCrypt.checkpw(pw, password)
                        ;
                
                if(valid)
                    break;
            }
        }
        catch(Exception e)
        {
           System.err.println(e.getMessage());
        }
    
        jdbc.disconnect();
        return valid;
    }
    
    // return false if a user is already in DB, 
    public boolean isUnique(String id)
    {
        // validate a null value of executing sql
        boolean valid = (id != null && !id.isEmpty() 
                         && getUser(id) != null);
      
        return !valid;
    }
    
    // get a user info from DB 
    public User getUser(String id)
    {
        // validate input
        if(id == null || id.isEmpty())
            return null;
         
        // set sql for prepared statement
        String sql = "SELECT * FROM jcuser WHERE id = ? ";
        
        // set parameter for prepared statement
        ArrayList<Object> params = new ArrayList<>();
        params.add(id);
        
        jdbc.connect(DB_URL, DB_USER, DB_PASS);
        
        // init the value
        User user = null;
        
        try(ResultSet rs = jdbc.query(sql, params)) 
        {
            // copy user info from DB to JavaBean Object            
            if(rs.first())
            {
                user = new User(rs.getString("id"),
                                rs.getString("password"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getString("email"));      
            }            
        }       
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }      
                
        jdbc.disconnect();
        return user;
    }
    
    // add a new member
    public int addUser(String id, String pw, String fN, String lN, String email) 
    {
        // preparedstatement
        String sql = "INSERT INTO jcuser "
                   + "(id, password, firstName, lastName, email)"
                   + "VALUES (?, ?, ?, ?, ?)";
        
        // generate params for palceholders
        ArrayList<Object> params = new ArrayList<>();  
        params.add(id);
        params.add(BCrypt.hashpw(pw, BCrypt.gensalt()));
        params.add(fN);
        params.add(lN);
        params.add(email);       
        
        // execute SQL and list for prepared statement
        jdbc.connect(DB_URL, DB_USER, DB_PASS);
        int result = jdbc.update(sql, params);
       
        // disconnect database
        jdbc.disconnect();
        
        // return result 
        return result;
    }
 }
