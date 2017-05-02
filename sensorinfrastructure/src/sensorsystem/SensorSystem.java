/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import dockingsystem.sensorPubRMI;
import dockingsystem.sensorPubSOAP;
import static java.lang.Boolean.TRUE;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import securitysystem.UserAuthentication;
import securitysystem.UserAuthenticationInterface;

public class SensorSystem {
    
    UserAuthentication sec;
    
    public SensorSystem(UserAuthentication _sec) throws RemoteException, NoSuchAlgorithmException {
        
        sec = _sec;
        
        initialiseSensorDockingSystem();
        
    }
    
    static public void initialiseSensorDockingSystem() throws NoSuchAlgorithmException, RemoteException {
        
        System.out.println("Setting up sensor communication protocols...");
        
        System.out.println("Initializing SOAP...");
        
        sensorPubSOAP.publish();
        
        System.out.println("SOAP Running!");
        
        System.out.println("Setting up RMI...");
        
        try {
            sensorPubRMI.publish();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SensorSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("RMI Running!");
        
        System.out.println("Initializing REST...");
        
        // REST Publish, Interface, Implementation...
        
        System.out.println("REST Running!");
        
        System.out.println("Sensor Communication Protocols Setup is finished!");
        
    }
    
    public boolean transferData(String data) {
        
        System.out.println("Transfering Data...");
        
        System.out.println(data);

        return TRUE;

    }
    
    public boolean handshake() {
        
        System.out.println("Handshaking...");
        
        System.out.println("Login...");
        
        String username = null;
        
        String password = null;
        
        if(sec.login(username, password)) {
            
            System.out.println("Succes!");
            
        } else {
            
            System.out.println("Fail!");
            
            return false;
        }
        
        System.out.println("Handshake done!");
        
        return TRUE;
        
    }
    
}