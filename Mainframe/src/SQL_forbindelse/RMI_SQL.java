/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import StartLoadSer.EnumSerialize;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class RMI_SQL extends UnicastRemoteObject implements sql_interface{
        DB db;
        public RMI_SQL(EnumSerialize e)throws java.rmi.RemoteException {
            try {    
                db = new DB(e);
            } catch (RemoteException ex) {
                Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @Override
    public ArrayList<String> getAllBySensorID_RMI(int ID){

        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = " + ID;
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getIntervalBySensorID_RMI(int ID, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Sensor_ID` = " + ID + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getAllByType_RMI(int type){

        String req = "SELECT * FROM `sensordata` WHERE `Type` = " + type;
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getIntervalByType_RMI(int type, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Type` = " + type + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getAllByLocation_RMI(String loc){

        String req = "SELECT * FROM `sensordata` WHERE `Location` = " + loc;
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getIntervalByLocation_RMI(String loc, Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Location` = " + loc + " and `Date` >= '" + start.toString() + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getAllByDate_RMI(Date d){

        String req = "SELECT * FROM `sensordata` WHERE `Date` = " + d;
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> getIntervalByDate_RMI(Date start, Date end){

        String req = "SELECT * FROM `sensordata` WHERE `Date` >= '" + start + " 00:00:00' and `Date` <= '" + end + " 23:59:59'";
        return db.DataStructToString(db.directSQL(req));
    }

    @Override
    public ArrayList<String> directSQL_RMI(String sql){

        // securing for abuse
        String temp_sql = sql.toLowerCase();
        if (!temp_sql.contains("update") && !temp_sql.contains("delete") && !temp_sql.contains("insert") && !temp_sql.contains("create") && !temp_sql.contains("alter")) {
            return db.DataStructToString(db.directSQL(sql));
        } else {
            return null;
        }
    }
    
    
}
