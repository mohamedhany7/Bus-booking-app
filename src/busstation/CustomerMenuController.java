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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class CustomerMenuController implements Initializable {

    @FXML
    private TextArea internalBusText;
    @FXML
    private Button internalbusbookBTN;
    @FXML
    private ComboBox internalbuscombo;
    @FXML
    private Label internalBusTicketno;
    @FXML
    private Button internalBusincBtn;
    @FXML
    private Button internalBusdecBtn;
    @FXML
    private RadioButton internalBusOnewayRadio;
    @FXML
    private ToggleGroup trip;
    @FXML
    private RadioButton internalBusRoundtripRadioBtn;
    @FXML
    private TextArea externalBusText;
    @FXML
    private Button externalbusbookBTN;
    @FXML
    private Label externalBusTicketno;
    @FXML
    private Button externalBusincBtn;
    @FXML
    private ComboBox externalBuscombo;
    @FXML
    private RadioButton externalBusOnewayRadio;
    @FXML
    private ToggleGroup trip1;
    @FXML
    private RadioButton externalBusRoundtripRadio;
    @FXML
    private Button externalBusdecbtn;
    @FXML
    private TextArea internalMiniText;
    @FXML
    private Button internalminibookBTN;
    @FXML
    private ComboBox internalMinicombo;
    @FXML
    private Label internalMiniTicketno;
    @FXML
    private Button internalMiniincBtn;
    @FXML
    private Button internalMinidecBtn;
    @FXML
    private RadioButton internalMiniOnewayRadio;
    @FXML
    private ToggleGroup trip11;
    @FXML
    private RadioButton internalMiniRoundtripRadio;
    @FXML
    private TextArea externalMiniText;
    @FXML
    private Button externalminibookBTN;
    @FXML
    private Label externalMiniTicketno;
    @FXML
    private Button externalMiniincBtn;
    @FXML
    private ComboBox externalMinicombo;
    @FXML
    private RadioButton externalMiniOnewayRadio;
    @FXML
    private ToggleGroup trip13;
    @FXML
    private RadioButton externalMiniRoundtrip;
    @FXML
    private Button externalMinidecBtn;
    @FXML
    private TextArea internalLimosineText;
    @FXML
    private Button internallimosinebookBTN;
    @FXML
    private ComboBox internallimosinecombo;
    @FXML
    private Label internalLimosineTicketno;
    @FXML
    private Button internalLimosineincBtn;
    @FXML
    private Button internalLimosinedecBtn;
    @FXML
    private RadioButton internalLimosineOnewayRadio;
    @FXML
    private ToggleGroup trip12;
    @FXML
    private RadioButton internalLimosineRoundtripRadio;
    @FXML
    private TextArea externalLimosineText;
    @FXML
    private Button externallimosinebookBTN;
    @FXML
    private Label externalLimosineTicketno;
    @FXML
    private Button externalLimosineincBtn;
    @FXML
    private ComboBox externallimosinecombo;
    @FXML
    private RadioButton externalLimosineOnewayRadio;
    @FXML
    private ToggleGroup trip14;
    @FXML
    private RadioButton externalLimosineRoundtripRadio;
    @FXML
    private Button externalLimosinedecBtn;

    /**
     * Initializes the controller class.
     */
    
    int i,j;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Files f = new Files();
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
        setallradio();
        printall();
    }    

    public void selectinternalonewaybus(){
        internalBusOnewayRadio.setSelected(true);
        internalBusRoundtripRadioBtn.setSelected(false);
    }
     public void selectexternalonewaybus(){
        externalBusOnewayRadio.setSelected(true);
        externalBusRoundtripRadio.setSelected(false);
    }
    
    public void selectinternalonewaymini(){
        internalMiniOnewayRadio.setSelected(true);
        internalMiniRoundtripRadio.setSelected(false);
    }
    
    public void selectexternalonewaymini(){
        externalMiniOnewayRadio.setSelected(true);
        externalMiniRoundtrip.setSelected(false);
    }
        
    public void selectinternalonewaylimo(){
         internalLimosineOnewayRadio.setSelected(true);
        internalLimosineRoundtripRadio.setSelected(false);
    }
    
    public void selectexternalonewaylimo(){
        externalLimosineOnewayRadio.setSelected(true);
        externalLimosineRoundtripRadio.setSelected(false);
    }
    
