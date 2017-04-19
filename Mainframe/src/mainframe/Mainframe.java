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
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainframe {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        SecurityBureau cia = new SecurityBureau(); // creates connection to javabog authentication 
        
        try {
            //sql_interface webSQL = new RMI_SQL(readHash());

            // local Host 
            //java.rmi.registry.LocateRegistry.createRegistry(53067);
            /**/

 
            // this is for Jacobs server 
            //System.setProperty("java.rmi.server.hostname", "ubuntu4.javabog.dk");/**/

 /*
            // this is for Amazon Server             
            System.setProperty("java.rmi.server.hostname", "sample-env.ppddn7aigu.eu-west-2.elasticbeanstalk.com");/**/
            //Naming.rebind("rmi://localhost:53067/WEB_SQL", webSQL);
            //System.out.println("Started RMI SQL_server ");
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////

            
            System.out.println("Starting RMI Sensor Data interface");
            java.rmi.registry.LocateRegistry.createRegistry(53712); 
            SensorCommandCenter nsa = new SensorCommandCenter();// creates object for RMI Sensor data tranfer            
            Naming.rebind("rmi://localhost:53712/sensorcommandcenter", (Remote) nsa);
            

            //DataManipulationService SendData = new DataManipulationService(readHash());
            
            
            nsa.cia = cia;
            cia.nsa = nsa;
            //SendData.cia = cia;
            //SendData.nsa = nsa;

            
            System.out.println("Everything should be running now.");/**/
            
            //(new Thread(new StoreData(SendData))).start();
    
        } catch (RemoteException ex) {
            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        	Brugerdatabase db = Brugerdatabase.getInstans();
                
		System.out.println("Publicerer Brugeradmin over RMI");
		BrugeradminImpl impl = new BrugeradminImpl();
		impl.db = db;
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start rmiregistry i server-JVM
		Naming.rebind("rmi://localhost/brugeradmin", (Remote)impl);
		System.out.println("Brugeradmin publiceret over RMI");
       

        db.cia = cia;       
        nasa.cia = cia;
        nasa.nsa = nsa;
        db.nsa = nsa;
        
        cia.nasa = nasa;
        nsa.nasa = nasa;
        db.nasa = nasa;
        
         */
 /*
        cia.db = db;
        nsa.db = db;
        nasa.db = db;*/
        // start i server-JVM

        //SensorArsenal arsenal = new SensorArsenal();
        //WebserverInterface cybercenter = new CyberCommunicationCenter();
        // for amazon server 
        /*
        Naming.rebind("rmi://52.56.199.233:1337/sensorcommandcenter", (Remote) commandcenter);
        Naming.rebind("rmi://52.56.199.233:1337/cybercommunicationscenter", (Remote) cybercenter);/**/
        //for local host

        //Naming.rebind("rmi://localhost:1337/cybercommunicationscenter", (Remote) cybercenter);/**/
        // we dont use it yet 
        //CyberCommunicationCenter nasa = new CyberCommunicationCenter();
        // DataManipulationService DataBase = new DataManipulationService(readHash());        
    }

}
