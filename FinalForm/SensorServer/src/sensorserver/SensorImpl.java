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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author MSC
 */

public class SensorImpl extends UnicastRemoteObject implements SensorInterface {

        //Michaels ting til AES encryption og handshake af sensor////////////////////////////////////////////////////
    static String IV = "AAAAAAAAAAAAAAAA";
    static String nonsense = "0a1b2c3d4e5f6789"; //(SKAL RANDOMIZES)
    static String decodedNonsense;
    static String XORNonsense;
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

        //if (ua.login(username, password) && listeningToSensors) {
            System.out.println("Access Granted!");
            System.out.print("Data: ");
            System.out.println(data);
            //synchronized (lock) {
            //    incommingBuffer.add(data);
            //}
            System.out.println("End of transmission.");

          //  return TRUE;

//        } else {
  //          System.out.println("Access Denied!");
 //           return FALSE;
   //     }
        return true;
    }

    @Override
    public boolean requestConnection() throws java.rmi.RemoteException {
        return true;
    }
    
    @Override
    public String getNonsense() throws java.rmi.RemoteException{
        return nonsense;
    }
    
    @Override
    public String getPublicKey() throws java.rmi.RemoteException{
        return publicKey;
    }
    
    @Override
    public void sendCipherInonsense(byte[] encryptedMessage) throws java.rmi.RemoteException {
        try {
            XORNonsense = x.encode(nonsense, c.decrypt(encryptedMessage, publicKey, IV));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendLogHashCipher(byte[] hashLog) throws RemoteException {
        try {
            handshakeLogHash = c.decrypt(hashLog, publicKey, IV);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
