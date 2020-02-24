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
public class Customer extends Person{
    
    public Trip []trips = new Trip[4];
    public static int number_trips;
    
    public Customer(int id,String username, String password) {
        super(username, password);
    }
}
