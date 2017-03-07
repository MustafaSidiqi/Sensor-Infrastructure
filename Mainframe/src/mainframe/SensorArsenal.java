/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;

/**
 *
 * @author nb
 */

public class SensorArsenal {
    
    private ArrayList<SensorInfo> sensorList;
    private ArrayList<String> sensorID;
    private int sensorCount;
    
    SensorArsenal() {
        
        this.sensorList = new ArrayList<SensorInfo>();
        this.sensorID = new ArrayList<String>();
        sensorCount = 0;
        
    }

    public void newSensor(String _name, String _password, String _sensortype, String _datatype, String _dataunit) { // Add a sensor to the arsenal
        
        SensorInfo newSensor = new SensorInfo(_name, _password, _sensortype, _datatype, _dataunit); // Create new object
        
        sensorList.add(newSensor); // Add the object to the list
        
        sensorID.add(_name); // Add the name to the ID list
        
        sensorCount++;
        
        System.out.println(_name + " added.");
   
    }
    
    public int indexSensor(String name) {
        
        if(!sensorID.contains(name)) {
            System.out.println("Sensor not found.");
            return -1;
        }
        
        int index;
        
        index = sensorID.indexOf(name);
        
        System.out.println("Sensor found!");
        
        return index;
        
    } 
    
    public void deleteSensor(String name) {
        
        int index = indexSensor(name);
        
        sensorID.remove(index);
        
        sensorList.remove(index);
        
        sensorCount--;
        
        System.out.println(name + " deleted.");
        
    }
    
    public void grantAccess(String name) { // Grant a sensor access to upload data
        
        int index = indexSensor(name);
        
        sensorList.get(index).authenticateSensor(TRUE);
        
    } 
    
    public void removeAccess(String name) {
        
        int index = indexSensor(name);
        
        sensorList.get(index).authenticateSensor(FALSE);
        
    }
    
    public int authenticateSensor(String name, String password) {
        
        int index = indexSensor(name);
        
        return sensorList.get(index).checkSensorPassword(password);
        
    }
    
    public ArrayList<String> listSensors() {
        
        for(int i = 0; i < sensorList.size(); i++) {
            System.out.print(sensorList.get(i));
        }
        
        return sensorID;
    
    }

}