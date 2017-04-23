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
public class ExpDataControler extends Sql_functions{
    private String std_dbname = "jdbc:mysql://localhost/";
    private String std_uname = "root";
    private String std_password = "";/**/
    /*
    private String std_dbname = "jdbc:mysql://ubuntu4.javabog.dk:53067/";
    private String std_uname = "kamael2015";
    private String std_password = "simplePas";/**/
    private String ExpSensorData = "expsensordata";
    private Connection con_Exp_Data;
    
    public ExpDataControler(){
        try{
            con_Exp_Data = DriverManager.getConnection(std_dbname+ExpSensorData, std_uname, std_password);
            System.out.println("Connected to ExpSensorData Database");
               
            Statement stmt_exp_data;
            
            String sql = "CREATE TABLE IF NOT EXISTS `"+ExpSensorData+"` ("
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
                       
            stmt_exp_data = con_Exp_Data.createStatement();             
            stmt_exp_data.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot connect the database!" + ex.getMessage());
        }
        super.Sql_setup(ExpSensorData, con_Exp_Data);
    }
}
