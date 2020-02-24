/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class SignupController implements Initializable {

    @FXML
    private Button signupBtn;
    @FXML
    private TextField usernamelbl;
    @FXML
    private PasswordField passlbl;
    @FXML
    private PasswordField repasslbl;
    @FXML
    private RadioButton passengerRadio;
    @FXML
    private RadioButton managerRadio;
    @FXML
    private ToggleGroup type;
    @FXML
    private RadioButton driverRadio;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     */
    
        String username,password,repassword;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernamelbl.setStyle("-fx-text-inner-color: #a0a2ab;");
        passlbl.setStyle("-fx-text-inner-color: #a0a2ab;");
        repasslbl.setStyle("-fx-text-inner-color: #a0a2ab;");
        }
    
    @FXML
    public void signupAction (ActionEvent event) throws IOException{
        username = usernamelbl.getText();
        password = passlbl.getText();
        repassword = repasslbl.getText();
            int b;
            b = password.compareTo(repassword);
            if(b==0 && password.length()>=4){
                createUser();
                Alert alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("You have created your account");
                alert.show();
                Parent customerApp = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
            }
            
            else if (password.length()<4){
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("The password must be more than 4 digits,try again");
                alert.show();
            }
            else   {
                Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("The password is not the same,try again");
                alert.show();
            } 
    }
    @FXML
    public void login(ActionEvent e) throws IOException{
                Parent customerApp = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
    }
    
    public void createUser(){
        username = usernamelbl.getText();
        password = passlbl.getText();
        Files f = new Files();
        f.openCustomerFile();
        f.writeCustomer(username, password);
        f.openCustomerRead();
        f.readCustomer();
    }
    
    }    
    
