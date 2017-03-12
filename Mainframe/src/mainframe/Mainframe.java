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

import static java.lang.Boolean.TRUE;
import java.rmi.Naming;
import java.rmi.Remote;

public class Mainframe {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, World!");
        
        // Amazon IP server: 52.56.199.233
        
        SecurityBureau cia = new SecurityBureau();
        SensorCommandCenter nsa = new SensorCommandCenter();       
       
        CyberCommunicationCenter nasa = new CyberCommunicationCenter();
        DataManipulationService db = new DataManipulationService();

        db.cia = cia;
        nsa.cia = cia;
        nasa.cia = cia;
        
        cia.nsa = nsa;
        nasa.nsa = nsa;
        db.nsa = nsa;
        
        cia.nasa = nasa;
        nsa.nasa = nasa;
        db.nasa = nasa;
        
        cia.db = db;
        nsa.db = db;
        nasa.db = db;
        
        java.rmi.registry.LocateRegistry.createRegistry(1337); // start i server-JVM
        
        //SensorArsenal arsenal = new SensorArsenal();
        
        SensorInterface commandcenter = new SensorCommandCenter();
        WebserverInterface cybercenter = new CyberCommunicationCenter();
        // uncoment stuf you need 
        
        /*
        // for amazon server 
        Naming.rebind("rmi://52.56.199.233:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://52.56.199.233:1337/cybercommunicationscenter", (Remote) cybercenter);*/
        
        /*
        //fo local host
        Naming.rebind("rmi://localhost:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://localhost:1337/cybercommunicationscenter", (Remote) cybercenter);
        */
        
        System.out.println("Everything should be running now.");
        
        

    }
    
}