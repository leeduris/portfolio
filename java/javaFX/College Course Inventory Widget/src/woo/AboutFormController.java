package woo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutFormController implements Initializable 
{
    private Stage stage;

    @FXML
    private Button buttonClose;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // add a event handler to the close button
        buttonClose.setOnAction((event) -> stage.close());
    }   

    // it is called when this dialog is created
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }    
}
