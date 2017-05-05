/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import datasystem.DataControl;
import datasystem.SensorControl;
import datasystem.UserControl;
import dockingsystem.DockPubRMI;
import dockingsystem.DockPubSOAP;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import securitysystem.UserAuthentication;
import securitysystem.UserAuthenticationInterface;
import ui.UserInterface;

public class SensorSystem {

    UserInterface ui;
    UserAuthentication sec;
    DataControl offdata;
    DataControl expdata;
    SensorControl sensors;
    UserControl users;

    //Michaels ting til AES encryption og handshake af sensor////////////////////////////////////////////////////
    static XORStrings x = new XORStrings(); //object of XOR functions
    static Crypt c;
    static Hashing h = new Hashing();
    static StringGen sg = new StringGen();
    
    static String nonsense; //(SKAL RANDOMIZES)
    static String decodedNonsense;
    static String XORNonsense;
    static String publicKey; //(SKAL RANDOMIZES)
    static String ServerHandshakeLogHash;
    static String ClientHandshakeLogHash;
    static String handshakeLog;
    static String data;
    static int count = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    boolean listeningToSensors;

    private Queue<String> incommingBuffer;

    private final Object lock = new Object();

    public SensorSystem(UserInterface _ui, UserAuthentication _sec, DataControl _offdata, DataControl _expdata, UserControl _users, SensorControl _sensors) throws RemoteException, NoSuchAlgorithmException {

        ui = _ui;
        sec = _sec;
        users = _users;
        sensors = _sensors;
        offdata = _offdata;
        expdata = _expdata;

        this.listeningToSensors = true;

        incommingBuffer = new LinkedList<String>();

    }

    public void initialiseSensorDockingSystem() throws NoSuchAlgorithmException, RemoteException, MalformedURLException {

        System.out.println("Setting up sensor communication protocols...");

        System.out.println("Initializing SOAP...");

        DockPubSOAP.publish(ui.isOnline(), this);

        System.out.println("SOAP Running!");

        System.out.println("Setting up RMI...");

        DockPubRMI.publish(ui.isOnline(), this);

        System.out.println("RMI Running!");

        System.out.println("Initializing REST...");

        // REST Publish, Interface, Implementation...
        System.out.println("REST Running!");

        System.out.println("Sensor Communication Protocols Setup is finished!");

    }

    public boolean transferData(String eUsername, String ePassword, String eData, int count) throws Exception {

        System.out.println("Incomming Data!");

        System.out.println("Background checking user...");

        if (sec.login(eUsername, ePassword) && listeningToSensors) {

            System.out.println("Access Granted!");

            System.out.println("Transfering Data...");

            //data = c.decrypt(eData, publicKey, IV); //Chance publicKey with XORNonsense
            System.out.print("Data: ");

            System.out.println(eData);

            synchronized (lock) {

                incommingBuffer.add(eData);

            }

            System.out.println("End of transmission.");

            return TRUE;

        } else {

            System.out.println("Access Denied!");

            return FALSE;

        }

    }

    public boolean requestConnection() {

        System.out.println("Sensor is requesting for connection...");

        handshakeLog = "true ";

        count++;

        return true;

    }

    public String getNonsense() {
        
        nonsense = StringGen.generateString(sg.ran, "ABCDEF123456789", 32);

        handshakeLog = handshakeLog.concat(nonsense) + " ";

        count++;

        System.out.println("Nonsense: " + nonsense);

        return nonsense;

    }

    public String getPublicKey() throws NoSuchAlgorithmException {
        publicKey = StringGen.generateString(sg.ran, "ABCDEF123456789", 32);
        handshakeLog = handshakeLog.concat(publicKey) + " ";
        return publicKey;
    }

    public void sendCipherInonsense(String encryptedMessage) {

        handshakeLog = handshakeLog.concat(encryptedMessage);

        count++;

        try {
            XORNonsense = x.encode(nonsense, c.decrypt(encryptedMessage, publicKey));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendLogHashCipher(String hashLog) {

        count++;

        try {
            ClientHandshakeLogHash = Crypt.decrypt(hashLog, publicKey);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean recieveOK() throws NoSuchAlgorithmException {

        ServerHandshakeLogHash = h.stringHash(handshakeLog);
        
        System.out.println("handshake Log: "+handshakeLog);
        System.out.println("server handshake Log: "+ServerHandshakeLogHash);
        System.out.println("client handshake Log: "+ClientHandshakeLogHash);

        count++;

        return ServerHandshakeLogHash.hashCode() == ClientHandshakeLogHash.hashCode();
    }

}
