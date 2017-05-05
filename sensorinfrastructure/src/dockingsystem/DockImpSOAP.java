/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import sensorsystem.SensorSystem;

@WebService(endpointInterface = "dockingsystem.DockIntSOAP")

public class DockImpSOAP implements DockIntSOAP {

    private final SensorSystem sensorsystem;

    DockImpSOAP(SensorSystem _sensorsystem) {
       sensorsystem = _sensorsystem;
    }
    
    @Override
    public boolean transferDataSOAP(String username, String password, String data, int count) {
        
        try {
            return sensorsystem.transferData(username, password, data, count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    return false;
    }
    
    @Override
    public boolean requestConnectionSOAP() {
        
        return sensorsystem.requestConnection();
    
    }
    
    @Override
    public String getNonsenseSOAP() {
        
        return sensorsystem.getNonsense();
    
    }
    
    @Override
    public String getPublicKeySOAP() throws NoSuchAlgorithmException {
        
        return sensorsystem.getPublicKey();
    
    }
    
    @Override
    public void sendCipherInonsenseSOAP(String encryptedMessage) {
        
        sensorsystem.sendCipherInonsense(encryptedMessage);
        
    }
    
    @Override
    public void sendLogHashCipherSOAP(String hashLog) {
        
        sensorsystem.sendLogHashCipher(hashLog);
        
    }
    
    @Override
    public boolean recieveOKSOAP() throws NoSuchAlgorithmException {
        
        return sensorsystem.recieveOK();
        
    }
}