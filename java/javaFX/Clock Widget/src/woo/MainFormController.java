package woo;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFormController implements Initializable 
{
    private Stage stage;
    private double stageX;
    private double stageY;
    private double mouseX;
    private double mouseY;
    
    @FXML
    private Label labeldisplay;
    
    @FXML
    private MenuItem contextexit;
    @FXML
    private AnchorPane paneclock;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // set the label with the current time
            labeldisplay.setText(getCurrentTime());
            
        // create KeyFrame with Duration and ActionEvent EventHandler
        KeyFrame keyframe = new KeyFrame(Duration.millis(1000), event -> 
        {
            // update the label with the current time
            labeldisplay.setText(getCurrentTime());
        });
        
        // set Timeline with KeyFrame, then start to play
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();    
        
        // implement context menu to terminate the widget
        contextexit.setOnAction( e -> Platform.exit());
        
        // make the borderless window moveable using mouse entered event
        paneclock.setOnDragEntered(e -> 
        {
            // get scene and change the cursor
            Scene scene = (Scene)labeldisplay.getParent().getScene();
            scene.setCursor(Cursor.MOVE);
        });       

        // make the borderless window moveable using mouse pressed event
        paneclock.setOnMousePressed(e -> 
        {    
            // store positions of stage and mouse 
             stageX = stage.getX();
             stageY = stage.getY();
             mouseX = e.getScreenX();
             mouseY = e.getScreenY();
        });
                
        // make the borderless window moveable using mouse dragged event
        paneclock.setOnMouseDragged(e -> 
        {
            // compute the distance of stage movement
            double differX = e.getScreenX() - mouseX; 
            double differY = e.getScreenY() - mouseY;
            
            // re-position the stage
            stage.setX(stageX + differX);
            stage.setY(stageY + differY);
        });    
                    
    }
    
    // implement this method to return the current time 
    public String getCurrentTime()
    {
        // construct time string
        LocalTime time = LocalTime.now();
        String timeStr = time.format(DateTimeFormatter.ofPattern("hh: mm: ss a"));
        
        return timeStr;
    }
    
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

}
