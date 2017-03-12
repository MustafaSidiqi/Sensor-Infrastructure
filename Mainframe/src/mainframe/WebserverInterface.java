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
public interface WebserverInterface extends java.rmi.Remote {
    
<<<<<<< HEAD
    public boolean cyberLogin(String username, String password) throws RemoteException;
=======
    public boolean cyberLogin(String username, String password) throws java.rmi.RemoteException;
>>>>>>> f5bfdc86cd154d16ca2978bee36e17f88faac632
    
    //public void setPassword(String password) throws RemoteException;    

}
