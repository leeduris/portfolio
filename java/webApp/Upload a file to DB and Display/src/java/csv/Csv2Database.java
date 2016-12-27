package csv;

import ejd.JdbcHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Csv2Database 
{  
    // member vars
    ArrayList<Person> parsedPersons;
    ArrayList<Person> addedPersons;
    ArrayList<Person> getPersons;
    JdbcHelper jdbc;   
    
    // ctor
    public Csv2Database(String dbUrl, String dbUser, String dbPass)
    {
        parsedPersons = new ArrayList<>();
        addedPersons = new ArrayList<>();
        getPersons = new ArrayList<>();
        jdbc = new JdbcHelper();
        jdbc.connect(dbUrl, dbUser, dbPass);
    }
    
    // read CSV file (input stream), and returns parsedPersons list.
    public ArrayList<Person> readCsv(InputStream fileStream)
    {
        // clear
        parsedPersons.clear();
        
        // local, tmp variables
        ArrayList<String> lines = new ArrayList<>();
        String line = null;
        
        // get the file from request and create a file reader
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream)))
        {
            // parse each line and store to an array
            while((line = reader.readLine()) != null) 
            {
                // store each line to arraylist
                lines.add(line);
            }
            
            // close bufferred reading
            reader.close();
        }
        catch(IOException e)
        {
            System.err.print("[Open Error] " + e.getMessage());
        }
        
        // split with delimeter, and trim them
        for(int i = 0; i < lines.size(); ++i)
        {
            // get single line and tokenizer
            String[] tokens = lines.get(i).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");  
            
                
            // validate # of fields 
            if(tokens.length != 11)
                continue;
            
            // valudate header
            if(tokens[0].contains("\"first_name\""))
                continue;                
            
            for(int j = 0; j < tokens.length; ++j)
            {
                // trim all tokens
                tokens[j] = tokens[j].replaceAll("^\"|\"$", "").trim();
            }                
            
            // store it to a person class 
            Person person = new Person(tokens[0], tokens[1], tokens[2], 
                        tokens[3], tokens[4], tokens[5], tokens[6], tokens[7], 
                        tokens[8], tokens[9], tokens[10]);
                            
            // add it into arraylist
            parsedPersons.add(person);                  
        }
        
        return parsedPersons;
    }
    
    // add the given record set to database
    public ArrayList<Person> addPersons(ArrayList<Person> parsedPersons)
    {
        for(int i = 0; i < parsedPersons.size(); ++i)
        {
            if(!isPersonExists(getPersonsFromDatabase(), parsedPersons.get(i)))
            {
                // preparedstatement
                String sql = "INSERT INTO Person "
                           + "(firstName, lastName, companyName, address, city,"
                           + "province, postal, phone1, phone2, email, web)"
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
                // generate params for palceholders
                ArrayList<Object> params = new ArrayList<>();  
                params.add(parsedPersons.get(i).getFirstName());
                params.add(parsedPersons.get(i).getLastName()); 
                params.add(parsedPersons.get(i).getCompanyName());
                params.add(parsedPersons.get(i).getAddress());
                params.add(parsedPersons.get(i).getCity());
                params.add(parsedPersons.get(i).getProvince());
                params.add(parsedPersons.get(i).getPostal());
                params.add(parsedPersons.get(i).getPhone1());
                params.add(parsedPersons.get(i).getPhone2());
                params.add(parsedPersons.get(i).getEmail());
                params.add(parsedPersons.get(i).getWeb());
        
                // execute it
                int result = jdbc.update(sql, params);
                if(result == 1)
                    System.out.println("Success");
                else if(result < 0)
                    System.out.println("Fail");     
                
                // add it into arraylist
                addedPersons.add(parsedPersons.get(i));                
           }
        }
        
        return addedPersons;        
    }
    
    // retrieve the existing Person records from database
    public ArrayList<Person> getPersonsFromDatabase()
    {   
        // exercute SQL statement
        String sql = "SELECT * FROM Person";
        ResultSet rs = jdbc.query(sql);
        
        // validate a null value of executing sql
        if(rs == null)
        {
            System.err.println("Failed to execute: " + sql);
        }
        else
        {
        
            // retrieve rows/cols
            try
            {
                while(rs.next())
                {
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String companyName = rs.getString("companyName");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    String province = rs.getString("province");
                    String postal = rs.getString("postal");
                    String phone1 = rs.getString("phone1");
                    String phone2 = rs.getString("phone2");
                    String email = rs.getString("email");
                    String web = rs.getString("web");                    
                    
                    // print each record
                    toString();
                    
                    // contain a record into a person class
                    Person person = new Person(firstName, lastName, companyName,
                            address, city, province, postal, phone1, phone2, 
                            email, web);
                    
                    // add it into arraylist
                    getPersons.add(person);
                }
            }
            catch(SQLException e)
            {
                System.err.println(e.getSQLState() + ": " + e.getMessage());
            }
            catch(Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
       
        return getPersons;
    }
    
    private boolean isPersonExists(ArrayList<Person> persons, Person p)
    {
        for(int i = 0; i < persons.size(); ++i)
        {
            if(p.equals(persons.get(i)))
                return true;
        }
        
        return false;
    }
    
    public ArrayList<Person> getAddedPersons()
    {
        return addedPersons;
    }
  
}

