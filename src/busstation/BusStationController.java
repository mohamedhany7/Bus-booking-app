/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class BusStationController implements Initializable {

    @FXML
    private Button signupBtn;
    @FXML
    private TextField usernameLabel;
    @FXML
    private PasswordField passwordLabel;
    @FXML
    private Button loginBtn;
    @FXML
    private static CheckBox remembermeCheckbox = new CheckBox();
    @FXML
    private static RadioButton passengerRadio= new RadioButton();
    @FXML
    private ToggleGroup type;
    @FXML
    private static RadioButton managerRadio = new RadioButton();
    @FXML
    private static RadioButton driverRadio = new RadioButton();

    /**
     * Initializes the controller class.
     */
    
    String username,password;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        usernameLabel.setStyle("-fx-text-inner-color: #a0a2ab;");
        passwordLabel.setStyle("-fx-text-inner-color: #a0a2ab;");
        passengerRadio.setSelected(true);
        if(BusStation.remember==true)
        {
            usernameLabel.setText(BusStation.remember_username);
            passwordLabel.setText(BusStation.remember_password);
            remembermeCheckbox.setSelected(true);
        }
        else remembermeCheckbox.setSelected(false);
        }
        
    
    @FXML
    public void loginAction (ActionEvent event) throws IOException{
        username = usernameLabel.getText();
        password = passwordLabel.getText();
        if(passengerRadio.isSelected()){
            boolean b;
            b = BusStation.check(BusStation.passenger_array,username, password);
            BusStation.getId(1);
            if(b==true){
                Parent customerApp = FXMLLoader.load(getClass().getResource("CustomerApp.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
            }
            else    {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong username and password,try again");
                alert.show();
            } 
        }
        else if (managerRadio.isSelected())
        {
                boolean b;
            b = BusStation.check(BusStation.manager_array,username, password);
            BusStation.getId(2);
            if(b==true){
                Parent customerApp = FXMLLoader.load(getClass().getResource("managerApp.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
            }
            else    {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong username and password,try again");
                alert.show();
            }
        }
        else if (driverRadio.isSelected())
        {
                boolean b;
            b = BusStation.check(BusStation.driver_array,username, password);
            BusStation.getId(3);
            if(b==true){
                Parent customerApp = FXMLLoader.load(getClass().getResource("DriverApp.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
            }
            else    {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong username and password,try again");
                alert.show();
            }
        }
    }
    @FXML
    public void signup(ActionEvent e) throws IOException{
                Parent customerApp = FXMLLoader.load(getClass().getResource("signup.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
    }
    
    public void selectpassanger(){
        passengerRadio.setSelected(true);
        managerRadio.setSelected(false);
        driverRadio.setSelected(false);
    }
    
    public void selectManager(){
        passengerRadio.setSelected(false);
        managerRadio.setSelected(true);
        driverRadio.setSelected(false);
    }
    
    public void selectDriver(){
        passengerRadio.setSelected(false);
        managerRadio.setSelected(false);
        driverRadio.setSelected(true);
    }
    
    public  void rememberme(){
        boolean b;
        b = remembermeCheckbox.isSelected();
        if (b == false){
        username = usernameLabel.getText();
        password = passwordLabel.getText();
        remembermeCheckbox.setSelected(true);
        BusStation.remember_password = password;
        BusStation.remember_username = username;
        BusStation.remember = true;
        }
        else {
            remembermeCheckbox.setSelected(false);
            BusStation.remember = false;
        }  
    }
}
