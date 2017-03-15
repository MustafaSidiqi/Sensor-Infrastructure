package sensorGather;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
//import mainframe.SensorInterface;
//import java.util.Scanner;

public class SensorGatherKlient {

    static int indexMax = 0;
    static String username = "s153712";
    static String password = "yas12!";
    private static final String sensorID = "1";
    private static final String sensorType = "Temperature";
    private static final String sensorUnit = "Celcius";
    private static final String sensorLocation = "Lyngby";
    
    static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    
    public static void main(String[] args) throws Exception {
        //System.setSecurityManager(new RMISecurityManager());

        //SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://localhost/kontotjeneste");
        SensorInterface g = (SensorInterface) Naming.lookup("rmi://52.56.199.233:1337/sensorcommandcenter");
        String stringData;

        while (true) {
            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            Random rand = new Random();
            int value = rand.nextInt(20);
            Thread.sleep(3000);

            stringData = sensorID.concat(" ").concat(sensorLocation).concat(" ").concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Integer.toString(value)).concat(" ").concat(timeStamp);
            g.transferData(username, password, stringData);
            
            //System.out.println("String :" + stringData);
        }
    }
}
