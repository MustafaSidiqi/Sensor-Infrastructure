/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.rmi.server.UnicastRemoteObject;
import sensorsystem.SensorSystem;

public class DockImpRMI extends UnicastRemoteObject implements DockIntRMI {

    SensorSystem sensorsystem;

    public DockImpRMI(SensorSystem _sensorsystem) throws java.rmi.RemoteException {

        sensorsystem = sensorsystem;
        
    }
    
    @Override
    public boolean transferDataRMI(String username, String password, String data) throws java.rmi.RemoteException {

        return sensorsystem.transferData(username, password, data);

    }
    
    @Override
    public boolean handshakeRMI() throws java.rmi.RemoteException {
        
        return sensorsystem.handshake();
        
    }
    
}