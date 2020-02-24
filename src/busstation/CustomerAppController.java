/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CustomerAppController implements Initializable {

    @FXML
    private Pane holderpane;
    AnchorPane home;
    @FXML
    private AnchorPane Allpane;
    @FXML
    private Button homeBtn;
    @FXML
    private Button myticketBtn;
    @FXML
    private Label noticketLabel;
    @FXML
    private Button contactBtn;
    @FXML
    private Label notificationLabel;
    @FXML
    private Button signoutBtn;

    /**
     * Initializes the controller class.
     */
    
    public String notification = "No Notifications for now";
    String no_tickets = Integer.toString(BusStation.no_tickets);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        noticketLabel.setText(no_tickets);
        createpage();
    }    
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    public void home(ActionEvent event) throws IOException{
        createpage();
    }
    
    public void tickets(ActionEvent event) throws IOException{
        createmyTickets();
    }
    

    private void setnode(Node node){
        holderpane.getChildren().clear();
        holderpane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
    private void setnode2(Node node){
        Allpane.getChildren().clear();
        Allpane.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
    public void createpage(){
        try{
        home = FXMLLoader.load(getClass().getResource("CustomerMenu.fxml"));
        setnode(home);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void createmyTickets(){
        try{
        home = FXMLLoader.load(getClass().getResource("Trips.fxml"));
        setnode(home);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void signout(){
        try{
        home = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
        setnode2(home);
        BusStation.fillarray();
        Files f = new Files();
        f.openCustomerRead();
        f.readCustomer();
        f.openTripsRead();
        f.readTrips();
        f.openDriverRead();
        f.readdriver();
        f.openManagerRead();
        f.readManager();
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        }
        catch(IOException e){
            e.printStackTrace();
        }    
    }
    
    public void notifications(){
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setHeaderText("Notification");
                alert.setContentText(notification);
                alert.show();
    }
    
    public void setnumber(){
        noticketLabel.setText(no_tickets);
    }
}
