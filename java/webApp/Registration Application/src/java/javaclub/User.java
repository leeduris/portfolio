/*
 * Document : JavaBean class (Model) to define user information. 
 * Created  : July 27, 2016
 * Updated  : July 29, 2016
 * Author   : Sung Woo Lee (leeduris@gmail.com)
 */
package javaclub;

public class User 
{
    // instance vars
    private String id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    
    // ctors
    public User() 
    {
        id = password = firstName = lastName = email = null;
    }
    
    public User(String id, String pw, String firstName, String lastName,
            String email)
    {
        this.id = id;
        this.password = pw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
