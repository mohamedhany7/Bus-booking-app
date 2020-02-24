/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DriverinfoController implements Initializable {

    @FXML
    private Label firstnamelbl;
    @FXML
    private Label lastnamelbl;
    @FXML
    private Label agelbl;
    @FXML
    private Label genderlbl;
    @FXML
    private Label vehiclelbl;
    @FXML
    private Label hourslbl;
    @FXML
    private Label tripslbl;
    @FXML
    private Label nationlbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printall();
    }    

    public void printall(){
        Files f = new Files();
        f.getdrivertripsbyid(BusStation.driver_id);
        firstnamelbl.setText(BusStation.driver_array[BusStation.index][3]);
        lastnamelbl.setText(BusStation.driver_array[BusStation.index][4]);
        agelbl.setText(BusStation.driver_array[BusStation.index][5]);
        genderlbl.setText(BusStation.driver_array[BusStation.index][6]);
        vehiclelbl.setText(BusStation.driver_array[BusStation.index][8]);
        nationlbl.setText(BusStation.driver_array[BusStation.index][7]);
        hourslbl.setText(BusStation.driver_array[BusStation.index][9]);
        tripslbl.setText(BusStation.driver_array[BusStation.index][10]);
        }
    
}
