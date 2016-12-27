/////////////////////////////////////////////
// Clock Widget Assign 4.java
// ================
//
// AUTHOR: Sung Woo Lee (leeduris@gmail.com)
// CREATED: 2016-04-02
// UPDATED: 2016-04-02
/////////////////////////////////////////////
package woo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClockWidget_leesungwoo extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

       // load scene graph
        URL url = getClass().getResource("MainForm.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(url);
        Parent root = (Parent) fxmlloader.load();
        
        // create scene and attach the root node of my scene
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        // create a stage and attach the scene
        stage.setTitle("Woo Clock");
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.TRANSPARENT);
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
