/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

import static busstation.BusStation.passenger_array;
import java.util.*;
import java.io.*;

/**
 *
 * @author Lenovo
 */
public class Files {

    private BufferedWriter customer;
    private BufferedWriter manager;
    private BufferedWriter driver;
    private BufferedWriter trips;
    private BufferedWriter addedtrips;
    private Formatter form = new Formatter();
    private Scanner x;
    private Scanner y;
    private Scanner z;
    private Scanner t;
    private Scanner tt;

    public void openCustomerFile() {
        try {
            customer = new BufferedWriter(new FileWriter("customerFile.txt", true));
        } catch (Exception e) {
            System.out.println("Error customer file");
        }
    }

    public void openManagerFile() {
        try {
            manager = new BufferedWriter(new FileWriter("managerFile.txt", true));
        } catch (Exception e) {
            System.out.println("Error manager file");
        }
    }

    public void openDriverFile() {
        try {
            driver = new BufferedWriter(new FileWriter("driverFile.txt", true));
        } catch (Exception e) {
            System.out.println("Error driver file");
        }
    }

    public void openTripsFile() {
        try {
            trips = new BufferedWriter(new FileWriter("tripsFile.txt", true));
        } catch (Exception e) {
            System.out.println("Error trips file");
        }
    }
    
    public void openaddedtripsFile() {
        try {
            addedtrips = new BufferedWriter(new FileWriter("addedtripsFile.txt", true));
        } catch (Exception e) {
            System.out.println("Error trips file");
        }
    }

    public void writeCustomer(String username, String password) {
        BusStation.no_customer++;
        int id = BusStation.no_customer;
        String str = id + " " + username + " " + password;
        try {
            customer.write(str);
            customer.newLine();
            customer.close();
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }

    }

    public void writeManager(String username, String password) {
        String str = username + " " + password + "\n";

        try {
            manager.write(str);
            manager.newLine();
            manager.close();
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }
    }

    public void writeDriver(String username, String password,String first,String last,String age,String gender,String nationality,String vechile,String hours,String trips) {
        String id = Integer.toString(BusStation.driver_id);
        String str = id + " " + username + " " + password + " " + first + " " + last + " " + age + " " + gender + " " + nationality + " " + vechile + " " + hours + " " + trips +"\n";

        try {
            driver.write(str);
            driver.newLine();
            driver.close();
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }
    }

    public void writeTrips(String id, String source, String dest, String stops, String vehicle, String type, String way, String price,String trip_ID) {
        String str = id + " " + source + " " + dest + " " + stops + " " + vehicle + " " + type + " " + way + " " + price + " " + trip_ID +"\n";

        try {
            trips.write(str);
            trips.newLine();
            trips.close();
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }
    }
    
    public void writeaddedTrips(String id, String source, String dest, String stops, String vehicle, String type, String price,String seats,String driverid) {
        String str = id + " " + source + " " + dest + " " + stops + " " + vehicle + " " + type +  " " + price + " " + seats + " " + driverid + "\n";
        
        try {
            addedtrips.write(str);
            addedtrips.newLine();
            addedtrips.close();
            BusStation.trip_id++;
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }
    }

    public void openCustomerRead() {
        try {
            x = new Scanner(new File("customerFile.txt"));
        } catch (Exception e) {
            System.out.println("Error customer file");
        }
    }

    public void readCustomer() {
        int i = 0;
        while (x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String c = x.next();
            BusStation.passenger_array[i][0] = a;
            BusStation.passenger_array[i][1] = b;
            BusStation.passenger_array[i][2] = c;
            i++;
            BusStation.no_customer++;
        }
        x.close();
    }

    public void openManagerRead() {
        try {
            y = new Scanner(new File("managerFile.txt"));
        } catch (Exception e) {
            System.out.println("Error manager file");
        }
    }

    public void readManager() {
        int i = 0;
        while (y.hasNext()) {
            String a = y.next();
            String b = y.next();
            String c = y.next();
            BusStation.no_manager++;
            BusStation.manager_array[i][0] = a;
            BusStation.manager_array[i][1] = b;
            BusStation.manager_array[i][2] = c;
        }
        y.close();
    }

    public void openDriverRead() {
        try {
            z = new Scanner(new File("driverFile.txt"));
        } catch (Exception e) {
            System.out.println("Error driver file");
        }
    }

    public void readdriver() {
        BusStation.no_driver=0;
        BusStation.driver_id = 1000;
        int i=0;
        while (z.hasNext()) {
            String a = z.next();
            String b = z.next();
            String c = z.next();
            String d = z.next();
            String e = z.next();
            String f = z.next();
            String g = z.next();
            String h = z.next();
            String l = z.next();
            String j = z.next();
            String k = z.next();            
            BusStation.no_driver++;
            BusStation.driver_id++;
            BusStation.driver_array[i][0]=a;
            BusStation.driver_array[i][1]=b;
            BusStation.driver_array[i][2]=c;
            BusStation.driver_array[i][3]=d;
            BusStation.driver_array[i][4]=e;
            BusStation.driver_array[i][5]=f;
            BusStation.driver_array[i][6]=g;
            BusStation.driver_array[i][7]=h;
            BusStation.driver_array[i][8]=l;
            BusStation.driver_array[i][9]=j;
            BusStation.driver_array[i][10]=k;
            i++;
        }
        z.close();
    }

