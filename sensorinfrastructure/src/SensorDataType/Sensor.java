/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SensorDataType;

import java.sql.Timestamp;
import java.util.ArrayList;
import sensorsystem.Crypt;
import sensorsystem.Hashing;
import sensorsystem.StringGen;

/**
 *
 * @author nb
 */
public class Sensor {
    
    
    public static Crypt c;
    public static Hashing h = new Hashing();
    public static StringGen sg = new StringGen();
    
    public static String nonsense;
    public static String inonsense;
    public static String decodeNonsense;
    public static String XORNonsense;
    public static String publicKey;
    public static String ServerHandshakeLogHash;
    public static String ClientHandshakeLogHash;
    public static String handshakeLog;
    public static String XORNonsenseHex;
    public static ArrayList<String> hsl = new ArrayList<>();
    public static int count = 0;
    
    // Sensor Database
    
    public int ID;
    public String Name;
    public String Location;
    public String Unit;
    public int Owner;
    public java.sql.Timestamp SetupTime;
    public int Status;
    public int DB_Status;
    public String Token;
    public String PrimaryKey;
    
    
}
