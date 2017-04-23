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
public class DataControler extends Sql_functions {
    private String std_dbname = "jdbc:mysql://ubuntu4.javabog.dk:53067/Data";
    private String SensorData = "SensorData";
    private String std_uname = "root";
    private String std_password = "sensorDB";
    private Connection con_Data;
    
    /**
     * 
     */
    public DataControler(){
        try {
            con_Data = DriverManager.getConnection(std_dbname, std_uname, std_password);
            System.out.println("Connected to SensorData Database");

            
            Statement stmt_data;
            
            String sql = "CREATE TABLE IF NOT EXISTS `"+SensorData+"` ("
                    + "`Data_ID` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`Sensor_ID` int(11) NOT NULL,"
                    + "`Location` text NOT NULL,"
                    + "`Type` text NOT NULL,"
                    + "`Unit` text NOT NULL,"
                    + "`Value` float(11) NOT NULL,"
                    + "`Date` timestamp NOT NULL,"
                    + "`Checksum` int(11) NOT NULL,"
                    + " PRIMARY KEY (`Data_ID`)"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1";
            
            stmt_data = con_Data.createStatement();
            stmt_data.executeUpdate(sql);
            
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot connect the database!" + ex.getMessage());
        }
        
        super.Sql_setup(std_dbname, con_Data);
    }
}
