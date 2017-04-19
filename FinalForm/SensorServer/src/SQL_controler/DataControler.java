/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author taras
 */
public class DataControler {
    private String std_dbname = "jdbc:mysql://localhost/";
    private String SensorData = "sensordata";
    private String ExpSensorData = "expsensordata";
    private String std_uname = "root";
    private String std_password = "";
    private Connection con_Data;
    private Connection con_Exp_Data;
    
    /**
     * 
     */
    public DataControler(){
        try {
            con_Data = DriverManager.getConnection(std_dbname+SensorData, std_uname, std_password);
            System.out.println("Connected to SensorData Database");
            con_Exp_Data = DriverManager.getConnection(std_dbname+ExpSensorData, std_uname, std_password);
            System.out.println("Connected to ExpSensorData Database");
            
            Statement stmt_data;
            Statement stmt_exp_data;
            
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
            
            stmt_data = con_Data.createStatement();
            stmt_data.executeUpdate(sql);
            
            stmt_exp_data = con_Exp_Data.createStatement();             
            stmt_exp_data.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot connect the database!" + ex.getMessage());
        }
        
        
    }
}
