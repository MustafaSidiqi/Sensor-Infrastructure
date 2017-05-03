/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_controler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nb
 */
public class WebCommunication extends UnicastRemoteObject implements sql_interface {

    DataControl serverObject;

    public WebCommunication() throws RemoteException {
        try {
            this.serverObject = new DataControl("DataBase");
        } catch (SQLException ex) {
            Logger.getLogger(WebCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<String> CallgetAllBySensorID(int ID) throws RemoteException {
        return serverObject.getAllBySensorID(ID);
    }

    @Override
    public ArrayList<String> CallgetIntervalBySensorID(int ID, Date start, Date end) throws RemoteException {
        return serverObject.getIntervalBySensorID(ID, start, end);

    }

    @Override
    public ArrayList<String> CallgetAllByType(int type) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetIntervalByType(int type, Date start, Date end) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetAllByLocation(String loc) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetIntervalByLocation(String loc, Date start, Date end) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetAllByDate(Date d) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetIntervalByDate(Date start, Date end) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CalldirectSQL(String sql) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> CallgetData(String s) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SelectDatabase(String name) throws RemoteException {
        try {
            this.serverObject = new DataControl(name);
        } catch (SQLException ex) {
            Logger.getLogger(WebCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }    }

}
