package sensorGather;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.Random;
import mainframe.SensorInterface;
import static sensorGather.SensorGatherServer.timeStamp;
//import java.util.Scanner;

public class SensorGatherKlient {
    static int indexMax = 0;
    public static void main(String[] args) throws Exception {
        //System.setSecurityManager(new RMISecurityManager());


        //ArrayList<String> data = new ArrayList<>();
        
        //boolean aktiv = true; // Boolean til at se om spillet skal spilles
        //SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://ubuntu4.javabog.dk:53720/s153712");
        //SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://localhost/kontotjeneste");
        
        SensorInterface g = (SensorInterface) Naming.lookup("rmi://52.56.199.233/sensorcommandcenter");


        //
        
        /*
        g.getSensorData();
        
        for (String temp : g.getSensorData()) {
            data.add(temp);
            indexMax++;
        }
        
        for(int i = 0; i < data.size();i++){
        System.out.println(data.get(i));
        }

        */
        
        String bruger = "s153712";
        String pass = "yas12!";
        String stringData = "";
        //g.setLogin(bruger, pass);

        
        
        while (true) {
 
            Random rand = new Random();
            int value = rand.nextInt(20);
            Thread.sleep(3000);

            stringData = g.addTogether().concat(Integer.toString(value)).concat(" ").concat(timeStamp);
            //g.storeData(stringData);
            //g.storeData(value);
            System.out.println("String :" + stringData);
            //g.clearDataArray();
            
            g.transferData(bruger,pass,stringData);

            //Integer.toString(i)
            //"to".concat("get").concat("her")
            //
        }
        
        /*
        
        //System.out.println("Username = " + g.getUsername());
        //System.out.println("Password = " + g.getPassword());
        System.out.println("Data amount = " + g.getDataAmount());
        System.out.println("ID = " + g.getID());
        System.out.println("Type = " + g.getType());
        System.out.println("Name = " + g.getName());
        System.out.println("Unit = " + g.getUnit());

        */
        
        
    }
}
