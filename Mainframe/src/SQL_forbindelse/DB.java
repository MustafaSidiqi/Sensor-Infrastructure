/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import StartLoadSer.EnumSerialize;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 *
 * used to connect to sql server and manupulate data.
 */
public class DB {

    private String std_dbname = "jdbc:mysql://sensordb.cfdquak6nbpb.eu-west-2.rds.amazonaws.com:3306/SensorDB";
    private String std_uname = "sensorDatabase";
    private String std_password = "sensor2017";
    private Connection con;
    private String DBName = "SensorDB";
    SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private EnumSerialize enum_db;
    
    /**
     * 
     * @param es Serializeble object to data translation
     * @throws java.rmi.RemoteException 
     * 
     * This function connects to database.
     * If there is no data then it will create a new table for data
     */
    public DB(EnumSerialize es) throws java.rmi.RemoteException {
        enum_db = es;
        try {
            con = DriverManager.getConnection(std_dbname, std_uname, std_password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!" + e.getMessage());
        }
        makeDB();
    }

    /**
     *
     * @param dbname
     * @param uname
     * @param password
     * @throws Exception
     *
     * This wil connect to db that you choose will create new Table if the table
     * doesn't exist.
     */
    public DB(String dbname, String uname, String password,EnumSerialize es) throws java.rmi.RemoteException{
        enum_db = es;
        try {
            con = DriverManager.getConnection(dbname, uname, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!" + e.getMessage());
        }
        makeDB();
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
    public void insertData(int SensID, String loc, int type, int unit, float value, String s, int chsm) {
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `" + DBName + "`.`sensordata` "
                    + "(`Data_ID`, `Sensor_ID`, `Location`, `Type`, `Unit`, `Value`, `Date`, `Checksum`) VALUES "
                    + "(NULL, '" + SensID + "', '" + loc + "', '" + type + "', '" + unit + "', '" + value + "', '" + s + "', '" + chsm + "');";
            stmt.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param ID
     * @return array with SensorData object that are requested by ID
     */
    public ArrayList<DataStruct> getAllBySensorID(int ID){

        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = " + ID;
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
    public ArrayList<DataStruct> getIntervalBySensorID(int ID, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = " + ID + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param type
     * @return ArrayList<DataStruct> by Sensor Data type
     */
    public ArrayList<DataStruct> getAllByType(int type){

        String req = "SELECT * FROM `sensordata` WHERE `Type` = " + type;
        return getData(req);
    }
    /**
     * 
     * @param type
     * @param start
     * @param end
     * @return ArrayList<DataStruct> by Sensor Data type and date intervall
     */
    public ArrayList<DataStruct> getIntervalByType(int type, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Type` = " + type + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param loc
     * @return ArrayList<DataStruct>  by sensor location 
     */
    public ArrayList<DataStruct> getAllByLocation(String loc){

        String req = "SELECT * FROM `sensordata` WHERE `Location` = " + loc;
        return getData(req);
    }
    
    /**
     * 
     * @param loc
     * @param start
     * @param end
     * @return ArrayList<DataStruct>  by sensor location and date intervall 
     */
    public ArrayList<DataStruct> getIntervalByLocation(String loc, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Location` = " + loc + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param d
     * @return ArrayList<DataStruct> by date 
     */
    public ArrayList<DataStruct> getAllByDate(Date d){

        String req = "SELECT * FROM `sensordata` WHERE `Date` = " + d;
        return getData(req);
    }
    
    /**
     * 
     * @param start
     * @param end
     * @return ArrayList<DataStruct>  by date intervall 
     */
    public ArrayList<DataStruct> getIntervalByDate(Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Date` >= '" + start + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return getData(req);
    }
    
    /**
     * 
     * @param sql here you can write direct SQL command 
     * @return ArrayList<DataStruct> 
     */
    public ArrayList<DataStruct> directSQL(String sql){

        // securing for abuse
        String temp_sql = sql.toLowerCase();
        if (!temp_sql.contains("update") && !temp_sql.contains("delete") && !temp_sql.contains("insert") && !temp_sql.contains("create") && !temp_sql.contains("alter")) {
            return getData(sql);
        } else {
            return null;
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Create a table on the server
     */
    private void makeDB() {
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS `sensordata` ("
                    + "`Data_ID` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`Sensor_ID` int(11) NOT NULL,"
                    + "`Location` text NOT NULL,"
                    + "`Type` int(11) NOT NULL,"
                    + "`Unit` int(11) NOT NULL,"
                    + "`Value` float(11) NOT NULL,"
                    + "`Date` timestamp NOT NULL,"
                    + "`Checksum` int(11) NOT NULL,"
                    + " PRIMARY KEY (`Data_ID`)"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * 
     * @param s
     * @return ArrayList<DataStruct>
     * 
     * This Executes sql command given by prev functions
     */
    private ArrayList<DataStruct> getData(String s) {
        ArrayList<DataStruct> data = new ArrayList<DataStruct>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(s);            
            while (rs.next()) {
                DataStruct d = new DataStruct();
                d.setSD(rs,enum_db);
                data.add(d);

                // test function....
                //d.printData();
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }    
     
    /**
     * 
     * @param data 
     * @return  
     * Translates object into string 
     */
    public ArrayList<String> DataStructToString(ArrayList<DataStruct> data) {
        ArrayList<String> temp = new ArrayList<>();
        for(DataStruct d: data){
            temp.add(d.objToString());
        }
        return temp;
    }
    
    /* // this will delete the db (there is an error asck taras if you want to delete db)
    void drop() {
        
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql = "DROP TABLE `this.sensordata´" ;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }*/

}
