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
public class ManagerAppController implements Initializable {
    
    @FXML
    private Pane holderpane;
    AnchorPane home;
    @FXML
    private AnchorPane Allpane;
    @FXML
    private Button showBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button signoutBtn;
    @FXML
    private Label notificationLabel;

    /**
     * Initializes the controller class.
     */
    
    public String notification = "No Notifications for now";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
    public void showall(ActionEvent event) throws IOException{
        createshowall();
    }
    
    public void addttrips(ActionEvent event) throws IOException{
        createaddtrip();
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
    
    public void createshowall(){
        try{
        home = FXMLLoader.load(getClass().getResource("Alltrips.fxml"));
        setnode(home);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void createaddtrip(){
        try{
        home = FXMLLoader.load(getClass().getResource("addtrip.fxml"));
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
}
