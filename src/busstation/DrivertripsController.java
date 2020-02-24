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
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DrivertripsController implements Initializable {

    @FXML
    private TextArea txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        print();
    }    
    
    private void print() {
         int i;
        String str;
        String str2 = " ";
        Files f = new Files();
        f.getdrivertripsbyid(BusStation.driver_id);
        for(i=0;i<Integer.valueOf(BusStation.driver_array[BusStation.index][10]);i++){
            str=BusStation.tempdrivertrips_array[i];
            String[] words=str.split("\\s");   
            str2 ="Trip " + (i+1) + ":" +"\n";
            txt.appendText(str2);
            for(String w:words){
                txt.appendText(w + "\n");
            }
            txt.appendText("-------------------------------" + "\n");
        }
    }
}
