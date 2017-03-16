/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localsensor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author nb
 */
public class LocalSensor {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.NotBoundException
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        // TODO code application logic here
        
                SensorInterface i = (SensorInterface) Naming.lookup("//52.56.199.233:1099/sensorInterface");
                
                i.transferData("Niklas", "1234", "Temperaturen er 22 grader.");

    }
    
}
