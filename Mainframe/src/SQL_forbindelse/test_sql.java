/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import static StartLoadSer.readSer.readHash;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.sql.Date;

/**
 *
 * @author taras
 */
public class test_sql {
    
    public static void main(String[] args) throws RemoteException, MalformedURLException{
    
        java.rmi.registry.LocateRegistry.createRegistry(53067); // start i server-JVM
        
        sql_interface k = new RMI_SQL(readHash());
        System.setProperty("java.rmi.server.hostname", "javabog.dk");
	Naming.rebind("rmi://javabog.dk:53067/kontotjeneste", k);
    }
    
}
