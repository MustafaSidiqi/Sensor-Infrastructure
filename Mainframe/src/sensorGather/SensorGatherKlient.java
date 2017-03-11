package sensorGather;

//import galgeleg.*;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class SensorGatherKlient {
    static int indexMax = 0;
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        
        //boolean aktiv = true; // Boolean til at se om spillet skal spilles
        SensorGatherI g = (SensorGatherI) Naming.lookup("rmi://localhost:1099/SensorGatherService");

        g.getSensorData();
        
        for (Integer temp : g.getSensorData()) {
            data.add(temp);
            indexMax++;
        }
        for(int i = 0; i < data.size()-1;i++){
        System.out.println("Value at index: " + i + " is " + data.get(i));
        }
        
        String bruger = "s153712";
        String pass = "yas12!";
        g.setLogin(bruger, pass);
        
        System.out.println("Username = " + g.getLogin());
        System.out.println("Password = " + loginData.password);
    }
}
