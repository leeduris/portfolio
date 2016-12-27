/////////////////////////////////////////////
// MainForm.java
// ================
// C in MVC Classes.
//
// AUTHOR: Sung Woo Lee (leeduris@gmail.com)
// CREATED: 2016-03-14
// UPDATED: 2016-03-23
/////////////////////////////////////////////

package woo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainFormController implements Initializable {
    
    private Stage stage;
    WebBrowserModel model;
    
    @FXML
    private Button prevButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button goButton;
    @FXML
    private TextField goUrl;
    @FXML
    private WebView webView;
    @FXML
    private ProgressBar processBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // invoke to use Model component
        model = new WebBrowserModel();  
        
        // make background image visible before loading web page
        webView.setOpacity(0);
        
        prevButton.setDisable(true);
        nextButton.setDisable(true);
    }    
    
    // remember the owner window
    public void setStage(Stage stage)
    {
        this.stage = stage;
    }  

    @FXML
    private void handlePrevButton(ActionEvent event) 
    {
        // store user's previous URL
        String url = model.prev();
        
        // URL string cannot be empty
        if(url.isEmpty())
            return;
        
        // load web browser
        load(url);
    }

    @FXML
    private void handleNextButton(ActionEvent event) 
    {
        // store user's next URL
        String url = model.next();  
        
        // URL string cannot be empty
        if(url.isEmpty())
            return;
        
        // load web browser
        load(url);
    }

    @FXML
    private void handleGo(ActionEvent event) 
    {
        // store user's inputed URL
        String url = goUrl.getText();     
        
        // URL string cannot be empty
        if(url.isEmpty())
            return;

        // URL must start with “http://” or “https://”
        Boolean http = !url.startsWith("http://") && !url.startsWith("https://");
        if(http)
            url = (new StringBuilder()).append("http://").append(url).toString();        
        
        // push a new URL into stack array
        model.push(url);
        
        // load web browser
        load(url);    
    }
    
    // launch web engine
    public void load(String url)
    {       
        // The url in textfield must be updated
        goUrl.setText(url);
        
        // load process bar
        processBar();
        
        // load requested URL
        webView.getEngine().load(url);   
      
        // make background image invisible after loading web page
        webView.setOpacity(1);    

        // visible prev button at having history
        if(model.currentIndex > 0)
            prevButton.setDisable(false);
        else
            prevButton.setDisable(true);

        // visible next button at having history
        if(model.getCurrentIndex() < model.getStack().size() - 1)
            nextButton.setDisable(false);
        else
            nextButton.setDisable(true);
    }   
    
    // launch process bar
    public void processBar()
    {
        // start process bar
        processBar.setVisible(true);
        
        // binding process bar with web loading 
        Worker worker = webView.getEngine().getLoadWorker();
        processBar.progressProperty().bind(worker.progressProperty());
        
        // add changing listener 
        worker.stateProperty().addListener(new Listerner());
    }
    
    // implement ChangeListener
    class Listerner implements ChangeListener 
    {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) 
        {
            // complete or finish process bar
            if(newValue == Worker.State.SUCCEEDED || newValue == 
               Worker.State.FAILED || newValue == Worker.State.CANCELLED)
            {
                processBar.setVisible(false);
            }
        }        
    }
}
 


