/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import brugerautorisation.transport.soap.Brugeradmin;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;


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

    //NOT FINSHED
    public void setUsername(String username ) throws RemoteException {
        
    };
    //NOT FINSHED YET
    public void setPassword(String password) throws RemoteException {
        
    };
    
    
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
