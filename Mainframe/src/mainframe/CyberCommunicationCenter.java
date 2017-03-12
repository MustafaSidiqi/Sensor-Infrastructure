/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author nb
 */
public class CyberCommunicationCenter extends UnicastRemoteObject implements WebserverInterface {

    SecurityBureau cia;
    //YO
    public String username; 
    public String password; 
    // angiv om hvad det er for nogle variabler dvs public eller private eller protected. 
    
    SensorCommandCenter nsa;
    DataManipulationService db;
    
    
    // Authenticate User
    
    public void setUsername(String a) throws RemoteException {
        this.username = a; 
    }
    
    public void setPassword(String b) throws RemoteException {
        this.username = b; 
    }
    
    /*
    public boolean receiveLoginInfo(String username, String password) {
        //Send over the login data to SecurityBureau();
        if(login) {
            return true;
        } else{
            return false;
        }
    }*/
    // Download Data Dump
    
    //// WTF hvor er return type??? 
    
    
    /*public requestDataInfo(String sensorName, String dateFrom, String dateTo) {
        //Request data from database, and send back to website
    }*/
    



   
}
