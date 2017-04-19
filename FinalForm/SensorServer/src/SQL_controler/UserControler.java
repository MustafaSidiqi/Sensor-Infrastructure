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
public class UserControler {
    
    private String std_dbname = "jdbc:mysql://localhost/";
    private String std_uname = "root";
    private String std_password = "";
    private String UserDB = "UserDB";
    private Connection con_UserDB;
    
    public UserControler(){
        try{
            con_UserDB = DriverManager.getConnection(std_dbname+UserDB, std_uname, std_password);
            System.out.println("Connected to User Database");
               
            Statement stmt_exp_data;
            
            String sql = "CREATE TABLE IF NOT EXISTS `"+UserDB+"` ("
                    + "`UserID` int(11) NOT NULL AUTO_INCREMENT,"
                    + "`UserName` text NOT NULL,"
                    + "`Password` text NOT NULL,"
                    + "`Email` text NOT NULL,"
                    + "`Name` text NOT NULL,"
                    + "`Status` text NOT NULL,"
                    + "`Creation_Date` timestamp NOT NULL,"
                    + " PRIMARY KEY (`UserID`)"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10";
                       
            stmt_exp_data = con_UserDB.createStatement();             
            stmt_exp_data.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new IllegalStateException("Cannot connect the User database!" + ex.getMessage());
        }
    }
}
