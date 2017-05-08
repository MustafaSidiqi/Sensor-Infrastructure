/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorsystem;

import SensorDataType.Sensor;
import SensorDataType.SensorDataType;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    static String inonsense; //(SKAL RANDOMIZES)
    static String decodedNonsense;
    static String XORNonsense;
    static String publicKey; //(SKAL RANDOMIZES)
    static String ServerHandshakeLogHash;
    static String ClientHandshakeLogHash;
    static String handshakeLog; 
    static String XORNonsenseHex; 
    static ArrayList<String> hsl = new ArrayList<>();
    static String data;
    static int count = 0;
    
    // Sensor Array
    
    static HashMap<Integer, Sensor> sensorList = new HashMap<>();


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    boolean listeningToSensors;

    public Queue<SensorDataType> incomingBuffer;

    private final Object lock = new Object();

    public SensorSystem(UserInterface _ui, UserAuthentication _sec, DataControl _offdata, DataControl _expdata, UserControl _users, SensorControl _sensors) throws RemoteException, NoSuchAlgorithmException {

        ui = _ui;
        sec = _sec;
        users = _users;
        sensors = _sensors;
        offdata = _offdata;
        expdata = _expdata;

        this.listeningToSensors = true;

        incomingBuffer = new LinkedList<SensorDataType>();

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
            
            SensorDataType data = new SensorDataType(eData);

            synchronized (lock) {

                incomingBuffer.add(data);

            }

            System.out.println("End of transmission.");

            return TRUE;

        } else {

            System.out.println("Access Denied!");

            return FALSE;

        }

    }
    
    public SensorDataType receiveData() {

        if(!incomingBuffer.isEmpty()) {

            synchronized (lock) {
                
                SensorDataType outputdata = incomingBuffer.remove();
                
                System.out.println("Data Output:"+outputdata);
                
                return outputdata;
            }
        
        } else {
            
            return null;
    
        }
        
    }
    
    public boolean dataWaiting() {
        
        return !incomingBuffer.isEmpty();
        
    }

    public int requestConnection(int Sensor_ID) {
        
        System.out.println("Sensor is requesting for connection...");
        
        Sensor sensor; 
        
        if(!sensorList.containsKey(Sensor_ID)) { // Check if it's already an object
            
            if(sensors.getSensor(Sensor_ID) != 0) { // Check if it's in the database
                
                Sensor_ID = sensors.addSensor("unknown", "unknown", "unknown", 0); // Create new sensor in database
            
            }
            
            sensor = new Sensor(); // Create new object
            
            sensorList.put(Sensor_ID, sensor); // Insert into the hashmap
        
        } else {
            
            sensor = sensorList.get(Sensor_ID); // Retrieve from hashmap
        
        }
        
        sensor.handshakeLog = "true "; // Add true
        
        sensor.count++; // Incredement count

        return Sensor_ID;

    }

    public String getNonsense(int Sensor_ID) {
        
        Sensor sensor = sensorList.get(Sensor_ID);
        
        sensor.nonsense = StringGen.generateString(sensor.sg.ran, "ABCDEF123456789", 32);

        sensor.handshakeLog = sensor.handshakeLog.concat(sensor.nonsense) + " ";

        sensor.count++;

        System.out.println("Nonsense: " + sensor.nonsense);

        return sensor.nonsense;

    }

    public String getPublicKey(int Sensor_ID) throws NoSuchAlgorithmException {
       
        Sensor sensor = sensorList.get(Sensor_ID);
        
        sensor.publicKey = StringGen.generateString(sensor.sg.ran, "ABCDEF123456789", 32);
        
        sensor.handshakeLog = sensor.handshakeLog.concat(sensor.publicKey) + " ";
        
        return sensor.publicKey;
    }

    public void sendCipherInonsense(int Sensor_ID, String encryptedMessage) {

        Sensor sensor = sensorList.get(Sensor_ID);
        
        sensor.handshakeLog = sensor.handshakeLog.concat(encryptedMessage);

        sensor.count++;

        try {
            sensor.inonsense = Crypt.decrypt(encryptedMessage, sensor.publicKey);
            System.out.println("Inonsense:  "+sensor.inonsense);
            sensor.XORNonsense = x.xorHex(sensor.nonsense, sensor.inonsense);
            System.out.println("XORNonsense :" + sensor.XORNonsense);
            sensor.XORNonsenseHex = Crypt.toHex(sensor.XORNonsense).toUpperCase().substring(0, 32);
            System.out.println("XORNonsenseHex: "+sensor.XORNonsenseHex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendLogHashCipher(int Sensor_ID, String hashLog) {
        
        Sensor sensor = sensorList.get(Sensor_ID);

        sensor.count++;

        try {
            sensor.ClientHandshakeLogHash = Crypt.decrypt(hashLog, sensor.XORNonsenseHex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean recieveOK(int Sensor_ID) throws NoSuchAlgorithmException {
        
        Sensor sensor = sensorList.get(Sensor_ID);

        sensor.ServerHandshakeLogHash = h.stringHash(sensor.handshakeLog);
        
        System.out.println("handshake Log: "+sensor.handshakeLog);
        System.out.println("server handshake Log: "+sensor.ServerHandshakeLogHash);
        System.out.println("client handshake Log: "+sensor.ClientHandshakeLogHash);

        sensor.count++;
        
        
        return sensor.ServerHandshakeLogHash.hashCode() == sensor.ClientHandshakeLogHash.hashCode();
    }

}
