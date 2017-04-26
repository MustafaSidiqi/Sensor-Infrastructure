package sensorserver;

import java.rmi.Naming;
import java.security.MessageDigest;

import java.text.SimpleDateFormat;

import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import mainframe.SensorInterface;
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
    static boolean idle = true;

    //encryption
    static String IV = "AAAAAAAAAAAAAAAA"; //on both server and client
    static String nonsense;
    static String inonsense = "fedcba9876543210"; //inonsense local string in client (has to be randomized)
    static byte[] Einonsense; //encrypted inonsense
    static String XORNonsense = "0"; //The XOR'ed string of inonsense and nonsense (client (client token)
    static String publicKey; //recieved from server (has to be randomized)
    static String handshakeLog; //log of handshake for hashing
    static String handshakeLogHash; //log of handshake for hashing
    static XORStrings x; //object of XOR functions
    static Crypt c; //object of XOR functions
    static Hashing h;
    

    public static void main(String[] args) throws Exception /*NoSuchAlgorithmException, NotBoundException, MalformedURLException, RemoteException, InterruptedException */ {
        //System.setSecurityManager(new RMISecurityManager());
        SensorInterface g = (SensorInterface) Naming.lookup("rmi://localhost:53712/sensorimpl");
        String stringData;
        
        access = g.requestConnection();
        
        publicKey = g.getPublicKey();
        nonsense = g.getNonsense();
        
        XORNonsense = x.encode(nonsense, inonsense);
        
        Einonsense = c.encrypt(inonsense, publicKey, IV);
        g.sendCipherInonsense(Einonsense);
        
        handshakeLogHash = h.stringHash(handshakeLog);
        g.sendLogHashCipher(c.encrypt(handshakeLogHash, publicKey, IV));
        
        while (true) {
                timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
                Random rand = new Random();
                float value = rand.nextInt(20);
                Thread.sleep(3000);

                stringData = sensorID.concat(" ").concat(sensorLocation).concat(" ").concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Float.toString(value)).concat(" ").concat(timeStamp).concat(" ").concat("25");
                sent = g.transferData(username, password, stringData);
                if (sent) {
                    System.out.println("Send!");
                } else {
                    System.out.println("Failed!");
                }
                System.out.println("String :" + stringData);
            }
        }
}
