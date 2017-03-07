/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

/**
 *
 * @author nb
 */
public class SensorInfo {
    
    // Credentials
    String name; // Object name
    int ID; // Sensor ID
    String password;
    boolean authenticated;
    
    // Information
    String location; // // Location of the sensor
    String description; // Short description
   
    // Sensor Information
    String type; // Type of sensor ie Termometer
    String dataType; // Data type ie Tempeature
    String unit; // Unit ie Celcius

}