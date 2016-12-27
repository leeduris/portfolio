/////////////////////////////////////////////
// WebBrowserAssign3.java
// ================
// Start of MVC Classes.
//
// AUTHOR: Sung Woo Lee (leeduris@gmail.com)
// CREATED: 2016-03-14
// UPDATED: 2016-03-23
/////////////////////////////////////////////

package woo;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebBrowserAssign3 extends Application {

    @Override
    public void start(Stage stage) throws Exception 
    {
        URL url = getClass().getResource("MainForm.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(url);
        Parent root = (Parent) fxmlloader.load();
        
        Scene scene = new Scene(root);
        
        // Set the window title of this browser
        stage.setTitle("Don't Go Around, Love Finding Something New On My Web");
        
        stage.setScene(scene);
        stage.show();
        
        // pass stage to the controller object
        MainFormController controller = fxmlloader.getController();
        controller.setStage(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
