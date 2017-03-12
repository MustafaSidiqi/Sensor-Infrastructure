
package sensorGather;

import java.util.ArrayList;

public interface SensorGatherI extends java.rmi.Remote {
    
    void storeData(Integer x) throws java.rmi.RemoteException;
    
    int getDataAmount(ArrayList<Integer> sensorData) throws java.rmi.RemoteException;

    ArrayList<Integer> getSensorData() throws java.rmi.RemoteException;

    //boolean hentBruger(String brugernavn, String password) throws java.rmi.RemoteException;

    void clearDataArray() throws java.rmi.RemoteException;
    
    loginData getLogin() throws java.rmi.RemoteException;
    
    void setLogin(String brugernavn, String password) throws java.rmi.RemoteException;
}
