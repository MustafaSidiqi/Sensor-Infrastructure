/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import java.io.UnsupportedEncodingException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author MSC
 */

public class SensorImpl extends UnicastRemoteObject implements SensorInterface {

        //Michaels ting til AES encryption og handshake af sensor////////////////////////////////////////////////////
    static String IV = "AAAAAAAAAAAAAAAA";
    static String nonsense = "0a1b2c3d4e5f6789"; //(SKAL RANDOMIZES)
    static String decodedNonsense;
    static String XORNonsenseS;
    static String publicKey = "0123456789abcdef"; //(SKAL RANDOMIZES)
    static String handshakeLogHash;
    
    
    static XORStrings x; //object of XOR functions
    static Crypt c;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public UserAuthentication ua;
    boolean listeningToSensors;
    private Queue<String> incommingBuffer;
    //CyberCommunicationCenter nasa;
    //DataManipulationService db;
    
    private final Object lock = new Object();

    public SensorImpl() throws java.rmi.RemoteException {
        this.listeningToSensors = true;
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

            return true;

        } else {
           System.out.println("Access Denied!");
            return false;
        }
    }

        //Cryptographi functions
    boolean requestConnection() throws java.rmi.RemoteException {
        return true;
    }
    String getNonsense() throws java.rmi.RemoteException{
        return nonsense;
    }
    String getPublicKey() throws java.rmi.RemoteException{
        return publicKey;
    }    
    
    void sendLogHashCipher(byte[] logHash )throws java.rmi.RemoteException, Exception{
        handshakeLogHash = c.decrypt(logHash, publicKey);
    }
    
    void sendCipherInonsense(byte[] cipher )throws java.rmi.RemoteException, Exception{
        decodedNonsense = c.decrypt(cipher, publicKey);
        x.encode(decodedNonsense, nonsense);
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
