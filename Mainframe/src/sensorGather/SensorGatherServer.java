package sensorGather;

import java.rmi.Naming;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Random;

public class SensorGatherServer {

    static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
    
    public static void main(String[] args) throws Exception {
        String stringData = "";

        // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
        //java.rmi.registry.LocateRegistry.createRegistry(53720); // start i server-JVM
        java.rmi.registry.LocateRegistry.createRegistry(1099);

        SensorGatherI g = new SensorGatherImpl();
        Naming.rebind("rmi://localhost/kontotjeneste", g);
        //Naming.rebind("rmi://[::]:53712/s153712", g);
        System.out.println("DTU shizz initialiseret.");
        while (true) {
            Random rand = new Random();
            int value = rand.nextInt(20);
            Thread.sleep(3000);

            stringData = g.addTogether().concat(Integer.toString(value)).concat(" ").concat(timeStamp);
            g.storeData(stringData);
            //g.storeData(value);
            System.out.println("String :" + stringData);
            //g.clearDataArray();

            //Integer.toString(i)
            //"to".concat("get").concat("her")
            //
        }
    }
}
