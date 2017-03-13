/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_RMI;

import SQL_forbindelse.DB;
import StartLoadSer.EnumSerialize;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class rmi_SQL_server extends UnicastRemoteObject implements RMI_sql{
    DB sql_DB;
    public rmi_SQL_server(EnumSerialize enm) throws java.rmi.RemoteException{
        try {      
            sql_DB = new DB(enm);
        } catch (Exception ex) {
            Logger.getLogger(rmi_SQL_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
