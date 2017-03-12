package sensorGather;

import java.rmi.Naming;

import java.util.Random;

public class SensorGatherServer {

    public static void main(String[] args) throws Exception {

        // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
        java.rmi.registry.LocateRegistry.createRegistry(53712); // start i server-JVM

        SensorGatherI g = new SensorGatherImpl();
        //Naming.rebind("rmi://localhost:1099/SensorGatherService", g);
        Naming.rebind("rmi://[::]:53712/s153712", g);
        System.out.println("DTU shizz initialiseret.");
        while (true) {
            Random rand = new Random();
            int value = rand.nextInt(50);
            Thread.sleep(3000);
            g.storeData(value);
            System.out.println("value :" + value);
            g.clearDataArray();
        }
    }
}