public void selectinternalroundbus(){
        internalBusOnewayRadio.setSelected(false);
        internalBusRoundtripRadioBtn.setSelected(true);
    }
     public void selectexternalroundbus(){
        externalBusOnewayRadio.setSelected(false);
        externalBusRoundtripRadio.setSelected(true);
    }
    
    public void selectinternalroundmini(){
        internalMiniOnewayRadio.setSelected(false);
        internalMiniRoundtripRadio.setSelected(true);
    }
    
    public void selectexternalroundmini(){
        externalMiniOnewayRadio.setSelected(false);
        externalMiniRoundtrip.setSelected(true);
    }
        
    public void selectinternalroundlimo(){
         internalLimosineOnewayRadio.setSelected(false);
        internalLimosineRoundtripRadio.setSelected(true);
    }
    
    public void selectexternalroundlimo(){
        externalLimosineOnewayRadio.setSelected(false);
        externalLimosineRoundtripRadio.setSelected(true);
    }    
   
    
    void setallradio(){
        internalBusOnewayRadio.setSelected(true);
        externalBusOnewayRadio.setSelected(true);
        internalMiniOnewayRadio.setSelected(true);
        externalMiniOnewayRadio.setSelected(true);
        internalLimosineOnewayRadio.setSelected(true);
        externalLimosineOnewayRadio.setSelected(true);
    }
    
    void closeallbook(){
        internalbusbookBTN.setDisable(true);
        externalbusbookBTN.setDisable(true);
        internalminibookBTN.setDisable(true);
        internalminibookBTN.setDisable(true);
        internallimosinebookBTN.setDisable(true);
        externallimosinebookBTN.setDisable(true);
    }
    
    public void fillsplit(int x){
        int i;
        switch (x){
            case 1:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                internalbuscombo.getItems().add("Trip " + (i+1));
                internalbuscombo.setVisibleRowCount(3);
            }
                break;
            case 2:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                externalBuscombo.getItems().add("Trip " + (i+1));
                externalBuscombo.setVisibleRowCount(3);
            }
                break;
            case 3:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                internalMinicombo.getItems().add("Trip " + (i+1));
                internalMinicombo.setVisibleRowCount(3);
            }
                break;
            case 4:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                externalMinicombo.getItems().add("Trip " + (i+1));
                externalMinicombo.setVisibleRowCount(3);
            }
                break;
            case 5:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                internallimosinecombo.getItems().add("Trip " + (i+1));
                internallimosinecombo.setVisibleRowCount(3);
            }
                break;
            case 6:{
                for (i=0;i<BusStation.mytriptypenumber;i++)
                externallimosinecombo.getItems().add("Trip " + (i+1));
                externallimosinecombo.setVisibleRowCount(3);
            }
                break;
        }
    }
    
    public void print1(){
        Files f = new Files();
        f.printtrips("bus","internal");
        fillsplit(1);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            internalBusText.appendText(str2);
            for(String w:words){
                internalBusText.appendText(w + "\n");
            }
            internalBusText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void print2(){
        Files f = new Files();
        f.printtrips("bus","external");
        fillsplit(2);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            externalBusText.appendText(str2);
            for(String w:words){
                externalBusText.appendText(w + "\n");
            }
            externalBusText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void print3(){
        Files f = new Files();
        f.printtrips("MiniBus","internal");
        fillsplit(3);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            internalMiniText.appendText(str2);
            for(String w:words){
                internalMiniText.appendText(w + "\n");
            }
            internalMiniText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void print4(){
        Files f = new Files();
        f.printtrips("MiniBus","external");
        fillsplit(4);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            externalMiniText.appendText(str2);
            for(String w:words){
                externalMiniText.appendText(w + "\n");
            }
            externalMiniText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void print5(){
        Files f = new Files();
        f.printtrips("Limosine","internal");
        fillsplit(5);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            internalLimosineText.appendText(str2);
            for(String w:words){
                internalLimosineText.appendText(w + "\n");
            }
            internalLimosineText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void print6(){
        Files f = new Files();
        f.printtrips("Limosine","external");
        fillsplit(6);
        int i;
        String str;
        String str2 = " ";
        for(i=0;i<BusStation.mytriptypenumber;i++){
            str=BusStation.tempalltrips_array[i];
            String[] words=str.split("\\s"); 
            str2 ="Trip " + (i+1) + ":" +"\n";
            externalLimosineText.appendText(str2);
            for(String w:words){
                externalLimosineText.appendText(w + "\n");
            }
            externalLimosineText.appendText("-------------------------------" + "\n");
    }
    }
    
    public void book1(){
        Files f = new Files();
        f.printtrips2("bus","internal");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = internalbuscombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (internalBusOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "bus", "internal", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    public void book2(){
       Files f = new Files();
        f.printtrips2("bus","external");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = externalBuscombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (externalBusOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "bus", "external", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    public void book3(){
        Files f = new Files();
        f.printtrips2("Minibus","internal");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = internalMinicombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (internalMiniOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "Minibus", "internal", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    public void book4(){
        Files f = new Files();
        f.printtrips2("Minibus","external");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = externalMinicombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (externalMiniOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "Minibus", "external", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    public void book5(){
        Files f = new Files();
        f.printtrips2("Limosine","internal");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = internallimosinecombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (internalLimosineOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "limosine", "internal", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    public void book6(){
        Files f = new Files();
        f.printtrips2("Limosine","external");
        int i=0;
        String s;
        String [] str2 = new String[5];
        int k;
        double p;
        Object value = externallimosinecombo.getValue();
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
        str=BusStation.tempalltrips_array[k-1];
        words=str.split("\\s"); 
            for(String w:words){
                if (i==1)
                    str2[0]=w;
                else if (i==2)
                    str2[1]=w;
                else if (i==3)
                    str2[2]=w;
                else if (i==6)
                    str2[3]=w;
                else if (i==8)
                    str2[4]=w;
                i++;
            }
            if (externalLimosineOnewayRadio.isSelected())
            s = "oneway";
        else {
            s="RoundTrip";
            p=Integer.valueOf(str2[3]);
            p=p*1.5;
            str2[3]=Double.toString(p);
        }
        if (Integer.valueOf(BusStation.tempseats[k-1])>0){
           f.openTripsFile();
           f.writeTrips(Integer.toString(BusStation.customer_id), str2[0], str2[1], str2[2], "limosine", "external", s , str2[3],str2[4]);
           Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Price is " + str2[3]);
                alert.setContentText("You have booked sucssesfuly");
                alert.show();
        }
        else {Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Error");
                alert.setContentText("There is no enough seats");
                alert.show();
        }
        f.openTripsRead();
        f.getTickedbyid(BusStation.customer_id);
        if ((4- BusStation.no_tickets) == 0)
        {
            closeallbook();
            Alert alert = new Alert (Alert.AlertType.ERROR);
                alert.setHeaderText("Enough");
                alert.setContentText("You already booked 4, can't book more");
                alert.show();
        }
    }
    
    void printall(){
        print1();
        print2();
        print3();
        print4();
        print5();
        print6();
    }
    
    
    
}
