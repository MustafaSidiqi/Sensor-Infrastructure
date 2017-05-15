/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;

/**
 *
 * @author nb
 */
public class UserInterface {
    
    public boolean online;
    
    public UserInterface() {
        
        online = false;
        
        System.out.print("Online (y/n): ");
        
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        System.out.println(input);
        
        if("y".equals(input) || "yes".equals(input) || "1".equals(input) || "Yes".equals(input)) {
   
            online = true;
            System.out.println("Going online...");
        
        } else {
        
            System.out.println("Local it is!");
        
        }
        
    }
    
    public boolean isOnline() {
        
        return online;
    
    }
    
}
