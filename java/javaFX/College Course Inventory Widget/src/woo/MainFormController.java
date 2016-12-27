package woo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainFormController implements Initializable 
{
    private Stage stage;
    private CourseInventoryModel model;
    private Course course;
    private String selectedCategory;
    private String selectedId;
    private File file;
    
    @FXML
    private MenuItem menuOpen;    
    @FXML
    private MenuItem menuSave;
    @FXML
    private MenuItem menuExit;   
    @FXML
    private MenuItem menuEdit;
    @FXML
    private MenuItem menuAdd;
    @FXML
    private MenuItem menuDelete;
    @FXML
    private MenuItem menuSearch;
    @FXML
    private MenuItem menuAbout;
    @FXML
    private ComboBox comboCategory;
    @FXML
    private ListView<String> listId;
    @FXML
    private Button buttonSearch;
    @FXML
    private TextField textTitle;
    @FXML
    private TextField textCredit;    
    @FXML
    private ComboBox<String> comboCategory2;    
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;    
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Label labelStatus;

    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // create model component
        model = new CourseInventoryModel(); 
        
        // initial status
        initialStatus();
        
        // toast current status label
        labelStatus.setText("Open a Course List File from File -> Open Menu.");   
        
        // add change listener to list view(course id) using lambda expresion
        listId.getSelectionModel().selectedItemProperty().addListener
        ((ov, oldValue, newValue) -> 
        {   
            if(newValue != null)
            {
                selectedId = newValue.toString();            
                setTextField(selectedId);
                
                // toast current status label
                labelStatus.setText(selectedId + " is Selected.");
                
            }
        });
      
        // add change listener to the combobox(category) using lambda expresion
        comboCategory.getSelectionModel().selectedItemProperty().addListener
        ((ov, oldValue, newValue) -> 
        {
            if(newValue != null)
            {
                selectedCategory = newValue.toString();
                setListView(selectedCategory);
            
                // toast current status label
                labelStatus.setText(selectedCategory + " Category is Selected.");
            }
            
        });
        
        // make a event handler for search button           
        EventHandler<ActionEvent> searchHandler = (event) -> 
        {
            try {

                // load scene graph
                URL urlsearch = getClass().getResource("SearchForm.fxml");
                FXMLLoader fxmlloader = new FXMLLoader(urlsearch);                
                Parent root = (Parent) fxmlloader.load();
        
                // create scene and attach the root node of my scene
                Scene scene = new Scene(root);
        
                // create a stage and attach the scene
                Stage stage = new Stage();   
                stage.setScene(scene);
                stage.setTitle("Search Course");              
                stage.initModality(Modality.APPLICATION_MODAL);
                        
                // tell controller who is your owner 
                SearchFormController searchformcontroller = fxmlloader.getController();
                searchformcontroller.setStage(stage);
                
                // attach the model  
                searchformcontroller.setModel(model);  
                
                // wait user response within this block
                stage.showAndWait();
                
                // invoke the setTextField method
                String id = model.getReturnSelectedId();
                setTextField(id);
                                     
                // toast current status label
                if(id == null)
                   labelStatus.setText("Search was Cancelled.");
                else
                   labelStatus.setText("Selected " + id + ".");               
            } 
            
            catch (IOException e) 
            {
                System.err.print("[Open Error] " + e.getMessage());                
            }
        };
        
        // add a event hanlder to the search button and the search menu
        buttonSearch.setOnAction(searchHandler);
        menuSearch.setOnAction(searchHandler);

        
        // make a event handler for add button
        EventHandler<ActionEvent> addHandler = (event) -> 
        {
            try {
                // load scene graph
                URL urladd = getClass().getResource("AddForm.fxml");
                FXMLLoader fxmlloader = new FXMLLoader(urladd);
                Parent root = (Parent) fxmlloader.load();
        
                // create scene and attach the root node of my scene
                Scene scene = new Scene(root);
        
                // create a stage and attach the scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Add New Course");              
                stage.initModality(Modality.APPLICATION_MODAL);
        
                // tell controller who is your owner 
                AddFormController addformcontroller = fxmlloader.getController();
                addformcontroller.setStage(stage);
                
                // attach the model   
                addformcontroller.setModel(model);

                // wait user response within this block
                stage.showAndWait();

                // invoke the methods
                String id = model.getReturnSelectedId();
                setTextField(id);                
                setListView(selectedCategory);      
                comboCategory.getSelectionModel().selectFirst();
                
                // save a new course
                if(id != null)
                {
                    model.saveCourseFile(file);                   
                }

                // toast current status label
                if(id != null)
                    labelStatus.setText("Added a New Course " + id + " is Added to the List.");
                else
                    labelStatus.setText("Adding a New Course was Cancelled .");
            }
            
            catch (IOException e)
            {
                System.err.print("[Open Error] " + e.getMessage());
            }
        };   
        
        // add a event hadler to the add button and the add menu
        buttonAdd.setOnAction(addHandler);
        menuAdd.setOnAction(addHandler);
        
        // make a event hadler for the edit button
        EventHandler<ActionEvent> editHandler =  (event) -> 
        {
            // enable/disable controls
            initialStatus();
            menuEdit.setDisable(false);
            buttonEdit.setDisable(false);
            textTitle.setDisable(false);
            textCredit.setDisable(false);
            comboCategory2.setDisable(false);
            buttonSave.setDisable(false);
            buttonCancel.setDisable(false);
            
            // attatch category data
            comboCategory2.setUserData(model.getCourseCategory());
            
            // toast current status label
            labelStatus.setText("Modify Title, Credit and Category, then "
                                + "Click 'Save' or 'Cancel' Button.");
        }; 
        
        // add a event handler to the edit button and the edit menu 
        buttonEdit.setOnAction(editHandler);
        menuEdit.setOnAction(editHandler);
            
        // add button save event handler
        EventHandler<ActionEvent> saveHandler = (event) -> 
        {   
            // confirm saving
            if(model.alertConfirm("Do you want to save the changes ?") == "cancel")
            {
               setTextField(selectedId);
               return;                 
            }
            
            // validate title
            String newTitle = textTitle.getText();
            if(newTitle.isEmpty())
            {
                // alert for validation
                model.alertError("Please enter the title of the course.");
                return;
            }
            
            // validate credit
            int newCredit;
            if(textCredit.getText().matches("[0-9]") && !textCredit.getText().equals("0"))
            {               
                newCredit = Integer.parseInt(textCredit.getText());
            }
            else
            {
                // alert for validation
                model.alertError("Credit must be an positive integer number.");
                return;                
            }
            
            // validate category
            String newCategory;
            if(!comboCategory.getSelectionModel().isEmpty())
            {
                newCategory = comboCategory.getValue().toString();
            }
            else
            {
                // alert for validation
                model.alertError("Category is not slected.");
                return;                
            }
            
            // finally, update the course
            Course c = new Course(selectedId, newTitle, newCredit, newCategory);
            model.updateCourse(c);
            model.saveCourseFile(file);
            setTextField(selectedId);  
            
            // toast current status label
            labelStatus.setText("Updated the Course " + selectedId + ".");

        };
        
        // add a event handler to the save button
        buttonSave.setOnAction(saveHandler);
        
        // make a event handler for the cancel button
        EventHandler<ActionEvent> cancelHandler =  (event) -> 
        {   
            // re-select the course and enable/disable controls
            setTextField(selectedId);

            // toast current status label
            labelStatus.setText("Cancelled Editing " + selectedId + ".");

        };
        
        // add a event handler to the cancel button
        buttonCancel.setOnAction(cancelHandler);
        
        // make a event handler for the delete button
        EventHandler<ActionEvent> deleteHandler =  (event) -> 
        {   
            // confirm deletion using alert
            if(model.alertConfirm("Do you want to delete the course " + selectedId + " ?") == "cancel")
                event.consume();
            else
            {
                // get selected ID from listview
                String selectedId = listId.getSelectionModel().getSelectedItem().toString();
                
                // delete the course and save to the file
                model.deleteCourse(selectedId);
                
                // reload course list
                setListView(selectedCategory);  
                comboCategory.getSelectionModel().select(0);
                
                // enable/disable controls
                initialStatus();  
                menuEdit.setDisable(true);
                menuAdd.setDisable(false);
                menuSearch.setDisable(false);
                comboCategory.setDisable(false);
                listId.setDisable(false);       
                buttonSearch.setDisable(false);
                buttonAdd.setDisable(false);
            
            // toast current status label
            if(selectedId == null)
                labelStatus.setText("Deleted a Course was Cancelled.");    
            else
                labelStatus.setText("Deleted a Course " + selectedId +" from the List.");    
            }            
        };
        
        // add a event handler to the delete button and delete menu
        buttonDelete.setOnAction(deleteHandler); 
        menuDelete.setOnAction(deleteHandler);

    }   
         
    public void setStage(Stage stage)
    {
        this.stage = stage;
        
                
        // add button window exit event handler
        stage.setOnCloseRequest( event -> 
        {   
            // confirm exit using alert
            if(model.alertConfirm("Do you really want to exit the program ?") == "cancel")
                event.consume();
            else
            {
                // terminate program
                Platform.exit();
            }
        }); 
    }    
    
    public void setModel(CourseInventoryModel model)
    {
        this.model = model;
    } 
    
    @FXML
    private void handleMenuOpen(ActionEvent event) 
    {
        // open a file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Course List File...");
        fileChooser.getExtensionFilters().addAll(
                                new ExtensionFilter("All Files", "*.*"),
                                new ExtensionFilter("DAT","*.dat" ),
                                new ExtensionFilter("TXT", "*.txt"));
        
        file = fileChooser.showOpenDialog(stage);
        
        // stop following process at value of null
        if(file == null)
            event.consume();
        
        // pass file to Model component to read     
        model.readCourseFile(file);    
        
        // populate items(course categories) in ComboBox
        comboCategory.setItems(FXCollections.observableArrayList(model.getCourseCategory()));
        comboCategory.getItems().add(0, "All Categories");
        comboCategory.getSelectionModel().selectFirst();
        
        // display course ids in the listview
        listId.setItems(FXCollections.observableArrayList(model.getCourseID()));
        
        // enable/disable controls
        initialStatus();
        menuAdd.setDisable(false);
        menuSearch.setDisable(false);
        comboCategory.setDisable(false);
        listId.setDisable(false); 
        buttonSearch.setDisable(false);
        buttonAdd.setDisable(false);
        
        // toast current status label
        labelStatus.setText("Loaded " + model.getCourseID().size() + " Courses from courses.dat.");
    }

    @FXML
    private void handleMenuSave(ActionEvent event) 
    {
        // save file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Course List File As...");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"),
                                              new ExtensionFilter("DAT", "*.dat"),
                                              new ExtensionFilter("TXT", "*.txt"));
        file = fileChooser.showSaveDialog(stage);
        if(!file.exists())
            event.consume();
        
        // save the file using model component
        int countCourse = model.saveCourseFile(file);   
        
        // toast current status label
        labelStatus.setText("Saved " + countCourse + " Courses to " + file.getName());
    
    }
    
    @FXML
    private void handleMenuExit(ActionEvent event) 
    {
        // confirm exit using alert
        if(model.alertConfirm("Do you really want to exit the program ?") == "cancel")
                event.consume();
        else
        {
            // terminate program
            Platform.exit();
        }        
    }

    @FXML
    private void handleMenuAbout(ActionEvent event) throws IOException
    {
        // load scene graph
        URL urlabout = getClass().getResource("AboutForm.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(urlabout);                
        Parent root = (Parent) fxmlloader.load();
        
        // create scene and attach the root node of my scene
        Scene scene = new Scene(root);
        
        // create a stage and attach the scene
        Stage stage = new Stage();   
        stage.setScene(scene);
        stage.setTitle("About");              
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
        // tell controller who is your owner 
        AboutFormController aboutformcontroller = fxmlloader.getController();
        aboutformcontroller.setStage(stage);
        
    }
    
    // set control values with selected course id
    private void setTextField(String selectedId) 
    {
        if(selectedId != null)
        {
            // set category value and course id at a slelected course id
            listId.getSelectionModel().select(selectedId);
            
            // focus on the new item
            listId.getFocusModel().focus(selectedId.indexOf(selectedId));
            listId.scrollTo(selectedId);
            
            // set title/credit/category values at a slelected course id
            textTitle.setText(model.getCourseById(selectedId).getTitle());
            textCredit.setText(String.valueOf(model.getCourseById(selectedId).getCredit()));
            comboCategory2.getSelectionModel().select(model.getCourseById(selectedId).getCategory());
        
            // enable/disable controls
            initialStatus();
            menuEdit.setDisable(false);
            menuAdd.setDisable(false);
            menuDelete.setDisable(false);
            menuSearch.setDisable(false);
            comboCategory.setDisable(false);
            listId.setDisable(false);       
            buttonSearch.setDisable(false);
            buttonEdit.setDisable(false);
            buttonDelete.setDisable(false);
            buttonAdd.setDisable(false);         
        }    
        else
            return;
    }

    // set control values with selected course category
    private void setListView(String selectedCategory) 
    {   
        // list course ids at a slelected category
        listId.setItems(FXCollections.observableList(model.getIdByCategory(selectedCategory)));
        
        
        // give null value to title/credit/category at a slelected category
        textTitle.setText("");
        textCredit.setText("");
        comboCategory2.getSelectionModel().select("");
    }
    
    // initial enable/disable controls at the beginning
    private void initialStatus()
    {
        menuEdit.setDisable(true);
        menuAdd.setDisable(true);
        menuDelete.setDisable(true);
        menuSearch.setDisable(true);
        comboCategory.setDisable(true);
        listId.setDisable(true);       
        textTitle.setDisable(true);
        textCredit.setDisable(true);
        comboCategory2.setDisable(true);
        buttonSearch.setDisable(true);
        buttonEdit.setDisable(true);
        buttonDelete.setDisable(true);
        buttonAdd.setDisable(true);
        buttonSave.setDisable(true);
        buttonCancel.setDisable(true); 
    }

}