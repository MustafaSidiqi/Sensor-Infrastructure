package SQL_controler;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {        
        try {
            //sql_interface webSQL = new RMI_SQL(readHash());
            // local Host 
            //java.rmi.registry.LocateRegistry.createRegistry(53067);
            /**/
            // this is for Jacobs server 
            //System.setProperty("java.rmi.server.hostname", "ubuntu4.javabog.dk");/**/
    
            System.out.println("Starting RMI Data interface");
            java.rmi.registry.LocateRegistry.createRegistry(53168); 
            WebCommunication serverObject = new WebCommunication();
            
            Naming.rebind("rmi://localhost:53168/data", (Remote) serverObject);
            System.out.println("Everything should be running now.");/**/
            
            //(new Thread(new StoreData(SendData))).start();
    
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
        
        
        
        
        

    }

}
