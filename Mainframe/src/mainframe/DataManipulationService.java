/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import java.rmi.RemoteException;

/**
 *
 * @author nb
 */
public class DataManipulationService {
    
    public SecurityBureau cia;
    
    // Upload Data
    
    // Request Data
    SensorCommandCenter nsa;
    CyberCommunicationCenter nasa;
    
   public void storeData() throws RemoteException {
       
       String newData ="";
       if(nsa.isThereNewData()) newData = nsa.getData();
       System.out.println(newData);
   }
    
}
