package woo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class CourseInventoryModel
{
    // public variavles 
    private ArrayList<Course> courses;
    private String selectedId;

    // constructor    
    public CourseInventoryModel()
    {
        // create arraylist for courses
        courses = new ArrayList<Course>();
    }            
    
    // read a course from a external data file 
    public void readCourseFile(File file)
    {
        // local variables
        ArrayList<String> lines = new ArrayList<>();
        String line;
       
        // open file
        try(BufferedReader br = new 
                BufferedReader(new FileReader(file)))
        {
            // read lines            
            while((line = br.readLine()) != null)
            {
                // store each line to arraylist
                lines.add(line);
            }   
        }
        catch(IOException e)
        {
            System.err.print("[Open Error] " + e.getMessage());
        }
        
        // sort by id, split with delimeter, and trim them
        Collections.sort(lines);
        courses.clear();
        for(int i = 0; i < lines.size(); ++i)
        {
            // get single line and tokenizer
            String[] tokens = lines.get(i).split(";");  
                
            // get tokens  
            if(tokens.length < 4)
                continue;
            for(int j = 0; j < tokens.length; ++j)
                tokens[j] = tokens[j].trim();
            
            // store tokens in a course object
            Course course = new Course(tokens[0], tokens[1], 
                        Integer.parseInt(tokens[2]), tokens[3]);
                
            // add it into arraylist            
            courses.add(course);                  
        }
    }
    
    // save a data file from a updated course
    public int saveCourseFile(File file)
    {   
        // write and save file
        try(BufferedWriter bw = new 
                BufferedWriter(new FileWriter(file)))
        {          
           // print the output file
            String line;
            for(int i = 0; i < courses.size(); ++i)
            {
                Course c = (Course) courses.get(i);
                line = c.getId() + " ; " + c.getTitle() + " ; " 
                       + c.getCredit() + " ; " + c.getCategory() + "\n";                
                bw.write(line);
            }               
            
        } catch (IOException e) {
            System.err.print("[Save Error] " + e.getMessage());
        }     
        
        return courses.size();
    }

    // getters and setters
    
    // store the course id in a arraylist from a loaded file 
    public ArrayList<String> getCourseID()
    {
            ArrayList<String> lists = new ArrayList<>();
    
            Course c;
            for(int i = 0; i < courses.size(); ++i)
            {   
                c = (Course) courses.get(i);
                lists.add(c.getId());
            }
            
            return lists;
    }
    
    // store the course category in a arraylist from a loaded file
    public ArrayList<String> getCourseCategory()
    {
            ArrayList<String> lists = new ArrayList<>();
    
            Course c;
            for(int i = 0; i < courses.size(); ++i)
            {   
                c = (Course) courses.get(i);
                
                // check to avoid adding a existed data
                if(!lists.contains(c.getCategory()))
                    lists.add(c.getCategory());
            }           
            
            return lists;
    }

    // filter a course to match with a given id
    public Course getCourseById(String selectedId)
    {
        Course c;
        for(int i = 0; i < courses.size(); ++i)
        {   
            c = (Course) courses.get(i);            
            if(c.getId().equals(selectedId))
                return c;
        }
        
        return null;
    }
    
    // store the course ids in a arraylist at a given category
    public ArrayList<String> getIdByCategory(String selectedCategory)
    {
            ArrayList<String> lists = new ArrayList<>();            
            
            for(int i = 0; i < courses.size(); ++i)
            {   
                // check to be equal with a slected category and avoid duplicated id 
                Course c = courses.get(i);
                if(c.getCategory().equals(selectedCategory) && !lists.contains(c.getId()))
                    lists.add(c.getId());
            }
                
            // store all unique id when selecting all categories
            if(selectedCategory.equals("All Categories"))
                lists = getCourseID();
                        
            return lists;
    }   
    
    // store course ids and titles in a arraylist at a searched id 
    public ArrayList<String> searchCourseById(String searchedId)
    {
        ArrayList<String> lists = new ArrayList<>();
        
        Course c;
        for(int i = 0; i < courses.size(); ++i)
        {   
            c = (Course) courses.get(i);
            if(c.getId().toUpperCase().contains(searchedId))
                lists.add(c.getId() + ": " + c.getTitle());
        }
            
        return lists;
    }
    
    // store course ids and titles in a arraylist at a searched title
    public ArrayList<String> searchCourseByTitle(String searchedTitle)
    {
        ArrayList<String> lists = new ArrayList<>();
        
        Course c;
        for(int i = 0; i < courses.size(); ++i)
        {   
            c = (Course) courses.get(i);
            if(c.getTitle().toUpperCase().contains(searchedTitle))
                lists.add(c.getId() + ": " + c.getTitle());
        }
            
        return lists;
    }
    
    // set a selected id for a getter  
    public void setReturnSelectedId(String Id)
    {
        selectedId = Id;
    }
    
    // get a selected id from setter
    public String getReturnSelectedId()
    {
        return selectedId;         
    }
    
    // add a new course to save it
    public void addNewCourse(Course c)
    {
         courses.add(c);         
         setReturnSelectedId(c.getId());
         Collections.sort(courses);
    }
    
    // update a existed course 
    public void updateCourse(Course c)
    {
         Course updateCourse = getCourseById(c.getId());
         updateCourse.set(c.getId(), c.getTitle(), c.getCredit(), c.getCategory());
         Collections.sort(courses);
    }
    
    // delete a existed course
    public void deleteCourse(String selectedId)
    {
        Course deleteCourse = getCourseById(selectedId);
        courses.remove(deleteCourse);
        Collections.sort(courses);
    }
    
    // regexp: 4 alphabets followed by 5 numeric digits
    public Boolean validateNewId(String newId)
    {
        return Pattern.matches("^[A-Z]{4}[0-9]{5}$", newId);
    }
    
    // alert to show a message of error or information
    public void alertError(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("New Course Add: Validation");            
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
    }
    
    // alert to show a confirm message
    public String alertConfirm(String message)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Save Course : Validation");            
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
            return "ok";
        else
            return "cancel";
    }

}
