package woo;

import java.util.Objects;

public class Course implements Comparable
{
    //Member variables
    private String id;
    private String title;
    private int credit;
    private String category;
    
    // constructors with no-arg
    public Course()
    {
        set("", "", 0, "");
    }
    
    // constructors with-arg
    public Course(String id, String title, int credit, String category)
    {
        set(id, title, credit, category);
    }
    
    // All setters and getters
    public void set(String id, String title, int credit, String category)
    {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.category = category;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public int getCredit() 
    {
        return credit;
    }

    public void setCredit(int credit) 
    {
        this.credit = credit;
    }   

    public String getCategory() 
    {
        return category;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }   

    // Override toString() method
    @Override
    public String toString() 
    {
        return "Course(" + getId() + ": " + getTitle() + ": " + ")";
    }   
 
    // Override hashCode() method
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    // Override equals() method for searching
    @Override
    public boolean equals(Object course) 
    {
        if (course instanceof Course) 
        {
            return id.equals(((Course) course).getId());
        }
        else
            return this == course;
    }
    
    // Override compareTo() method for sorting by ID
    public int compareTo(Course course) 
    {
        return id.compareTo(course.getId());
    }

    // Implement Comparable<Object> interface
    @Override
    public int compareTo(Object o) 
    {
        return compareTo((Course)o);       
    } 
    
}
