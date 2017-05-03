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
        
        if(input == "y" || input == "yes" || input == "1" || input == "Yes") online = true;        
        
    }
    
    public boolean isOnline() {
        
        return online;
    
    }
    
}
