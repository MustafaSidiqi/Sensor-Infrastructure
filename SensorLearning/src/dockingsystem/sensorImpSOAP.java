/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import javax.jws.WebService;
import sensorsystem.SensorSystem;

@WebService(endpointInterface = "dockingsystem.sensorIntSOAP")
public class sensorImpSOAP implements sensorIntSOAP {
    
    @Override
    public boolean transferDataSOAP(String data) {
        
        return SensorSystem.transferData(data);
    }
    
    @Override
    public boolean handshakeSOAP() {
        
        return SensorSystem.handshake();
    }
    
}