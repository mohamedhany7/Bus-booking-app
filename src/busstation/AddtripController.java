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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AddtripController implements Initializable {

    @FXML
    private TextField sourceTxt;
    @FXML
    private TextField destTxt;
    @FXML
    private TextField stopsTxt;
    @FXML
    private TextField priceTxt;
    @FXML
    private RadioButton internalRadio = new RadioButton();
    @FXML
    private ToggleGroup trip;
    @FXML
    private RadioButton externalRadio= new RadioButton();
    @FXML
    private RadioButton busRadio= new RadioButton();
    @FXML
    private ToggleGroup vehicle;
    @FXML
    private RadioButton miniRadio= new RadioButton();
    @FXML
    private RadioButton limosineRadio= new RadioButton();
    @FXML
    private ComboBox Btn;
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillsplit();
        setbuttons();
    }    
    
    public void setbuttons(){
        miniRadio.setSelected(false);
        limosineRadio.setSelected(false);
        busRadio.setSelected(true);
        externalRadio.setSelected(false);
        internalRadio.setSelected(true);
    }
    public void cleartext(){
        sourceTxt.clear();
        destTxt.clear();
        stopsTxt.clear();
        priceTxt.clear();
    }
    public void setminiradio(){
        miniRadio.setSelected(true);
        limosineRadio.setSelected(false);
        busRadio.setSelected(false);
    }
    public void setlimosineradio(){
        miniRadio.setSelected(false);
        limosineRadio.setSelected(true);
        busRadio.setSelected(false);
    }
    public void setbusradio(){
        miniRadio.setSelected(false);
        limosineRadio.setSelected(false);
        busRadio.setSelected(true);
    }
    public void setexternalradio(){
        externalRadio.setSelected(true);
        internalRadio.setSelected(false);
    }
    public void setinternalradio(){
        externalRadio.setSelected(false);
        internalRadio.setSelected(true);
    }
    
    public void addbutton(){
        String a,b,c,d,e,f,g,h;
        e = " ";
        g = " ";
        f = " ";
        b=sourceTxt.getText();
        c=destTxt.getText();
        d=stopsTxt.getText();
        h=priceTxt.getText();
        if (busRadio.isSelected()){
            e="Bus";
            g="30";
        }
        if (miniRadio.isSelected()){
            e="MiniBus";
            g="15";
        }
        if (limosineRadio.isSelected()){
            e="Limosine";
            g="3";
        }
        if (externalRadio.isSelected())
            f="external";
        if (internalRadio.isSelected())
            f="internal";
        
        int k;
        Object value = Btn.getValue();
        String str = (String) value;
        String[] words=null;
        if (str == null)
        {
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("You must choose a driver");
                alert.show();
        }
        words=str.split("\\s");   
            for(String w:words){
                str=w;
            }
        k = Integer.valueOf(str);
        
        if (!b.isEmpty() && !c.isEmpty() && !d.isEmpty() && !h.isEmpty())
        {
        Files f1 = new Files();
        f1.openaddTripsRead();
        f1.readalltrips();
        a = Integer.toString(BusStation.trip_id);
        f1.openaddedtripsFile();
        f1.writeaddedTrips(a,b,c,d,e,f,h,g,BusStation.driver_array[k-1][0]);
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Added successfully");
                alert.show();
        
        setbuttons();
        cleartext();
        }
        
        else {
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("You must fill all the fields");
                alert.show();
        }
    }
    
    public void fillsplit(){
        int i;
        for (i=0;i<BusStation.no_driver;i++)
            Btn.getItems().add(BusStation.driver_array[i][3] + " " + BusStation.driver_array[i][4] + " " + (i+1));
            Btn.setVisibleRowCount(3);
    }
}
