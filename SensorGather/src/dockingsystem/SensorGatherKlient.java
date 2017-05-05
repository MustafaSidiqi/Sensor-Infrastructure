package dockingsystem;

import java.rmi.Naming;
import java.security.MessageDigest;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import mainframe.DockIntRMI;
//import java.util.Scanner;

public class SensorGatherKlient {

    static int indexMax = 0;
    static String username = "s153712";
    static String password = "yas12!";
    static boolean sent = false;
    private static final String sensorID = "1";
    private static final String sensorType = "Temperature";
    private static final String sensorUnit = "Celcius";
    private static final String sensorLocation = "Test";
    static String timeStamp;
    static boolean access = false;
    static boolean connect = false;
    static boolean idle = true;
    static int count = 0;

    //encryption
    static String IV = "AAAAAAAAAAAAAAAA"; //on both server and client
    static String nonsense;
    static String inonsense = "fedcba9876543210"; //inonsense local string in client (has to be randomized)
    static String Einonsense; //encrypted inonsense
    static String XORNonsense = "0"; //The XOR'ed string of inonsense and nonsense (client (client token)
    static String publicKey; //recieved from server (has to be randomized)
    static String handshakeLog; //log of handshake for hashing
    static String handshakeLogHash; //log of handshake for hashing
    static XORStrings x = new XORStrings(); //object of XOR functions
    static Crypt c = new Crypt(); //object of XOR functions
    static Hashing h = new Hashing();
    static StringGen sg = new StringGen();
    static String data;
    

    public static void main(String[] args) throws Exception /*NoSuchAlgorithmException, NotBoundException, MalformedURLException, RemoteException, InterruptedException */ {
        //System.setSecurityManager(new RMISecurityManager());
        DockIntRMI g = (DockIntRMI) Naming.lookup("rmi://localhost:53712/sensorRMI");
        
        
        connect = g.requestConnection();
        count++;
        handshakeLog = "true ";
        
        publicKey = g.getPublicKey();
        nonsense = g.getNonsense();
        count++;
        handshakeLog = handshakeLog.concat(publicKey + " " + nonsense);
        
        
        XORNonsense = x.encode(nonsense, inonsense);
        System.out.println(XORNonsense);
        System.out.println(publicKey);
        
        inonsense = StringGen.generateString(sg.ran, "ABCDEF123456789", 32);
        
        Einonsense = Crypt.encrypt(inonsense, publicKey);
        g.sendCipherInonsense(Einonsense);
        count++;
        handshakeLog = handshakeLog.concat(" "+Einonsense);
        
        System.out.println("Handshake log: "+handshakeLog);
        
        handshakeLogHash = h.stringHash(handshakeLog);
        g.sendLogHashCipher(Crypt.encrypt(handshakeLogHash, publicKey)); //Chance inonsense to XORNonsense
        count++;
        
        access = g.recieveOK();
        
        while (access) {
                timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                Random rand = new Random();
                float value = rand.nextInt(20);
                Thread.sleep(3000);

                data = sensorID.concat(" ").concat(sensorLocation).concat(" ").concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Float.toString(value)).concat(" ").concat(timeStamp).concat(" ").concat("25");
                count++;
                sent = g.transferDataRMI(username, password, data, count); //Public key skal ændres til XORNonsense hvis kryptes
                if (sent) {
                    System.out.println("Send!");
                } else {
                    System.out.println("Failed!");
                }
                System.out.println("Data :" + data);
                
                System.out.println("Handshake: " + handshakeLog);
                
                access = g.recieveOK();
            }
        }
}
