/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
class SensorData {

    public int Data_ID;
    public int Sensor_ID;
    public String Location;
    public int Type;
    public int Unit;
    public float Value;
    public Timestamp Date;
    public int Checksum;

    public SensorData() {

    }

    public void setSD(ResultSet obj){

        try {
            Data_ID = (int) obj.getObject(1);
            Sensor_ID = (int) obj.getObject(2);
            Location = (String) obj.getObject(3);
            Type = (int) obj.getObject(4);
            Unit = (int) obj.getObject(5);
            Value = (float) obj.getObject(6);
            Date = (Timestamp) obj.getObject(7);
            Checksum = (int) obj.getObject(8);
        } catch (SQLException ex) {
            Logger.getLogger(SensorData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    // this is test function.... dont use this in finished project 
    public void printData(){
        System.out.println("Data_ID = "+Data_ID+" Sensor_ID = "+Sensor_ID+" Location = "+Location+" Type = "+Type+" Unit = "+" Date = "+Date+" Checksum = "+Checksum);
    } 

}
