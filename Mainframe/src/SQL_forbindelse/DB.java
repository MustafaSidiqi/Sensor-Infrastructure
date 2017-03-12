/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
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
    private ArrayList<SensorData> data; 

    public DB() throws Exception {

        try {
            con = DriverManager.getConnection(std_dbname, std_uname, std_password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!" + e.getMessage());
        }
        makeDB();
        data = new ArrayList<SensorData>();
    }
    
        /**
     * 
     * @param dbname
     * @param uname
     * @param password
     * @throws Exception 
     * 
     * This wil connect to db that you choose 
     * will create new Table if the table doesn't exist. 
     */
    public DB(String dbname, String uname, String password) throws Exception {

        try {
            con = DriverManager.getConnection(dbname, uname, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!" + e.getMessage());
        }
        makeDB();
        data = new ArrayList<SensorData>();
    }
    
    /**
     * 
     * @param SensID  - What sensor is writing 
     * @param loc     - location of the server  
     * @param type    - type of the sensor
     * @param unit    - unit of data 
     * @param value   - value of the data 
     * @param d       - date 
     * @param chsm    - check sum
     * inserts data into the table
     */
    public void insertData(int SensID,String loc,int type, int unit,float value, Timestamp d, int chsm){
        try {
           Statement stmt = con.createStatement();
           String s = simpleDF.format(d);
           String sql =    "INSERT INTO `"+DBName+"`.`sensordata` "
                + "(`Data_ID`, `Sensor_ID`, `Location`, `Type`, `Unit`, `Value`, `Date`, `Checksum`) VALUES "
                + "(NULL, '"+SensID+"', '"+loc+"', '"+type+"', '"+unit+"', '"+value+"', '"+s+"', '"+chsm+"');";
           stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * 
     * @param ID
     * @return array with SensorData object.
     */
    public ArrayList<SensorData> getAllBySensorID(int ID){
        
        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = "+ID;        
        return getData(req);
    }
    
    public ArrayList<SensorData> getIntervalBySensorID(int ID, Date start, Date end){
        
        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = "+ID+" and `Date` >= '"+start.toString()+ " 00:00:00' and `Date` <= '"+end+ " 23:59:59'" ;        
        return getData(req);        
    }
    
    public ArrayList<SensorData> getAllByType(int type){
        
        String req = "SELECT * FROM `sensordata` WHERE `Type` = "+type;        
        return getData(req);
    }
    
    public ArrayList<SensorData> getIntervalByType(int type, Date start, Date end){
        
        String req = "SELECT * FROM `sensordata` WHERE `Type` = "+type+" and `Date` >= '"+start.toString()+ " 00:00:00' and `Date` <= '"+end+ " 23:59:59'" ;        
        return getData(req);        
    }
    
    public ArrayList<SensorData> getAllByLocation(String loc){
        
        String req = "SELECT * FROM `sensordata` WHERE `Location` = "+loc;        
        return getData(req);
    }
    
    public ArrayList<SensorData> getIntervalByLocation(String loc, Date start, Date end){
        
        String req = "SELECT * FROM `sensordata` WHERE `Location` = "+loc+" and `Date` >= '"+start.toString()+ " 00:00:00' and `Date` <= '"+end+ " 23:59:59'" ;        
        return getData(req);        
    }
    
        public ArrayList<SensorData> getAllByDate(Date d){
        
        String req = "SELECT * FROM `sensordata` WHERE `Date` = "+d;        
        return getData(req);
    }
    
    public ArrayList<SensorData> getIntervalByDate(Date start, Date end){
        
        String req = "SELECT * FROM `sensordata` WHERE `Date` >= '"+start+ " 00:00:00' and `Date` <= '"+end+ " 23:59:59'" ;        
        return getData(req);        
    }    
    
    public ArrayList<SensorData> directSQL(String sql){
        
        // securing for abuse
        String temp_sql = sql.toLowerCase();
        if(!temp_sql.contains("update") && !temp_sql.contains("delete") && !temp_sql.contains("insert") && !temp_sql.contains("create") && !temp_sql.contains("alter")){
            return getData(sql);
        }
        else{
            return null;
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Create a table the server
     */
    private void makeDB() {
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql =    "CREATE TABLE IF NOT EXISTS `sensordata` ("+
                            "`Data_ID` int(11) NOT NULL AUTO_INCREMENT,"+
                            "`Sensor_ID` int(11) NOT NULL,"+
                            "`Location` text NOT NULL,"+
                            "`Type` int(11) NOT NULL,"+
                            "`Unit` int(11) NOT NULL,"+
                            "`Value` float(11) NOT NULL,"+
                            "`Date` timestamp NOT NULL,"+
                            "`Checksum` int(11) NOT NULL,"+
                            " PRIMARY KEY (`Data_ID`)"+
                            ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10" ;
            

            stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    public ArrayList<SensorData> getData(String s){
        try {
           Statement stmt = con.createStatement();            
           ResultSet rs = null;
           rs = stmt.executeQuery(s);
                while (rs.next()) {
                    SensorData d = new SensorData();
                    d.setSD(rs);
                    data.add(d);
                    
                    // test function....
                    d.printData();
                }
                rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }

}
