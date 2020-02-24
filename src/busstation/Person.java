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
public class Person {
    
    private String username;
    private String password;
    public static int notifications; 

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean compare(String str1,String str2){
        int i;
        int flag=0;
        if (str1.length()==str2.length()){
                for(i=0;i<str1.length();i++)
                    if (str1.charAt(i)!= str2.charAt(i))
                        flag++;
                if (flag == 0)
                    return true;
                else return false;
            }
        else return false;
    }
    
    public boolean checkLogin(String username,String password){
        boolean user,pass;
        user = compare(this.username,username);
        pass = compare(this.password,password);
        if (user && pass)
            return true;
        else return false;
    }
    
}
