package mainframe;

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
    static boolean sent = false;
    private static final String sensorID = "1";
    private static final String sensorType = "Temperature";
    private static final String sensorUnit = "Celcius";
    private static final String sensorLocation = "Test";
    
    static String timeStamp;
    
    public static void main(String[] args) throws Exception {
        //System.setSecurityManager(new RMISecurityManager());

        //SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://localhost/kontotjeneste");
        SensorInterface g = (SensorInterface) Naming.lookup("rmi://localhost:53712/sensorcommandcenter");
        String stringData;

        while (true) {
            timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
            Random rand = new Random();
            float value = rand.nextInt(20);
            Thread.sleep(3000);

            stringData = sensorID.concat(" ").concat(sensorLocation).concat(" ").concat(sensorType).concat(" ").concat(sensorUnit).concat(" ").concat(Float.toString(value)).concat(" ").concat(timeStamp).concat(" ").concat("25");
            sent = g.transferData(username, password, stringData);
            if(sent){
                System.out.println("Send!");
            }
            else {
                System.out.println("Failed!");
            }
            System.out.println("String :" + stringData);
            // 1 LYNGBY TEMPERATURE CELSIUS 23,07 2017-03-13 15:01:26 25
        }
    }
}
