package sensorGather;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import mainframe.SensorInterface;
import static sensorGather.SensorGatherServer.timeStamp;
//import java.util.Scanner;

public class SensorGatherKlient {

    static int indexMax = 0;
    static String username = "";
    static String password = "";
    private static final String sensorID = "0001";
    private static final String sensorType = "Temperature";
    private static final String sensorDataType = "Integer";
    private static final String sensorUnit = "Celcius";
    private static final String sensorName = "Temperature Data";

    public static void main(String[] args) throws Exception {
        //System.setSecurityManager(new RMISecurityManager());

        //System.setSecurityManager(new RMISecurityManager());
        //SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://localhost/kontotjeneste");
        SensorInterface g = (SensorInterface) Naming.lookup("rmi://52.56.199.233:1337/sensorcommandcenter");
        String stringData = "";

        while (true) {
            timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            Random rand = new Random();
            int value = rand.nextInt(20);
            Thread.sleep(3000);

            stringData = "1 LYNGBY ".concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Integer.toString(value)).concat(" ").concat(timeStamp);
            g.transferData(username, password, stringData);
            
            //System.out.println("String :" + stringData);
        }
    }
}
