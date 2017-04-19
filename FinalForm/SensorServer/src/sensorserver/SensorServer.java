/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import SQL_controler.DataControler;
import SQL_controler.ExpDataControler;
import SQL_controler.SensorControler;
import SQL_controler.UserControler;

/**
 *
 * @author taras
 */
public class SensorServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataControler d = new DataControler();
        ExpDataControler k = new ExpDataControler();
        SensorControler s = new SensorControler();
        UserControler u = new UserControler();
    }
    
}
