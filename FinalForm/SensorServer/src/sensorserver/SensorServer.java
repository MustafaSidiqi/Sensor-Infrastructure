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
       
       
    }

}
