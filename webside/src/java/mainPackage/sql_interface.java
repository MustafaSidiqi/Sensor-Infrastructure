/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;


import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author taras
 */
public interface sql_interface extends java.rmi.Remote{
    
    ArrayList<String> getAllBySensorID_RMI(int ID)                                  throws java.rmi.RemoteException;
    ArrayList<String> getIntervalBySensorID_RMI(int ID, Date start, Date end)       throws java.rmi.RemoteException;
    ArrayList<String> getAllByType_RMI(int type)                                    throws java.rmi.RemoteException;
    ArrayList<String> getIntervalByType_RMI(int type, Date start, Date end)         throws java.rmi.RemoteException;
    ArrayList<String> getAllByLocation_RMI(String loc)                              throws java.rmi.RemoteException;
    ArrayList<String> getIntervalByLocation_RMI(String loc, Date start, Date end)   throws java.rmi.RemoteException;
    ArrayList<String> getAllByDate_RMI(Date d)                                      throws java.rmi.RemoteException;
    ArrayList<String> getIntervalByDate_RMI(Date start, Date end)                   throws java.rmi.RemoteException;
    ArrayList<String> directSQL_RMI(String sql)                                     throws java.rmi.RemoteException;
}
