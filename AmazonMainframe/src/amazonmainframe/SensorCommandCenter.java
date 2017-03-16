/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonmainframe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nb
 */
public class SensorCommandCenter extends UnicastRemoteObject implements SensorInterface {

    SensorCommandCenter() throws RemoteException {
        System.out.println("Creating Sensor Command Sensor");
    }
    
    @Override
    public boolean transferData(String username, String password, String data) { // Listen to sensors
        
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        System.out.println("Data: "+data);
        return true;
    }
    
}
