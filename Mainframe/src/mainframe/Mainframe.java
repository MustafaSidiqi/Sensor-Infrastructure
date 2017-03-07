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

    public static void main(String[] args) throws Exception {
        
        java.rmi.registry.LocateRegistry.createRegistry(4242); // start i server-JVM
        
        System.out.println("Hello, World!");
        
    }
    
}
