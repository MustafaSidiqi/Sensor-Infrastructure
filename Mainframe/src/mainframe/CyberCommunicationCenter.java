/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

/**
 *
 * @author nb
 */
public class CyberCommunicationCenter extends UnicastRemoteObject implements WebserverInterface {

    SecurityBureau cia;
    
    public String username; 
    public String password; 
    
    
    // Authenticate User
    
    public void setUsername(String a) throws RemoteException {
        this.username = a; 
    }
    
    public void setPassword(String b) throws RemoteException {
        this.username = b; 
    }
    

    public boolean receiveLoginInfo(String username, String password) {
        //Send over the login data to SecurityBureau();
        if(login) {
            return true;
        } else{
            return false;
        }
}
    // Download Data Dump
    public requestDataInfo[String sensorName, String dateFrom, String dateTo] {
        //Request data from database, and send back to website
}
    // Stream Real Time Data
    SensorCommandCenter nsa;
    DataManipulationService db;

   
}
