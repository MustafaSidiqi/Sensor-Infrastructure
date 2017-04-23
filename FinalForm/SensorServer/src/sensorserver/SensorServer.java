/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import SQL_controler.*;
import SQL_controler.UserControler;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class SensorServer {

    /**
     * @param args the command line arguments
     */
    //Michaels ting til AES encryption og handshake af sensor////////////////////////////////////////////////////
    static String IV = "AAAAAAAAAAAAAAAA";
    static String nonsense = "0a1b2c3d4e5f6789"; //(SKAL RANDOMIZES)
    static String decodedNonsense;
    static String XORNonsenseS;
    static String publicKey = "0123456789abcdef"; //(SKAL RANDOMIZES)
    static XORStrings x = new XORStrings(); //object of XOR functions
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws NoSuchAlgorithmException, RemoteException, MalformedURLException {
        //DataControler d = new DataControler();
        //ExpDataControler k = new ExpDataControler();
        //SensorControler s = new SensorControler();
        //UserControler u = new UserControler();

        
        //Til at reservere port til java sensor - Michael///////////////////////////////////////////////////////
        System.out.println("Starting RMI Sensor Data interface");
        java.rmi.registry.LocateRegistry.createRegistry(53712);
        SensorImpl si = new SensorImpl();// creates object for RMI Sensor data tranfer            
        Naming.rebind("rmi://localhost:53712/sensorimpl", (Remote) si);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    try {
                DataControl database1 = new DataControl("sensordata");
                DataControl database2 = new DataControl("expsensordata");
        } catch (SQLException ex) {
                Logger.getLogger(SensorServer.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }

}
