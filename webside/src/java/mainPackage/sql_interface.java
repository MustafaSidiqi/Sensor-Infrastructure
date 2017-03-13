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
    public ArrayList<DataStruct> getAllBySensorID(int ID) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getIntervalBySensorID(int ID, Date start, Date end) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getAllByType(int type) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getIntervalByType(int type, Date start, Date end) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getAllByLocation(String loc) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getIntervalByLocation(String loc, Date start, Date end) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getAllByDate(Date d) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> getIntervalByDate(Date start, Date end) throws java.rmi.RemoteException;
    public ArrayList<DataStruct> directSQL(String sql) throws java.rmi.RemoteException;
}
