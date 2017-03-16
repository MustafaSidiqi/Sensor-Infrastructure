/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonmainframe;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * java -Djava.rmi.server.hostname=52.56.199.233 -cp AmazonMainframe.jar
 * @author nb
 */
public class AmazonMainframe {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // TODO code application logic here
        
        System.out.println("Hello, World!");
        
        System.out.println("Version 1.6");
        
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        
        System.setProperty("java.rmi.server.hostname", "52.56.199.233");
        
        System.out.println("RMI Port Initialized.");
        
        System.out.println("Setting Up RMI To Port...");
        
        SensorInterface i = new SensorCommandCenter();
        
        Registry registry = LocateRegistry.getRegistry();
        
        registry.rebind("//52.56.199.233:1337/sensorcommandcenter", (Remote) i);
        
        System.out.println("All system up and running?");
    }
    
}
