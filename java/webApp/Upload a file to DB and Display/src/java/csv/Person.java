package csv;

import java.util.Objects;

public class Person 
{
    // 11 instances vars
    private String firstName;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private String postal;
    private String phone1;
    private String phone2;
    private String email;
    private String web;

    // 2 ctors
    public Person()
    {
        set("","","","","","","","","","","");
    }
    
    public Person(String firstName, String lastName, String companyName,
            String address, String city, String province, String postal, 
            String phone1, String phone2, String email, String web)
    {
        set(firstName, lastName, companyName, address, city, province, postal,
                phone1, phone2, email, web);
    }
    
    // getters/setters
    public void set(String firstName, String lastName, String companyName,
            String address, String city, String province, String postal, 
            String phone1, String phone2, String email, String web)
    {
        this.firstName = firstName;  
        this.lastName = lastName;
        this.companyName = companyName; 
        this.address = address; 
        this.city = city; 
        this.province = province; 
        this.postal = postal; 
        this.phone1 = phone1; 
        this.phone2 = phone2; 
        this.email = email; 
        this.web = web;        
    }
  
    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getProvince() 
    {
        return province;
    }

    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getPostal() 
    {
        return postal;
    }

    public void setPostal(String postal) 
    {
        this.postal = postal;
    }

    public String getPhone1() 
    {
        return phone1;
    }

    public void setPhone1(String phone1) 
    {
        this.phone1 = phone1;
    }

    public String getPhone2() 
    {
        return phone2;
    }

    public void setPhone2(String phone2) 
    {
        this.phone2 = phone2;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getWeb() 
    {
        return web;
    }

    public void setWeb(String web) 
    {
        this.web = web;
    }
    
    @Override
    public String toString() 
    {
        return "Person(" + getFirstName() + ": " + getLastName() + ": " + 
                getCompanyName() + ": " + getAddress() + ": " + 
                getCity() + ": " + getProvince() + ": " + 
                getPostal() + ": " + getPhone1() + ": " + 
                getPhone2() + ": " + getEmail() + ": " + 
                getWeb() + ")";
    }   
    
    @Override
    public boolean equals(Object o)
    {
        if(!(o instanceof Person)) // ignore null or non Person obj
            return false;

        if(this == o) // ignore itself
            return true;

        // compare all member fields if they are equals
        Person p = (Person)o;
        
        if(this.firstName.equals(p.getFirstName()) &&
           this.lastName.equals(p.getLastName()) &&
           this.companyName.equals(p.getCompanyName()) &&
           this.address.equals(p.getAddress()) &&
           this.city.equals(p.getCity()) &&
           this.province.equals(p.getProvince()) &&
           this.postal.equals(p.getPostal()) &&
           this.phone1.equals(p.getPhone1()) &&
           this.phone2.equals(p.getPhone2()) &&
           this.email.equals(p.getEmail()) &&
           this.web.equals(p.getWeb()))
            return true;
        else
            return false; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + Objects.hashCode(this.companyName);
        hash = 41 * hash + Objects.hashCode(this.address);
        hash = 41 * hash + Objects.hashCode(this.city);
        hash = 41 * hash + Objects.hashCode(this.province);
        hash = 41 * hash + Objects.hashCode(this.postal);
        hash = 41 * hash + Objects.hashCode(this.phone1);
        hash = 41 * hash + Objects.hashCode(this.phone2);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.web);
        return hash;
    }
}
