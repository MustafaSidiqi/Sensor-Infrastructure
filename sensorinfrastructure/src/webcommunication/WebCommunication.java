/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcommunication;

import datasystem.DataControl;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.UserInterface;
import securitysystem.UserAuthentication;

/**
 *
 * @author nb
 */
public class WebCommunication extends UnicastRemoteObject implements WebInterface {

    DataControl offdata;
    DataControl expdata;
    UserInterface ui;

    static String localaddress = "rmi://localhost:53168/data";

    static String javabogaddress = "rmi://ubuntu4.javabog.dk:53168/data";

    static boolean online = FALSE;

    public WebCommunication(UserInterface _ui, DataControl _offdata, DataControl _expdata) throws RemoteException {

        System.out.print("Setting up webserver RMI interface... ");

        ui = _ui;
        offdata = _offdata;
        expdata = _expdata;

        online = ui.online;

        try {
            this.expdata = new DataControl("DataBase");
        } catch (SQLException ex) {
            Logger.getLogger(WebCommunication.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Done!");

    }

    public void publish() {

        try {

            System.out.print("Publishing RMI Data interface... ");

            java.rmi.registry.LocateRegistry.createRegistry(53168);

            if (online) {

                Naming.rebind(javabogaddress, (Remote) this);

                System.out.println("Web RMI: " + javabogaddress);

            } else {

                Naming.rebind(localaddress, (Remote) this);

                System.out.println("Web RMI: " + localaddress);

            }

            System.out.println("Succes!");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

    public String getMessage() {
        return "Hello World";
    }

    @Override
    public ArrayList<String> CallgetAllBySensorID(String data, int ID) throws RemoteException {

        System.out.println("CallgetAllBySensorID " + data + " " + ID);

        if (data == "offdata") {
            return offdata.getAllBySensorID(ID);
        } else {
            return expdata.getAllBySensorID(ID);
        }

    }

    @Override
    public ArrayList<String> CallgetIntervalBySensorID(String data, int ID, Date start, Date end) throws RemoteException {

        System.out.println("CallgetIntervalBySensorID " + data + " " + ID + " " + start + " " + end);

        if (data == "offdata") {
            return offdata.getIntervalBySensorID(ID, start, end);
        } else {
            return expdata.getIntervalBySensorID(ID, start, end);
        }

    }

    public boolean CallLogin(String username, String password) throws RemoteException {
        UserAuthentication ua = new UserAuthentication();

        return ua.login(username, password);
    }

    /*

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

     */
}
