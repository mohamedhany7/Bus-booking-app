/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation;

/**
 *
 * @author Lenovo
 */
public class Trip {
    private String sourse;
    private String destination;
    private String number_stops;
    private String vechile_type;
    private String trip_type;
    private String way_type;
    private String  price;


    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumber_stops() {
        return number_stops;
    }

    public void setNumber_stops(String number_stops) {
        this.number_stops = number_stops;
    }

    public String getVechile_type() {
        return vechile_type;
    }

    public void setVechile_type(String vechile_type) {
        this.vechile_type = vechile_type;
    }

    public String getTrip_type() {
        return trip_type;
    }

    public void setTrip_type(String trip_type) {
        this.trip_type = trip_type;
    }

    public String getWay_type() {
        return way_type;
    }

    public void setWay_type(String way_type) {
        this.way_type = way_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
