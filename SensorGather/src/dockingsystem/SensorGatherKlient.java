package dockingsystem;

import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Random;

public class SensorGatherKlient {

    static int indexMax = 0;
    static int ownerID = 0;
    static String username = "s153712";
    static String name = "Michael";
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
    static int ID = 1;

    //encryption
    static String IV; //on both server and client
    static String nonsense;
    static String inonsense; //inonsense local string in client (has to be randomized)
    static String Einonsense; //encrypted inonsense
    static String XORNonsense = "0"; //The XOR'ed string of inonsense and nonsense (client (client token)
    static String publicKey; //recieved from server (has to be randomized)
    static String handshakeLog; //log of handshake for hashing
    static String handshakeLogHash; //log of handshake for hashing
    static String XORNonsenseHex;
    static String eUsername;
    static String ePassword;
    static XORStrings x = new XORStrings(); //object of XOR functions
    static Crypt c = new Crypt(); //object of XOR functions
    static Hashing h = new Hashing();
    static StringGen sg = new StringGen();
    static String data;

    public static void main(String[] args) throws Exception /*NoSuchAlgorithmException, NotBoundException, MalformedURLException, RemoteException, InterruptedException */ {
        //System.setSecurityManager(new RMISecurityManager());
        DockIntRMI g = (DockIntRMI) Naming.lookup("rmi://ubuntu4.javabog.dk:53712/sensorRMI");
        //DockIntRMI g = (DockIntRMI) Naming.lookup("rmi://localhost:53712/sensorRMI");

        inonsense = StringGen.generateString(sg.ran, "ABCDEF123456789", 32);
        
        ID = g.requestConnection(name, sensorLocation, sensorUnit, ownerID, 3);
        count++;
        handshakeLog = "true ";

        publicKey = g.getPublicKey(ID);
        nonsense = g.getNonsense(ID);
        count++;
        handshakeLog = handshakeLog.concat(publicKey + " " + nonsense);
        
        System.out.println(nonsense.length());
        System.out.println(inonsense.length());
        
        XORNonsense = x.xorHex(nonsense, inonsense);
        XORNonsenseHex = Crypt.toHex(XORNonsense).toUpperCase().substring(0, 32);

        Einonsense = Crypt.encrypt(inonsense, publicKey);
        g.sendCipherInonsense(ID,Einonsense);
        count++;
        handshakeLog = handshakeLog.concat(" " + Einonsense);
        
        System.out.println("publicKey:      " + publicKey);
        System.out.println("INonsense:      " + inonsense);
        System.out.println("Nonsense:       " + nonsense);
        System.out.println("XORNonsense:    " + XORNonsense);
        System.out.println("XORNonsenseHex: " + XORNonsenseHex);
        System.out.println("Handshake log: " + handshakeLog);

        handshakeLogHash = h.stringHash(handshakeLog);

        g.sendLogHashCipher(ID,Crypt.encrypt(handshakeLogHash, XORNonsenseHex));

        count++;

        access = g.recieveOK(ID);

        while (access) {
            timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
            Random rand = new Random();
            float value = rand.nextInt(20);
            Thread.sleep(3000);

            data = sensorID.concat(" ").concat(sensorLocation).concat(" ").concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Float.toString(value)).concat(" ").concat(timeStamp).concat(" ").concat("25");
            count++;
            
            eUsername = Crypt.encrypt(username, XORNonsenseHex);
            ePassword = Crypt.encrypt(password, XORNonsenseHex);
            
            sent = g.transferDataRMI(eUsername, ePassword, data, count, ID); 
            if (sent) {
                System.out.println("Send!");
            } else {
                System.out.println("Failed!");
            }
            System.out.println("Data :" + data);
        }
    }
}
