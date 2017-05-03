/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import sensorsystem.SensorSystem;

public class DockImpRMI extends UnicastRemoteObject implements DockIntRMI {

    SensorSystem sensorsystem;

    public DockImpRMI(SensorSystem _sensorsystem) throws java.rmi.RemoteException {

        sensorsystem = _sensorsystem;

    }

    @Override
    public boolean transferDataRMI(String eUsername, String ePassword, String eData, int count) throws java.rmi.RemoteException, Exception {

        return sensorsystem.transferData(eUsername, ePassword, eData, count);
    }

    @Override
    public boolean requestConnection() throws java.rmi.RemoteException {
        return sensorsystem.requestConnection();
    }

    @Override
    public String getNonsense() throws java.rmi.RemoteException {
        return sensorsystem.getNonsense();
    }

    @Override
    public String getPublicKey() throws java.rmi.RemoteException {
        return sensorsystem.getPublicKey();
    }

    @Override
    public void sendCipherInonsense(byte[] encryptedMessage) throws java.rmi.RemoteException {
        sensorsystem.sendCipherInonsense(encryptedMessage);
    }

    @Override
    public void sendLogHashCipher(byte[] hashLog) throws java.rmi.RemoteException {
        sensorsystem.sendLogHashCipher(hashLog);
    }

    @Override
    public boolean recieveOK() throws NoSuchAlgorithmException, java.rmi.RemoteException {
        return sensorsystem.recieveOK();
    }
}
