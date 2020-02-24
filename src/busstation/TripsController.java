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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TripsController implements Initializable {
    
    @FXML
    private AnchorPane holderpane;
    AnchorPane home;
    @FXML
    private TextArea trip1Lbl;
    @FXML
    private TextArea trip2Lbl;
    @FXML
    private TextArea trip3Lbl;
    @FXML
    private TextArea trip4Lbl;
    @FXML
    private Label nomsg;
    @FXML
    private Button trip1Btn;
    @FXML
    private Button trip2Btn;
    @FXML
    private Button trip3Btn;
    @FXML
    private Button trip4Btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setinvisable();
        Files f = new Files();
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        printing();
    }    
    
    public void setinvisable(){
        trip1Btn.setVisible(false);
        trip2Btn.setVisible(false);
        trip3Btn.setVisible(false);
        trip4Btn.setVisible(false);
        trip1Lbl.setVisible(false);
        trip2Lbl.setVisible(false);
        trip3Lbl.setVisible(false);
        trip4Lbl.setVisible(false);
    }

    private void printing() {
        switch (BusStation.no_tickets){
            case 0: nomsg.setText("You don't have tickets");
                break;
            case 1: print1();
                break;
            case 2: print2();
                break;
            case 3: print3();
                break;
            case 4: print4();
                break;
        }
    }

    private void print1() {
        int i=0;
        String str;
        trip1Btn.setVisible(true);
        trip1Lbl.setVisible(true);
        str = "Source: " + BusStation.tickets_array[i][0] + "\n" + "Destination: " + BusStation.tickets_array[i][1] + "\n"
                + "Stops no.: " + BusStation.tickets_array[i][2] + "\n"+ "Vehicle type: " + BusStation.tickets_array[i][3] + "\n"
                + "Trip type: " + BusStation.tickets_array[i][4] + "\n"+ "Way type: " + BusStation.tickets_array[i][5] + "\n"
                + "Price: " + BusStation.tickets_array[i][6] +"$"; 
        trip1Lbl.setText(str);
    }
    
    private void print2() {
        print1();
        int i=1;
        String str;
        trip2Btn.setVisible(true);
        trip2Lbl.setVisible(true);
        str = "Source: " + BusStation.tickets_array[i][0] + "\n" + "Destination: " + BusStation.tickets_array[i][1] + "\n"
                + "Stops no.: " + BusStation.tickets_array[i][2] + "\n"+ "Vehicle type: " + BusStation.tickets_array[i][3] + "\n"
                + "Trip type: " + BusStation.tickets_array[i][4] + "\n"+ "Way type: " + BusStation.tickets_array[i][5] + "\n"
                + "Price: " + BusStation.tickets_array[i][6] +"$"; 
        trip2Lbl.setText(str);
    }
    
    private void print3() {
        print1();
        print2();
        int i=2;
        String str;
        trip3Btn.setVisible(true);
        trip3Lbl.setVisible(true);
        str = "Source: " + BusStation.tickets_array[i][0] + "\n" + "Destination: " + BusStation.tickets_array[i][1] + "\n"
                + "Stops no.: " + BusStation.tickets_array[i][2] + "\n"+ "Vehicle type: " + BusStation.tickets_array[i][3] + "\n"
                + "Trip type: " + BusStation.tickets_array[i][4] + "\n"+ "Way type: " + BusStation.tickets_array[i][5] + "\n"
                + "Price: " + BusStation.tickets_array[i][6] +"$"; 
        trip3Lbl.setText(str);
    }
    
    private void print4() {
        print1();
        print2();
        print3();
        int i=3;
        String str;
        trip4Btn.setVisible(true);
        trip4Lbl.setVisible(true);
        str = "Source: " + BusStation.tickets_array[i][0] + "\n" + "Destination: " + BusStation.tickets_array[i][1] + "\n"
                + "Stops no.: " + BusStation.tickets_array[i][2] + "\n"+ "Vehicle type: " + BusStation.tickets_array[i][3] + "\n"
                + "Trip type: " + BusStation.tickets_array[i][4] + "\n"+ "Way type: " + BusStation.tickets_array[i][5] + "\n"
                + "Price: " + BusStation.tickets_array[i][6] +"$"; 
        trip4Lbl.setText(str);
    }
    
    public void cancel1(){
        Files f = new Files();
        f.edit(BusStation.ticket_line[0]);
        createmyTickets();
    }
    
    public void cancel2(){
        Files f = new Files();
        f.edit(BusStation.ticket_line[1]);
        createmyTickets();
    }
    
    public void cancel3(){
        Files f = new Files();
        f.edit(BusStation.ticket_line[2]);
        createmyTickets();
    }
    
    public void cancel4(){
        Files f = new Files();
        f.edit(BusStation.ticket_line[3]);
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
    
    public void createmyTickets(){
        try{
        home = FXMLLoader.load(getClass().getResource("Trips.fxml"));
        setnode(home);
        }
        catch(IOException e){
            e.printStackTrace();
        }    
    }
    
    public void setnumber(ActionEvent event) throws IOException{
       // CustomerAppController c = new CustomerAppController();
        //c.setnumber();
        Parent customerApp = FXMLLoader.load(getClass().getResource("CustomerApp.fxml"));
                Scene customerApp_scene = new Scene (customerApp);
                Stage App_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App_stage.setScene(customerApp_scene);
                App_stage.show();
    }
    
}
