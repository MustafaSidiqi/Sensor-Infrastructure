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
    static String XORNonsenseS;
    static String publicKey = "0123456789abcdef"; //(SKAL RANDOMIZES)
    static XORStrings x = new XORStrings(); //object of XOR functions
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
    public boolean transferDataRMI(String username, String password, String data) throws java.rmi.RemoteException { // Listen to sensors

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

    /*
    boolean requestConnection() throws java.rmi.RemoteException {
        return true;
    }
    String getNonsense() throws java.rmi.RemoteException{
        return nonsense;
    }
    String getPublicKey() throws java.rmi.RemoteException{
        return publicKey;
    }
    byte[] sendCipherInonsense(byte[] encryptedMessage) throws java.rmi.RemoteException, Exception{
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(publicKey.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        String inonsense = String(cipher.doFinal(encryptedMessage),"UTF-8");
  }

    @Override
    public boolean isThereNewData() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    byte[] sendCipherHash(byte[] cipher )throws java.rmi.RemoteException{
        
    }
*/
    
    
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
