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
public class SensorData {
    
    // Data
    String type; // Temperature, Image, People
    String dataType; // Metadata, Rawdata
    String unit; // Celcius, JPEG, amount
    int value; // Value
    // File???
    
    // Timestamp
    int seconds;
    int minutes;
    int hours;
    int day;
    int month;
    int year;
    
    // Which sensor it belongs to
    String sensorName;
    
    // Security
    
}
