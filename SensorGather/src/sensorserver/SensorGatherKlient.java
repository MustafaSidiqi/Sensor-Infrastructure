package sensorserver;

import java.rmi.Naming;

import java.text.SimpleDateFormat;

import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
//import mainframe.SensorInterfaceRMI;
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
    static String XORNonsenseC = "0"; //The XOR'ed string of inonsense and nonsense (client (client token)
    static String publicKey; //recieved from server (has to be randomized)
    static String handshakeLog; //log of handshake for hashing
    static XORStrings x = new XORStrings(); //object of XOR functions

    public static void main(String[] args) throws Exception /*NoSuchAlgorithmException, NotBoundException, MalformedURLException, RemoteException, InterruptedException */ {
        //System.setSecurityManager(new RMISecurityManager());
        SensorInterfaceRMI g = (SensorInterfaceRMI) Naming.lookup("rmi://localhost:53712/sensorimpl");
        String stringData;

        /*
        handshakeLog = publicKey;
        handshakeLog = handshakeLog.concat(" " + nonsense);

        XORNonsenseC = x.encode(nonsense, inonsense);

        try {

            System.out.println("inonsense          " + inonsense);
            System.out.println("nonsense:          " + nonsense);
            System.out.println("XOR'ed nonsense:   " + XORNonsenseC);

            byte[] cipher = encrypt(inonsense, publicKey);

            handshakeLog = handshakeLog.concat(" " + cipher.toString());

            System.out.print("cipher:            ");

            for (int i = 0; i < cipher.length; i++) {
                System.out.print(new Integer(cipher[i]) + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //client hashing the handshake
        System.out.println("handshake log:     " + handshakeLog);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(handshakeLog.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());
         */
        if (XORNonsenseC != "0") //has to be equal to something
        {
            access = true;
        } else {
            System.out.println("Beginning handshake.");
            handshakeLog = publicKey;
            handshakeLog = handshakeLog.concat(" " + nonsense);
            while (idle) {
                idle = g.requestConnection();
                Thread.sleep(2000);
            }
            nonsense = g.getNonsense();
            publicKey = g.getPublicKey();
            XORNonsenseC = x.encode(nonsense, inonsense);

            System.out.println("inonsense          " + inonsense);
            System.out.println("nonsense:          " + nonsense);
            System.out.println("XOR'ed nonsense:   " + XORNonsenseC);

            try {
                byte[] cipher = encrypt(inonsense, publicKey);

                handshakeLog = handshakeLog.concat(" " + cipher.toString());

                System.out.print("cipher:            ");

                for (int i = 0; i < cipher.length; i++) {
                    System.out.print(new Integer(cipher[i]) + " ");
                }
                
                System.out.print("Sending Cipher inonsense");
                g.sendCipherInonsense(cipher);
                
                byte[] cipherHash = encrypt(handshakeLog, publicKey);

                System.out.print("cipher for handshake:");

                for (int i = 0; i < cipherHash.length; i++) {
                    System.out.print(new Integer(cipher[i]) + " ");
                }
                
                System.out.print("Sending Cipher hash");
                g.sendCipherHash(cipherHash);

                access = true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        while (access) {
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

    //function that encrypts message using AES (Client)
    public static byte[] encrypt(String plainText, String publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(publicKey.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return cipher.doFinal(plainText.getBytes("UTF-8"));
    }

    // 1 LYNGBY TEMPERATURE CELSIUS 23,07 2017-03-13 15:01:26 25

}
