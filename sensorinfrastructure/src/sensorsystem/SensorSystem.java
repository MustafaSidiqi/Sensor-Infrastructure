/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import datasystem.DataControl;
import datasystem.SensorControl;
import datasystem.UserControl;
import dockingsystem.DockPubRMI;
import dockingsystem.DockPubSOAP;
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
    DataControl data;
    SensorControl sensors;
    UserControl users;
    
    public SensorSystem(UserAuthentication _sec, DataControl _data, UserControl _users, SensorControl _sensors) throws RemoteException, NoSuchAlgorithmException {
        
        sec = _sec;
        users = _users;
        sensors = _sensors;
        
        
    }
    
    public void initialiseSensorDockingSystem() throws NoSuchAlgorithmException, RemoteException, MalformedURLException {
        
        System.out.println("Setting up sensor communication protocols...");
        
        System.out.println("Initializing SOAP...");
        
        DockPubSOAP.publish(this);
        
        System.out.println("SOAP Running!");
        
        System.out.println("Setting up RMI...");
        
        DockPubRMI.publish(this);
        
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