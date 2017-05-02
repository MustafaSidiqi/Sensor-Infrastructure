/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.rmi.server.UnicastRemoteObject;
import sensorsystem.SensorSystem;

public class sensorImpRMI extends UnicastRemoteObject implements sensorIntRMI {
    
    public sensorImpRMI() throws java.rmi.RemoteException {
        
        System.out.println("Hej RMI");
        
    }
    
    @Override
    public boolean transferDataRMI(String data) throws java.rmi.RemoteException {


        return SensorSystem.transferData(data);

    }
    
    @Override
    public boolean handshakeRMI() throws java.rmi.RemoteException {
        
        return SensorSystem.handshake();
        
    }
    
}