/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import static java.lang.Boolean.TRUE;

public class SensorSystem {
    
    static public boolean transferData(String data) {
        
        System.out.println("Transfering Data...");
        
        System.out.println(data);

        return TRUE;

    }
    
    static public boolean handshake() {
        
        System.out.println("Handshaking...");
        
        System.out.println("Handshake done!");
        
        return TRUE;
        
    }
    
}