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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class AlltripsController implements Initializable {

    @FXML
    private AnchorPane holderpane;
    AnchorPane home;
    @FXML
    private TextArea triplbl;
    @FXML
    private ComboBox btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        printall();
        fillsplit();
    }    
    
    public void printall(){
        int i;
        String str;
        String str2 = " ";
        Files f = new Files();
        f.readalltrips();
        for(i=0;i<BusStation.no_all_trips;i++){
            str=BusStation.alltrips_array[i];
            String[] words=str.split("\\s");   
            str2 ="Trip " + (i+1) + ":" +"\n";
            triplbl.appendText(str2);
            for(String w:words){
                triplbl.appendText(w + "\n");
            }
            triplbl.appendText("-------------------------------" + "\n");
        }
    }
    
    public void fillsplit(){
        int i;
        for (i=0;i<BusStation.no_all_trips;i++)
            btn.getItems().add("Trip " + (i+1));
            btn.setVisibleRowCount(3);
    }
    
    public void delete(){
        int k;
        Object value = btn.getValue();
        String str = (String) value;
        if (str == null)
        {
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("You must choose a trip");
                alert.show();
        }
        String[] words=str.split("\\s");   
            for(String w:words){
                str=w;
            }
        k = Integer.valueOf(str);
        Files f = new Files();
        f.deletetrip(k-1);
        createtrips();
        
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
    
    public void createtrips(){
        try{
        home = FXMLLoader.load(getClass().getResource("Alltrips.fxml"));
        setnode(home);
        }
        catch(IOException e){
            e.printStackTrace();
        }    
    }
}
