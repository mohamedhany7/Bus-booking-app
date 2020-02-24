/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class BusStation extends Application {
  
    static int index;
    static int no_customer=0;
    static int no_manager=0;
    static int no_driver=0;
    static int customer_id;
    static int manager_id;
    static int driver_id;
    static int trip_id = 100;
    static int no_tickets=0;
    static int mytriptypenumber=0;
    static int no_all_trips=0;
    static String[][] passenger_array = new String[100][3];
    static String[][] manager_array = new String[100][3];
    static String[][] driver_array = new String[100][11];
    static String[][] trips_array = new String[100][9];
    static String[][] addedtrips_array = new String[100][9];
    static String[] tempdrivertrips_array = new String[100];
    static String[][] tickets_array = new String[4][7];
    static int[]ticket_line = new int[4];
    static String temptickets []= new String [100];
    static String tempseats []= new String [20];
    static String alltrips_array []= new String [100];
    static String tempalltrips_array []= new String [100];
    static String remember_username,remember_password;
    static boolean remember = false;
    static Customer mycustomer = new Customer(0,"0","0");
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BusStation.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fillarray();
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
        launch(args);
    }
    
    public static boolean check2(String str [][],String str1,int k){
        int j,i;
        int flag=1;
        boolean b=false;
        if (str1.length()>=4)
        for(i=0;i<10;i++){
            flag=0;
            for(j=0;j<str1.length();j++){
                if (j+1==str1.length() && flag == 0 && str1.charAt(j)== str[i][k].charAt(j))
                {
                    if (k==1)
                    index =i;
                    b = true;
                }
                if (str1.charAt(j)!= str[i][k].charAt(j)){
                    flag++;
                    break;
                }
        }
        }
            if (b==true)
                return true;
            else return false;
    }
       
    public static boolean check(String str [][],String str1,String str2)
    {
        boolean user,pass;
        user = check2(str,str1,1);
        pass = check2(str,str2,2);
        if (user == true && pass == true)
            return true;
        else return false;
    }
    
    public static void fillarray(){
        int i;
        for (i=0;i<passenger_array.length;i++){
            passenger_array[i][0]="jj";
            passenger_array[i][1]="jj";
            passenger_array[i][2]="jj";
        }
        for (i=0;i<driver_array.length;i++){
            driver_array[i][0]="jj";
            driver_array[i][1]="jj";
            driver_array[i][2]="jj";
            driver_array[i][3]="jj";
            driver_array[i][4]="jj";
            driver_array[i][5]="jj";
            driver_array[i][6]="jj";
            driver_array[i][7]="jj";
            driver_array[i][8]="jj";
            driver_array[i][9]="jj";
            driver_array[i][10]="jj";
        }
        for (i=0;i<passenger_array.length;i++){
            manager_array[i][0]="jj";
            manager_array[i][1]="jj";
            manager_array[i][2]="jj";
        }
    }
    
    public static void getId(int i){
        switch (i){
            case 1: customer_id = Integer.parseInt(passenger_array[index][0]);
                break;
            case 2: manager_id = Integer.parseInt(passenger_array[index][0]);
                break;
            case 3: driver_id= Integer.parseInt(driver_array[index][0]);
                break;
        }   
    }
    
    
}