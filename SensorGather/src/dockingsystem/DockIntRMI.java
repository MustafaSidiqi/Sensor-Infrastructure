/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.security.NoSuchAlgorithmException;
import javax.crypto.SecretKey;

/**
 *
 * @author nb
 */
public interface DockIntRMI extends java.rmi.Remote {

    public boolean transferDataRMI(String eUsername, String ePassword, String eData, int count) throws java.rmi.RemoteException, Exception;

    public boolean requestConnection() throws java.rmi.RemoteException;

    public String getNonsense() throws java.rmi.RemoteException;

    public String getPublicKey() throws java.rmi.RemoteException;

    public void sendCipherInonsense(String encryptedMessage) throws java.rmi.RemoteException;

    public void sendLogHashCipher(String hashLog) throws java.rmi.RemoteException;

    public boolean recieveOK() throws NoSuchAlgorithmException, java.rmi.RemoteException;

}