    public void openTripsRead() {
        try {
            t = new Scanner(new File("tripsFile.txt"));
        } catch (Exception e) {
            System.out.println("Error Trips file");
        }
    }

    public void readTrips() {
        int i = 0;
        while (t.hasNext()) {
            String a = t.next();
            String b = t.next();
            String c = t.next();
            String d = t.next();
            String e = t.next();
            String f = t.next();
            String g = t.next();
            String h = t.next();
            String q = t.next();
            BusStation.trips_array[i][0] = a;
            BusStation.trips_array[i][1] = b;
            BusStation.trips_array[i][2] = c;
            BusStation.trips_array[i][3] = d;
            BusStation.trips_array[i][4] = e;
            BusStation.trips_array[i][5] = f;
            BusStation.trips_array[i][6] = g;
            BusStation.trips_array[i][7] = h;
            BusStation.trips_array[i][8] = q;
            i++;
        }
        t.close();
    }
    
    public void openaddTripsRead() {
        try {
            tt = new Scanner(new File("addedtripsFile.txt"));
        } catch (Exception e) {
            System.out.println("Error addedTrips file");
        }
    }

    public void readaddTrips() {
        int i = 0;
        while (tt.hasNext()) {
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            BusStation.addedtrips_array[i][0] = a;
            BusStation.addedtrips_array[i][1] = b;
            BusStation.addedtrips_array[i][2] = c;
            BusStation.addedtrips_array[i][3] = d;
            BusStation.addedtrips_array[i][4] = e;
            BusStation.addedtrips_array[i][5] = f;
            BusStation.addedtrips_array[i][6] = g;
            BusStation.addedtrips_array[i][7] = h;
            BusStation.addedtrips_array[i][8] = m;
            i++;
        }
        t.close();
    }
    
    public void getTickedbyid(int id) {
        int i = 0;
        int j=0;
        BusStation.no_tickets=0;
        while (t.hasNext()) {
            String a = t.next();
            String b = t.next();
            String c = t.next();
            String d = t.next();
            String e = t.next();
            String f = t.next();
            String g = t.next();
            String h = t.next();
            String q = t.next();
            if (id == Integer.parseInt(a)){
            BusStation.tickets_array[j][0] = b;
            BusStation.tickets_array[j][1] = c;
            BusStation.tickets_array[j][2] = d;
            BusStation.tickets_array[j][3] = e;
            BusStation.tickets_array[j][4] = f;
            BusStation.tickets_array[j][5] = g;
            BusStation.tickets_array[j][6] = h;
            BusStation.no_tickets++;
            j++;
            BusStation.ticket_line[j-1]=i;
            }
            i++;
        }
        t.close();
    }

    public void closeFiles() {
        //customer.close();
        // manager.close();
        //driver.close();
        // x.close();
        //y.close();
        //z.close();
        //t.close();
    }
    
    public void edit(int line){
        
        String str = null;
        int i=0;
        int j;
        int k=0;
        try {
            t = new Scanner(new File("tripsFile.txt"));
        } catch (Exception e) {
            System.out.println("Error Trips file");
        }
        
        while (t.hasNext()){
            String a = t.next();
            String b = t.next();
            String c = t.next();
            String d = t.next();
            String e = t.next();
            String f = t.next();
            String g = t.next();
            String h = t.next();
            String q = t.next();
            str = a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + h + " " + q + "\n";
            BusStation.temptickets[i]=str;
            i++;
        }
        
        try{
            form = new Formatter ("tripsfile.txt");
        }
        catch (Exception e){
            System.out.println("Error customer file");
        }
        for (j=0;j<i;j++){
            if (k != line){
                try {
                trips = new BufferedWriter(new FileWriter("tripsFile.txt", true));
                } catch (Exception e) {
                System.out.println("Error trips file");
                }
                try {
                    trips.write(BusStation.temptickets[j]);
                    trips.newLine();
                    trips.close();
                  } catch (IOException ex) {
                        System.out.println("exception occoured" + ex);
                    }  
            }
            k++;
        }
    }
    
