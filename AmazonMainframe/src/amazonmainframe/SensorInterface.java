/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonmainframe;

/**
 *
 * @author nb
 */
public interface SensorInterface extends java.rmi.Remote {
    
        boolean transferData(String username, String password, String data) throws java.rmi.RemoteException;
    
}