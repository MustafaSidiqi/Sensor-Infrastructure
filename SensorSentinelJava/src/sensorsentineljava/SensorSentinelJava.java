/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsentineljava;

import java.rmi.Naming;

/**
 *
 * @author nb
 */
public class SensorSentinelJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SensorInterface interface = (GalgeI) Naming.lookup("rmi://localhost/galgeleg");
    }
    
}