/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

/**
 *
 * @author nb
 */
public interface DockIntRMI extends java.rmi.Remote {
    
    boolean transferDataRMI(String username, String password, String data) throws java.rmi.RemoteException;
    
    boolean handshakeRMI() throws java.rmi.RemoteException;
    
}