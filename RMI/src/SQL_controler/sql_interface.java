/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_controler;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author taras
 */
public interface sql_interface extends java.rmi.Remote {

    void SelectDatabase(String name)                                              throws java.rmi.RemoteException;
    ArrayList<String> CallgetAllBySensorID(int ID)                                  throws java.rmi.RemoteException;
    ArrayList<String> CallgetIntervalBySensorID(int ID, Date start, Date end)       throws java.rmi.RemoteException;
    ArrayList<String> CallgetAllByType(int type)                                    throws java.rmi.RemoteException;
    ArrayList<String> CallgetIntervalByType(int type, Date start, Date end)         throws java.rmi.RemoteException;
    ArrayList<String> CallgetAllByLocation(String loc)                              throws java.rmi.RemoteException;
    ArrayList<String> CallgetIntervalByLocation(String loc, Date start, Date end)   throws java.rmi.RemoteException;
    ArrayList<String> CallgetAllByDate(Date d)                                      throws java.rmi.RemoteException;
    ArrayList<String> CallgetIntervalByDate(Date start, Date end)                   throws java.rmi.RemoteException;
    ArrayList<String> CalldirectSQL(String sql)                                     throws java.rmi.RemoteException;
    ArrayList<String> CallgetData(String s)                                         throws java.rmi.RemoteException;

}
