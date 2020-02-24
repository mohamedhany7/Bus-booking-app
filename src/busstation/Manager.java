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
public class Manager extends Person{
    
    public Manager(String username, String password) {
        super(username, password);
        Files f = new Files();
        f.openManagerFile();
        f.writeManager(username, password);
        f.closeFiles();
    }
    
}