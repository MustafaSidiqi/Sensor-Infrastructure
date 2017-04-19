/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author MSC
 */
public class SensorImpl extends UnicastRemoteObject implements SensorInterface {

    public UserAuthentication ua;
    boolean listeningToSensors;
    private Queue<String> incommingBuffer;
    //CyberCommunicationCenter nasa;
    //DataManipulationService db;
    
    private final Object lock = new Object();

    public SensorImpl() throws java.rmi.RemoteException {
        this.listeningToSensors = TRUE;
        incommingBuffer = new LinkedList<String>();
    }

    @Override
    public boolean transferData(String username, String password, String data) throws java.rmi.RemoteException { // Listen to sensors

        System.out.println("Incomming Data!");

        System.out.println("Background checking user...");

        if (ua.login(username, password) && listeningToSensors) {
            System.out.println("Access Granted!");
            System.out.print("Data: ");
            System.out.println(data);
            synchronized (lock) {
                incommingBuffer.add(data);
            }
            System.out.println("End of transmission.");

            return TRUE;

        } else {
            System.out.println("Access Denied!");
            return FALSE;
        }

    }

    public boolean isThereNewData() throws java.rmi.RemoteException {
        return (incommingBuffer.isEmpty());
    }

    public String getData() throws java.rmi.RemoteException {
        String temp;
        synchronized (lock) {
            temp = incommingBuffer.remove();
        }
        return temp;
    }
}
