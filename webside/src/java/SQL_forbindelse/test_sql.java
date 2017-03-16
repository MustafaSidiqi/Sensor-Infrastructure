/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_forbindelse;

import static StartLoadSer.readSer.readHash;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author taras
 */
public class test_sql {

    public static void main(String[] args) throws MalformedURLException {
        ArrayList<DataStruct> data;

        DB test;
        try {
            test = new DB("jdbc:mysql://sensordb.cfdquak6nbpb.eu-west-2.rds.amazonaws.com:3306/SensorDB", "sensorDatabase", "sensor2017", readHash());
            //test = new DB("jdbc:mysql://localhost:3306/sensor_test","root","");


            data = test.getAllBySensorID(1);
            for (DataStruct d : data) {
                System.out.println(d.objToString());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
