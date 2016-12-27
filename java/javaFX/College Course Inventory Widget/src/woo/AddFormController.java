package woo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AddFormController implements Initializable 
{
    private Stage stage;
    private CourseInventoryModel model;

    @FXML
    private TextField textId;
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textCredit;
    @FXML
    private ComboBox comboCategory;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonCancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // add event handler to the add button and check validattion
        buttonAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
        {            
            // validate ID
            String newId = textId.getText().toUpperCase();
            if(!model.validateNewId(newId))
            {                
                model.alertError("ID must consist of 4 alphabets followed by 5 digit numeric.");
                event.consume();
            } 
            
            if(model.getCourseById(newId) != null)
            {
                model.alertError("Course ID is alread exist. Use a unique ID.");
                event.consume();
            }            
            
            // validate title
            String newTitle = textTitle.getText();           
            if(newTitle.isEmpty())
            {
                model.alertError("Please enter the title of the course.");
                event.consume();
            }
            
            // validate credit
            int newCredit = 0;
            if(textCredit.getText().matches("[0-9]") && !textCredit.getText().equals("0"))
            {               
                newCredit = Integer.parseInt(textCredit.getText());
            }
            else
            {
                model.alertError("Credit must be an positive integer number.");
                event.consume();                
            }
            
            // validate category
            String newCategory = "";
            if(!comboCategory.getSelectionModel().isEmpty())
            {
                newCategory = comboCategory.getValue().toString();
            }
            else
            {
                model.alertError("Category is not slected.");
                event.consume();               
            }
            
            // add course and close this window
            Course c = new Course(newId, newTitle, newCredit, newCategory);
            model.addNewCourse(c);
            model.setReturnSelectedId(c.getId());
            stage.close();
        });
             
        // add event handler to the cancel button
        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
        {
            model.setReturnSelectedId(null);
            stage.close();
        });
        
    }    
    
    // it is called when this dialog is created
    public void setStage(Stage stage)
    {
        this.stage = stage;
    } 
    
    // modify setModel()
    public void setModel(CourseInventoryModel model)
    {
        this.model = model;
        comboCategory.setItems(FXCollections.observableArrayList(model.getCourseCategory()));
    }    
    
}
