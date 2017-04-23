/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class Sql_functions {
    private String DBName;
    private Connection con;
     
    protected void Sql_setup(String dbName, Connection con_link){
        con = con_link;
        DBName = dbName;
    } 

    /**
     *
     * @param SensID - What sensor is writing
     * @param loc - location of the server
     * @param type - type of the sensor
     * @param unit - unit of data
     * @param value - value of the data
     * @param s - date as a string type 2017-03-12 22:00:00
     * @param chsm - check sum inserts data into the table
     * 
     * Inserts data into DB 
     */
    public void insertData(int SensID, String loc, String type, String unit, float value, String s, int chsm) {
        try {
            
            /// dette funktion kan opdateres....... så det gemmer alt på et hug 
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `" + DBName + "`.`"+DBName+"` "
                    + "(`Data_ID`, `Sensor_ID`, `Location`, `Type`, `Unit`, `Value`, `Date`, `Checksum`) VALUES "
                    + "(NULL, '" + SensID + "', '" + loc + "', '" + type + "', '" + unit + "', '" + value + "', '" + s + "', '" + chsm + "');";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
            System.out.println("no");
        }
    }

    /**
     *
     * @param ID
     * @return array with SensorData object that are requested by ID
     */
    public ArrayList<String> getAllBySensorID(int ID){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Sensor_ID` = " + ID;
        return getData(req);
    }
    /**
     * 
     * @param ID
     * @param start
     * @param end
     * @return 
     * 
     * Returns ArrayList<DataStruct> by  Sensor ID and date interval
     */
    public ArrayList<String> getIntervalBySensorID(int ID, Date start, Date end){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Sensor_ID` = " + ID + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param type
     * @return ArrayList<DataStruct> by Sensor Data type
     */
    public ArrayList<String> getAllByType(int type){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Type` = " + type;
        return getData(req);
    }
    /**
     * 
     * @param type
     * @param start
     * @param end
     * @return ArrayList<DataStruct> by Sensor Data type and date intervall
     */
    public ArrayList<String> getIntervalByType(int type, Date start, Date end){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Type` = " + type + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param loc
     * @return ArrayList<DataStruct>  by sensor location 
     */
    public ArrayList<String> getAllByLocation(String loc){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Location` = " + loc;
        return getData(req);
    }
    
    /**
     * 
     * @param loc
     * @param start
     * @param end
     * @return ArrayList<DataStruct>  by sensor location and date intervall 
     */
    public ArrayList<String> getIntervalByLocation(String loc, Date start, Date end){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Location` = " + loc + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param d
     * @return ArrayList<DataStruct> by date 
     */
    public ArrayList<String> getAllByDate(Date d){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Date` = " + d;
        return getData(req);
    }
    
    /**
     * 
     * @param start
     * @param end
     * @return ArrayList<DataStruct>  by date intervall 
     */
    public ArrayList<String> getIntervalByDate(Date start, Date end){

        String req = "SELECT * FROM `"+DBName+"` WHERE `Date` >= '" + start + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param sql here you can write direct SQL command 
     * @return ArrayList<DataStruct> 
     */
    public ArrayList<String> directSQL(String sql){

        // securing for abuse
        String temp_sql = sql.toLowerCase();
        if (!temp_sql.contains("update") && !temp_sql.contains("delete") && !temp_sql.contains("insert") && !temp_sql.contains("create") && !temp_sql.contains("alter")) {
            return getData(sql);
        } else {
            return null;
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     * @param s
     * @return ArrayList<DataStruct>
     * 
     * This Executes sql command given by prev functions
     */
    private ArrayList<String> getData(String s) {
        ArrayList<String> data = new ArrayList<>(); // new Array list of the data
        try {
            Statement stmt = con.createStatement(); // creates new sql statment
            ResultSet rs = null;
            rs = stmt.executeQuery(s);  //executes query  
            while (rs.next()) {         // while more data to read 
                
                //String date =""+t.getYear()+t.getMonth()+t.getDate();
                String d =  (int)rs.getObject(1)       +" "+
                            (int) rs.getObject(2)      +" "+
                            (String) rs.getObject(3)   +" "+
                            (String) rs.getObject(4)   +" "+
                            (String) rs.getObject(5)   +" "+
                            (float) rs.getObject(6)    +" "+
                            (Timestamp) rs.getObject(7)+" "+
                            (int) rs.getObject(8);  

                data.add(d);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
            System.out.println("Data convertion error... this should not happen");
        }
        return data;
    }    
    

}

    
