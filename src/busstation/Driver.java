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
public class Driver extends Person{
    
    public Driver(String username,String password,String first,String last,String age,String gender,String nationality,String vechile,String hours,String trips) {
        super(username, password);
        Files f = new Files();
        f.openDriverFile();
        f.writeDriver(username, password,first,last,age,gender,nationality,vechile,hours,trips);
    }
    
}
