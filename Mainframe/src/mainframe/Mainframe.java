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
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainframe {

    public static void main(String[] args)throws Exception
    {

        System.out.println("Hello, World!");
        // hvis den næste linje virker for jer så det godt... men den virker ikke for mig... 
        ArrayList<DataStruct> data;
        // Amazon IP server: 52.56.199.233

        SecurityBureau cia = new SecurityBureau();
        SensorCommandCenter nsa = new SensorCommandCenter();

        CyberCommunicationCenter nasa = new CyberCommunicationCenter();
        DataManipulationService db = new DataManipulationService(readHash());        
        
        try {
            java.rmi.registry.LocateRegistry.createRegistry(53067); // start i server-JVM
            sql_interface webSQL = new RMI_SQL(readHash());
            
            // local Host 
            java.rmi.registry.LocateRegistry.createRegistry(5367);
            Naming.rebind("rmi://localhost:53067/WEB_SQL", webSQL); /**/

            /*
            // this is for Jacobs server 
            System.setProperty("java.rmi.server.hostname", "ubuntu4.javabog.dk");
            Naming.rebind("rmi://localhost:53067/WEB_SQL", webSQL);/**/
            
            /*
            // this is for Amazon Server             
            System.setProperty("java.rmi.server.hostname", "sample-env.ppddn7aigu.eu-west-2.elasticbeanstalk.com");
            Naming.rebind("rmi://localhost:53067/WEB_SQL", webSQL);/**/
            
            System.out.println("Started RMI SQL_server ");
           
        }catch (RemoteException ex) {
            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }catch (MalformedURLException ex) {
                Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        // TEST KODE FOR SQL RMI FORBINDELSE 
        ////////////////////////////////////////////////////////////////
        /*
        	Brugerdatabase db = Brugerdatabase.getInstans();
                
		System.out.println("Publicerer Brugeradmin over RMI");
		BrugeradminImpl impl = new BrugeradminImpl();
		impl.db = db;
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start rmiregistry i server-JVM
		Naming.rebind("rmi://localhost/brugeradmin", impl);
		System.out.println("Brugeradmin publiceret over RMI");
         */

        ///////////////////////////////////////////////////////////////////////
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
        // Naming.rebind("rmi://localhost:1337/cybercommunicationscenter", (Remote) cybercenter);
        System.out.println("Everything should be running now.");/**/
    }

}
