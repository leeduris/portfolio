package woo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchFormController implements Initializable 
{
    private Stage stage;
    private CourseInventoryModel model;
    private MainFormController maincontroller;
    private String selectedId;
    

    @FXML
    private RadioButton radioId;
    @FXML
    private RadioButton radioTitle;
    @FXML
    private ToggleGroup radioGroup;
    @FXML
    private TextField textSearch;
    @FXML
    private Button buttonSearch;
    @FXML
    private ListView listIdTitle;
    @FXML
    private Button buttonSelect;
    @FXML
    private Button buttonCancel;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {   
        // instance MainFormController Class
        maincontroller = new MainFormController();
        
        // add changelistener to listview
        listIdTitle.getSelectionModel().selectedItemProperty().addListener
        ((ov, oldValue, newValue) -> 
        {   
            if(newValue != null)
            {
                selectedId = newValue.toString().split(":")[0].trim(); 
            }
            else
                selectedId = null;
                    
        });

        // add event handler to search button,  
        buttonSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
        {
            // if id radio button is selecred, search by id
            if(radioId.isSelected())
            {
                // convert to upper case
                String searchedId = textSearch.getText().toUpperCase();
                
                // convert ArrayList<> to ObservableList<>
                listIdTitle.setItems(FXCollections.observableArrayList(model.searchCourseById(searchedId)));
            }
            
            // if title radio button is selecred, search by title
            if(radioTitle.isSelected()) 
            {
                // convert to upper case
                String searchedTitle = textSearch.getText().toUpperCase();
 
                // convert ArrayList<> to ObservableList<>
                listIdTitle.setItems(FXCollections.observableArrayList(model.searchCourseByTitle(searchedTitle)));
            }
        });
                
        // add a event handler to the select button
        buttonSelect.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
        {
            // extract ID only from listview
            model.setReturnSelectedId(selectedId);
            
            // close this window
            stage.close();
        });
        
        // add a event handler to the cnacel button
        buttonCancel.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) ->
        {
            // give null value at a cancellation
            model.setReturnSelectedId(null);
            listIdTitle.getItems().clear();
            
            // close this window
            stage.close();
        });
    }  
    
    // it is called when this dialog is created
    public void setStage(Stage stage)
    {
        this.stage = stage;
    } 
    
    // it is called by MainFormController after this window created
    public void setModel(CourseInventoryModel model)
    {
        this.model = model;
    }  
    
}
