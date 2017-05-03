/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import java.io.UnsupportedEncodingException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
    static String ServerHandshakeLogHash;
    static String ClientHandshakeLogHash;
    static String handshakeLog;
    static String data;
    static int count = 0;

    static XORStrings x = new XORStrings(); //object of XOR functions
    static Crypt c = new Crypt();
    static Hashing h = new Hashing();
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public UserAuthentication ua;
    boolean listeningToSensors;
    private Queue<String> incommingBuffer;

    private final Object lock = new Object();

    public SensorImpl() throws java.rmi.RemoteException {
        this.listeningToSensors = true;
        incommingBuffer = new LinkedList<String>();
    }

    @Override
    public boolean transferData(byte[] eUsername, byte[] ePassword, byte[] eData, int count) throws java.rmi.RemoteException, Exception { // Listen to sensors
        SensorImpl.count++;
        System.out.println("Incomming Data!");

        System.out.println("Background checking user...");

        if (SensorImpl.count == count) {
            
            if (ua.login(c.decrypt(eUsername, publicKey, IV), c.decrypt(eUsername, publicKey, IV)) && listeningToSensors) { //Change public Key with XORNonsense
                System.out.println("Access Granted!");
                System.out.print("Data: ");
                data = c.decrypt(eData, XORNonsense, IV);
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
        return false;
    }

    @Override
    public boolean requestConnection() throws java.rmi.RemoteException {
        handshakeLog = "true ";
        count++;
        return true;
    }

    @Override
    public String getNonsense() throws java.rmi.RemoteException {
        handshakeLog = handshakeLog.concat(nonsense) + " ";
        count++;
        return nonsense;
    }

    @Override
    public String getPublicKey() throws java.rmi.RemoteException {
        handshakeLog = handshakeLog.concat(publicKey) + " ";
        return publicKey;
    }

    @Override
    public void sendCipherInonsense(byte[] encryptedMessage) throws java.rmi.RemoteException {
        handshakeLog = handshakeLog.concat(Arrays.toString(encryptedMessage)) + " ";
        count++;
        try {
            XORNonsense = x.encode(nonsense, c.decrypt(encryptedMessage, publicKey, IV));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void sendLogHashCipher(byte[] hashLog) throws RemoteException {
        count++;
        try {
            ClientHandshakeLogHash = c.decrypt(hashLog, XORNonsense, IV);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean recieveOK() throws RemoteException, NoSuchAlgorithmException {
        ServerHandshakeLogHash = h.stringHash(handshakeLog);
        count++;
        return ServerHandshakeLogHash.hashCode() == ClientHandshakeLogHash.hashCode();
    }
}
