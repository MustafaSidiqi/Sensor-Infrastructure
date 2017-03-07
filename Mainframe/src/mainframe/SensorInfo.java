/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import static java.lang.Boolean.FALSE;

/**
 *
 * @author nb
 */
public class SensorInfo {
    
    // Credentials
    private String name; // Object name
    private int ID; // Sensor ID
    private String password;
    private boolean authenticated;
    
    // Information
    private String location; // // Location of the sensor
    private String description; // Short description
   
    // Sensor Information
    private String sensortype; // Type of sensor ie Termometer
    private String datatype; // Data type ie Tempeature
    private String dataunit; // Unit ie Celcius
    
    SensorInfo(String _name, int _ID, String _sensortype, String _datatype, String _dataunit) { // Constructor
        this.name = _name;
        this.ID = _ID;
        this.password = Integer.toString((ID*2)+7);
        this.authenticated = FALSE;
        
        this.location = "Unknown";
        this.description = "n/a";
        
        this.sensortype = _sensortype;
        this.datatype = _datatype;
        this.dataunit = _dataunit;
        
    }
    
    public void setSensorLocation(String _location) { // Set location
        this.location = _location;
    }
    
    public void setDescription(String _descp) { // Set description
        this.description = _descp;
    }
    
    public void setSensorPassword(String currentPassword, String newPassword) { // Set a new password
        if(currentPassword == password) {
            this.password = newPassword;
            System.out.println("Password Changed.");
        } else {
            System.out.println("Wrong Password.");
            
        }
    }
    
    public int checkSensorPassword(String _password) { // Check for password
        if(_password == password) {
            System.out.println("Access Granted.");
            return 1;
        } else {
            System.out.println("Access Denied!");
            return 0;
        }
    }
    
    public void authenticateSensor(boolean input) { // Authenticate / deauthenticate sensor
        this.authenticated = input;
    }
}