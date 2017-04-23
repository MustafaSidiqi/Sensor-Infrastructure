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
public class SensorControler {
    private String std_dbname = "jdbc:mysql://ubuntu4.javabog.dk:53067/";
    private String std_uname = "kamael2015";
    private String std_password = "simplePas";
    private String SensorDB = "SensorDB";
    private Connection con_sensor;
    
    public SensorControler(){
        try{
            con_sensor = DriverManager.getConnection(std_dbname+SensorDB, std_uname, std_password);
            System.out.println("Connected to Sensor Database");
               
            Statement stmt_exp_data;
            
            String sql = "CREATE TABLE IF NOT EXISTS `"+SensorDB+"` ("
                    + "`Sensor_ID` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`Name` text NOT NULL,"
                    + "`Location` text NOT NULL,"
                    + "`Unit` int(11) NOT NULL,"
                    + "`Owner` int(11) NOT NULL,"
                    + "`SetupTime` timestamp NOT NULL,"
                    + "`Status` int(11) NOT NULL,"
                    + "`DB_Status` int(11) NOT NULL,"
                    + "`Token` text NOT NULL,"
                    + " PRIMARY KEY (`Sensor_ID`)"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1";
                       
            stmt_exp_data = con_sensor.createStatement();             
            stmt_exp_data.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot connect the Sensor database!" + ex.getMessage());
        }
    }
}
