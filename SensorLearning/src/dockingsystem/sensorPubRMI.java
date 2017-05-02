/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nb
 */
public class sensorPubRMI {
    
    public static void publish() throws NoSuchAlgorithmException, RemoteException, MalformedURLException {
        
        System.out.println("Starting RMI Sensor Data interface");

        java.rmi.registry.LocateRegistry.createRegistry(53712);

        sensorImpRMI si = new sensorImpRMI();// creates object for RMI Sensor data tranfer            

        Naming.rebind("rmi://localhost:53712/sensorRMI", (Remote) si);
        
    }
    
}