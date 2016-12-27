package woo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CourseInventory_leesungwoo extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        // load scene graph
        URL url = getClass().getResource("MainForm.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(url);
        Parent root = (Parent) fxmlloader.load();
        
        // create scene and attach the root node of my scene
        Scene scene = new Scene(root);        

        // create a stage and attach the scene
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        stage.setTitle("My Final Project : Course Inventory");
        stage.setScene(scene);        
        stage.show();
        
        // tell controller who is your owner 
        MainFormController controller = fxmlloader.getController();
        controller.setStage(stage);
     }   

    public static void main(String[] args) {
        launch(args);
    }
    
}
