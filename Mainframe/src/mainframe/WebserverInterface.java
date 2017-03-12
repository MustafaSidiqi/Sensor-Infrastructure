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
    public String setUsername() throws RemoteException;
    public String setPassword() throws RemoteException;
    
}
