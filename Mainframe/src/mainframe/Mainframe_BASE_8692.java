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
        for (DataStruct d : data) {
            System.out.println(d.objToString());
        }
<<<<<<< HEAD
        
        // test if mustafa can connect to DB
        java.rmi.registry.LocateRegistry.createRegistry(5050); // start i server-JVM
        rmi_SQL_server k = new rmi_SQL_server(readHash());
	Naming.rebind("rmi://localhost:5050/SQL", k);
        
=======

        sql_interface k = new DB(readHash());
        Naming.rebind("rmi://localhost:5050/kontotjeneste", (Remote) k);

>>>>>>> 16fffc32fada9f015810f404d12c5fb98ebc9503
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
        
        java.rmi.registry.LocateRegistry.createRegistry(6666); // start i server-JVM
        
        //SensorArsenal arsenal = new SensorArsenal();
        
        SensorInterface commandcenter = new SensorCommandCenter();
        WebserverInterface cybercenter = new CyberCommunicationCenter();
        // uncoment stuf you need 
        
    /*
        // for amazon server 
        Naming.rebind("rmi://52.56.199.233:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://52.56.199.233:1337/cybercommunicationscenter", (Remote) cybercenter);
        
         */
        //for local host
        //Naming.rebind("rmi://localhost:1337/sensorcommandcenter", (Remote) commandcenter);
<<<<<<< HEAD
       // Naming.rebind("rmi://localhost:1337/cybercommunicationscenter", (Remote) cybercenter);
        
        
=======
        // Naming.rebind("rmi://localhost:6666/cybercommunicationscenter", (Remote)cybercenter);
>>>>>>> 16fffc32fada9f015810f404d12c5fb98ebc9503
        System.out.println("Everything should be running now.");/**/
    }

}