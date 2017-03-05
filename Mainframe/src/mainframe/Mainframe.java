/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

/**
 *
 * @author nb
 */

import java.rmi.Naming;
import java.rmi.Remote;

public class Mainframe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.rmi.registry.LocateRegistry.createRegistry(1337);
        
        System.out.println("Hello, World!");
        
    }
    
}