    public void readalltrips(){
        openaddTripsRead();
        BusStation.no_all_trips=0;
        int i = 0;
        while (tt.hasNext()) {
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            String str =  b + " " + c + " " + d + " " + e + " " + f +  " " + g + " " + h + " " + m + "\n";
            BusStation.alltrips_array[i]=str;
            i++;
            BusStation.no_all_trips++;
            BusStation.trip_id++;
        }
        tt.close();
    }
    
    
    public void deletetrip(int line){
        String str = null;
        int i=0;
        int j;
        int k=0;
        String key;
        int id=0;
        BusStation.trip_id=100;
        openaddTripsRead();
        
        
        while (tt.hasNext()){
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            str =  a+ " " + b + " " + c + " " + d + " " + e + " " + f +  " " + g + " " + h +  " " + m;
            BusStation.temptickets[i]=str;
            i++;
            BusStation.trip_id++;
        }
        
        try{
            form = new Formatter ("addedtripsfile.txt");
        }
        catch (Exception e){
            System.out.println("Error addedtrips file");
        }
        for (j=0;j<i;j++){
            if (k == line ){
                String [] words;
                key =  BusStation.temptickets[j];
                words=key.split("\\s");   
                    for(String w:words){
                        key=w;
            }
                    id = Integer.valueOf(key);
            }
            if (k != line){
                openaddedtripsFile();
                try {
                    addedtrips.write(BusStation.temptickets[j]);
                    addedtrips.newLine();
                    addedtrips.close();
                  } catch (IOException ex) {
                        System.out.println("exception occoured" + ex);
                    }  
            }
            k++;
        }
        BusStation.no_all_trips--;
        
        openTripsRead();
        
        i = 0;
        while (t.hasNext()) {
            String a = t.next();
            String b = t.next();
            String c = t.next();
            String d = t.next();
            String e = t.next();
            String f = t.next();
            String g = t.next();
            String h = t.next();
            String q = t.next();
            str =  a+ " " + b + " " + c + " " + d + " " + e + " " + f +  " " + g + " " + h +  " " + q;
            if (Integer.valueOf(q) != id){
            BusStation.temptickets[i]=str;
            i++;
            }
        }
        t.close();
        
        try{
            form = new Formatter ("tripsfile.txt");
        }
        catch (Exception e){
            System.out.println("Error trips file");
        }
        
        for (j=0;j<i;j++){
            openTripsFile();
            try {
            trips.write(BusStation.temptickets[j]);
            trips.newLine();
            trips.close();
        } catch (IOException ex) {
            System.out.println("exception occoured" + ex);
        }
            }
    }
    
    public void getdrivertripsbyid(int id) {
        int i = 0;
        int j=0;        int ticket = 0;
        openaddTripsRead();
        while (tt.hasNext()) {
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            if (id == Integer.parseInt(m)){
            BusStation.tempdrivertrips_array[j] = b + " " +c + " " + d+" "+e+ " "+ f + " "+ h;
            ticket++;
            j++;
            }
            i++;
        }
        tt.close();
        BusStation.driver_array[BusStation.index][10] = Integer.toString(ticket);
    }
    
    public void printtrips(String vtype , String ttype) {
        Scanner tt = null;
        try {
            tt = new Scanner(new File("addedtripsFile.txt"));
        } catch (Exception e) {
            System.out.println("Error addedTrips file");
        }
        BusStation.no_all_trips = 0;
        int i = 0;
        BusStation.mytriptypenumber=0;
        while (tt.hasNext()) {
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            if (String_cmp(e,vtype) && String_cmp(f,ttype)){
            String str = "Source:" + b + " " + "Destination:" + c + " " + "Stops:" + d + " " + "Price:" + g  + "$" + "\n";
            BusStation.tempalltrips_array[i] = str;
            BusStation.tempseats[i] = h;
            BusStation.mytriptypenumber++;
            i++;
            }
            BusStation.no_all_trips++;
            BusStation.trip_id++;
        }
        tt.close();
    }
    
    public void printtrips2(String vtype , String ttype) {
        Scanner tt = null;
        try {
            tt = new Scanner(new File("addedtripsFile.txt"));
        } catch (Exception e) {
            System.out.println("Error addedTrips file");
        }
        BusStation.no_all_trips = 0;
        int i = 0;
        BusStation.mytriptypenumber=0;
        while (tt.hasNext()) {
            String a = tt.next();
            String b = tt.next();
            String c = tt.next();
            String d = tt.next();
            String e = tt.next();
            String f = tt.next();
            String g = tt.next();
            String h = tt.next();
            String m = tt.next();
            if (String_cmp(e,vtype) && String_cmp(f,ttype)){
            String str = a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g  + " " + h + " " + m + "\n";
            BusStation.tempalltrips_array[i] = str;
            BusStation.tempseats[i] = h;
            BusStation.mytriptypenumber++;
            i++;
            }
            BusStation.no_all_trips++;
            BusStation.trip_id++;
        }
        tt.close();
    }
    
    public boolean String_cmp(String str1,String str2){
        int i=0;
        boolean flag=true;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        for (i=0;i<str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i)){
                flag=false;
                break;
            }
        }
        return flag;
    }
}
