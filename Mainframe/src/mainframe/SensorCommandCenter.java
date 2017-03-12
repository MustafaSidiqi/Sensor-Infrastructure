/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author nb
 */
public class SensorCommandCenter extends UnicastRemoteObject implements SensorInterface {
    public SecurityBureau cia;
    boolean listeningToSensors;
    private final Queue<String> incommingBuffer;
    CyberCommunicationCenter nasa;
    DataManipulationService db;
    
    SensorCommandCenter() {
        this.listeningToSensors = FALSE;
        incommingBuffer = new LinkedList<>();
    }
    
    @Override
    public boolean transferData(String username, String password, String data) { // Listen to sensors
        
        System.out.println("Incomming Data!");
        
        System.out.println("Background checking user...");

        if(cia.login(username, password) && listeningToSensors) {
            System.out.println("Access Granted!");
            System.out.println("Data: ");
            System.out.println(data);
            incommingBuffer.add(data);
            System.out.println("End of transmission.");
            return TRUE;
        } else {
            System.out.println("Access Denied!");
            return FALSE;
        }
        
    }
    
    public boolean isThereNewData() {
        return this.incommingBuffer.isEmpty();
    }
    
    public String getData() {
        return this.incommingBuffer.remove();
    }
}