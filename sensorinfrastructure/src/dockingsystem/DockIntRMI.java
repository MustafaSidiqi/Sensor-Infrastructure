/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nb
 */
public interface DockIntRMI extends java.rmi.Remote {

    boolean transferDataRMI(String username, String password, String data) throws java.rmi.RemoteException;

    public boolean requestConnection() throws java.rmi.RemoteException;

    public String getNonsense() throws java.rmi.RemoteException;

    public String getPublicKey() throws java.rmi.RemoteException;

    public void sendCipherInonsense(byte[] encryptedMessage) throws java.rmi.RemoteException;

    public void sendLogHashCipher(byte[] hashLog) throws java.rmi.RemoteException;

    public boolean recieveOK() throws NoSuchAlgorithmException, java.rmi.RemoteException;

}
