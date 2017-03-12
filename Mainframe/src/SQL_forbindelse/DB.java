/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class DB {

    private Connection con;
    private String DBName = "sensor_test";
    SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DB(String dbname, String uname, String password) throws Exception {

        try {
            con = DriverManager.getConnection(dbname, uname, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!" + e.getMessage());
        }
        makeDB();

    }

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    private void makeDB() {
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql =    "CREATE TABLE IF NOT EXISTS `SensorData` ("+
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
}
