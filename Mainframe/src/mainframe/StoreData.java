/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taras
 */
public class StoreData implements Runnable {

    private DataManipulationService saveData;
    private final Object lock = new Object();

    StoreData(DataManipulationService SendData) {
        saveData = SendData;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    saveData.storeData();
                }
            } catch (Exception ex) {
                System.out.println("Error Data format" + ex.getStackTrace());
            }
        }
    }

}
