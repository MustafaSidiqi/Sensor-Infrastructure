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
    
    public void cyberLogin(String username, String password) throws RemoteException;
    
//public void setPassword(String password) throws RemoteException;    
}