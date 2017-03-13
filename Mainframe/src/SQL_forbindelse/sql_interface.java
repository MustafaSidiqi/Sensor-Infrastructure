/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import StartLoadSer.EnumSerialize;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public interface sql_interface {
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
