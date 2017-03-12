
package newpackage;

import java.util.ArrayList;

public interface SensorGatherI extends java.rmi.Remote {
    
    void storeData(Integer x) throws java.rmi.RemoteException;
    
    int getDataAmount() throws java.rmi.RemoteException;

    ArrayList<Integer> getSensorData() throws java.rmi.RemoteException;

    void clearDataArray() throws java.rmi.RemoteException;
    
    String getUsername() throws java.rmi.RemoteException;
    
    String getPassword() throws java.rmi.RemoteException;
        
    String getID() throws java.rmi.RemoteException;
    
    String getType() throws java.rmi.RemoteException;
    
    String getDataType() throws java.rmi.RemoteException;
    
    String getUnit() throws java.rmi.RemoteException;
    
    String getName() throws java.rmi.RemoteException;
    
    void setLogin(String brugernavn, String password) throws java.rmi.RemoteException;
}
