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
import SQL_RMI.rmi_SQL_server;
import SQL_forbindelse.*;
import static StartLoadSer.readSer.readHash;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.ArrayList;

public class Mainframe {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Hello, World!");
        // hvis den næste linje virker for jer så det godt... men den virker ikke for mig... 
        ArrayList<DataStruct> data;
        // Amazon IP server: 52.56.199.233
        
        SecurityBureau cia = new SecurityBureau();
        SensorCommandCenter nsa = new SensorCommandCenter();       
       
        CyberCommunicationCenter nasa = new CyberCommunicationCenter();
        DataManipulationService db = new DataManipulationService(readHash());
        data = db.getAllBySensorID(1); 
        for(DataStruct d : data){
            System.out.println(d.objToString());
        }
        
        // test if mustafa can connect to DB
        java.rmi.registry.LocateRegistry.createRegistry(5050); // start i server-JVM
        rmi_SQL_server k = new rmi_SQL_server(readHash());
	Naming.rebind("rmi://localhost/kontotjeneste", k);
        
        /*
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
        
    
        // for amazon server 
        Naming.rebind("rmi://52.56.199.233:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://52.56.199.233:1337/cybercommunicationscenter", (Remote) cybercenter);
        
        
        //for local host
        //Naming.rebind("rmi://localhost:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://localhost:1337/cybercommunicationscenter", (Remote) cybercenter);
        
        
        System.out.println("Everything should be running now.");/**/
    }
    
}