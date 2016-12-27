package ejd;
// JdbcHelper.java
// ===============
// a simple, light-weight JDBC utility class
// it support both static Statement and PreparedStatement.
// AUTHOR: Sung Woo Lee (leeduris@gmail.com)(song.ahn@gmail.com)
// CREATED: 2016-05-18
// UPDATED: 2016-05-25
////////////////////////////////////////////


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class JdbcHelper 
{
    // instance vars
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    private String errorMessage;  // current error message
    
    // for prepared statement
    private String activeSql;    //  parametric SQL statement
    private PreparedStatement activeStatement;
        
    ////////////////////////////
    // ctor
    public JdbcHelper()
    {
        // init instance vars
        connection = null;
        statement = null;
        result = null;
        errorMessage = "";
        
        activeSql = "";
        activeStatement = null;
    }
    
    ///////////////////////////
    // try connect to DB with 3 params (URL, user, pass)
    // if successful, return true. Otherwise, return false
    //////////////////////////
    public boolean connect(String url, String user, String pass)
    {
        boolean connected = false; // return value
        errorMessage = "";         // reset prev error message
        try
        {
            // try to connect
            initJdbcDriver(url);
            connection = DriverManager.getConnection(url, user, pass);
            
            // create static statement object
            statement = connection.createStatement();
            
            connected = true;  // return value
        }
        catch(SQLException e) 
        {
            connection = null;
            errorMessage = e.getSQLState() + ": " +  e.getMessage();
            System.out.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.out.println(errorMessage);
        }
        
        return connected;
    }
    
    
    
    ///////////////////////////////////////
    // clear JDBC resources
    public void disconnect()
    {
        try { result.close(); }          catch(Exception e) {}
        try { statement.close(); }       catch(Exception e) {}
        try { activeStatement.close(); } catch(Exception e) {}
        try { connection.close(); }      catch(Exception e) {}
    }
    
    
    
    /////////////////////////////////////
    // exercute SQL query 
    // it returns ResultSet instance if successful.
    // otherwise, returns null pointer
    public ResultSet query(String sql)
    {
        // reset return values
        result = null;
        errorMessage = "";
        
        if(connection == null)
        {
            errorMessage = "Try to connect to DB first before using query()";
            return result;
        }
        
        try
        {
            result = statement.executeQuery(sql);
        }
        catch(SQLException e)
        {
            errorMessage = e.getSQLState() + ": " + e.getMessage();
            System.err.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }
        
        return result;
    }
    
    
    // exercute update for preparedstatement.
    public ResultSet query(String sql, ArrayList<Object> params)
    {
        // reset return values
        result = null;
        errorMessage = "";
        
        if(connection == null)
        {
            errorMessage = "Try to connect to DB first before using query()";
            return result;
        }
        
        try
        {
           // create new prepared statement only if sql was changed
            if(!sql.equals(activeSql)) 
                activeStatement = connection.prepareStatement(sql);activeSql = sql;

           // set all parameter values of prepared statement
            if(params != null)
                setParametersForPreparedStatement(params);

           // execute the prepared statement
           result = activeStatement.executeQuery();
        }
        catch(SQLException e)
        {
            errorMessage = e.getSQLState() + ": " + e.getMessage();
            System.err.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }
        
        return result;
    }
    
    
    
    // exercute update that returns no ResultSet, such as CREATE
    // if successful, it returns 0 or # of rows changed.
    public int update(String sql)
    {
        // local var
        int result = -1;       // default return value
        errorMessage = "";
        
        if(connection == null)
        {
            errorMessage = "Database is NOT connected. Invoke connnect()";
            return result;
        }
        
        try
        {
            result = statement.executeUpdate(sql);
            
        }
        catch(SQLException e)
        {
            errorMessage = e.getSQLState() + ": " + e.getMessage();
            System.err.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }
        
        return result;
    }
    
    
    // exercute update for preparedstatement.
    // if successful, it returns 0 or # of rows changed.
    // if failed, it returns -1
    public int update(String sql, ArrayList<Object> params)
    {
        // local var
        int result = -1;       // default return value
        errorMessage = "";
        
        if(connection == null)
        {
            errorMessage = "Database is NOT connected. Invoke connnect()";
            return result;
        }
        
        try
        {
            // compare sql string with the prev sql
            // if it is changed, create new prepared statement
            if(!activeSql.equals(sql))
            {
                activeStatement = connection.prepareStatement(sql);
                activeSql = sql;
            }

            // set all parameters for prepared statement
            if(params !=null)
                setParametersForPreparedStatement(params);

            // execute the prepared statement
            result = activeStatement.executeUpdate();
                
            
        }
        catch(SQLException e)
        {
            errorMessage = e.getSQLState() + ": " + e.getMessage();
            System.err.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }
        
        return result;
    }
    
    
    
    //////////////////////////////////////
    // set parameters for preparedstatement, setXXX()
    //////////////////////////////////////
    private void setParametersForPreparedStatement(ArrayList<Object> params)
    {
        // reset
        errorMessage = "";
        Object param = null;    // parameter element in the ArrayList
        
        // check params: if null, do nothing
        if(params == null)
        {
            return;
        }
        
        try
        {
            for(int i = 0; i < params.size(); ++i)
            {
                param = params.get(i);
                if(param instanceof Integer)
                    activeStatement.setInt(i+1, (Integer)param);  
                
                else if(param instanceof Double)
                    activeStatement.setDouble(i+1, (Double)param);
                else if(param instanceof String)
                    activeStatement.setString(i+1, (String)param);
                //@@ add more types here
            }
                
        }
        catch(SQLException e)
        {
            errorMessage = e.getSQLState() + ": " + e.getMessage();
            System.err.println(errorMessage);
        }
        catch(Exception e)
        {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }               
        
    }    
    
    
    // return the current error message
    public String getErrorMessage()
    {
        return errorMessage;
    }
    
        
    ///////////////////////////////////////
    // register the JDBC driver based on URL
    ///////////////////////////////////////
    private void initJdbcDriver(String url)
    {
        // test various database
        try
        {
            if(url.contains("jdbc:mysql"))
                Class.forName("com.mysql.jdbc.Driver");
            
            else if(url.contains("jdbc:oracle"))
                Class.forName("oracle.jdbc.OracleDriver");
            
            else if(url.contains("jdbc:derby"))
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            else if(url.contains("jdbc:db2"))
                Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            else if(url.contains("jdbc:postgresql"))
                Class.forName("org.postgresql.Driver");
            
            else if(url.contains("jdbc:sqlite"))
                Class.forName("org.sqlite.JDBC");
            
            else if(url.contains("jdbc:sqlserver"))
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            else if(url.contains("jdbc:sybase"))
                Class.forName("sybase.jdbc.sqlanywhere.IDriver");

            // add other databases here
        }
        catch(ClassNotFoundException e)
        {
            errorMessage = "[ERROR] Failed to initialize JDBC driver class.";
            System.err.println(errorMessage);
        }
    } 
    
}
