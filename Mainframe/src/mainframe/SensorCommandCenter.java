/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 *
 * @author nb
 */
public class SensorCommandCenter {
    
    boolean listeningToSensors;
    
    SensorCommandCenter() {
        this.listeningToSensors = FALSE;
    }
    
    public void listenToSensors() { // Listen to sensors
        
        // 1. New sensor want to be added to arsenal
        // 2. Sensor wants to add data to servers
            // Authenticate
        
        while(listeningToSensors) {
            
        }
        
    }
    
    public void askSensor(int SensorID, String SensorName) {
        
        // 1. Ask sensor for data
        
    }
    
    public void startListening() {
        this.listeningToSensors = TRUE;
    }
    
    public void stopListening() {
        this.listeningToSensors = FALSE;
    }
    
}