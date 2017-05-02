/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorlearning;

import dockingsystem.sensorPubRMI;
import dockingsystem.sensorPubSOAP;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SensorLearning {

    /**
     * @param args the command line arguments
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.rmi.RemoteException
     * @throws java.net.MalformedURLException
     */
    
    public static void main(String[] args) throws NoSuchAlgorithmException, RemoteException, MalformedURLException {
        // TODO code application logic here
        
        System.out.println("Setting up sensor communication protocols...");
        
        System.out.println("Initializing SOAP...");
        
        sensorPubSOAP.publish();
        
        System.out.println("SOAP Running!");
        
        System.out.println("Setting up RMI...");
        
        try {
            sensorPubRMI.publish();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SensorLearning.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("RMI Running!");
        
        System.out.println("Initializing REST...");
        
        // REST Publish, Interface, Implementation...
        
        System.out.println("REST Running!");
        
        System.out.println("Sensor Communication Protocols Setup is finished!");
        
    }
    
}