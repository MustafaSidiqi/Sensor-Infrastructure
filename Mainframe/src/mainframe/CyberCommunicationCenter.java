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
<<<<<<< HEAD
    //Constructor
    CyberCommunicationCenter () throws RemoteException {   }
=======
    
    public CyberCommunicationCenter()throws java.rmi.RemoteException{
    }
>>>>>>> f5bfdc86cd154d16ca2978bee36e17f88faac632
    
    // Authenticate User

    //NOT FINSHED
    @Override
    public boolean cyberLogin(String username, String password) throws java.rmi.RemoteException {
        return cia.login(username, password);
    };
    //NOT FINSHED YET
    
    
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
