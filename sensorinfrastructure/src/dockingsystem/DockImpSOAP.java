/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import javax.jws.WebService;
import sensorsystem.SensorSystem;

@WebService(endpointInterface = "dockingsystem.DockIntSOAP")

public class DockImpSOAP implements DockIntSOAP {

    private final SensorSystem sensorsystem;

    DockImpSOAP(SensorSystem _sensorsystem) {
       sensorsystem = _sensorsystem;
    }
    
    @Override
    public boolean transferDataSOAP(String username, String password, String data) {
        
        return sensorsystem.transferData(username, password, data);
    }
    
    @Override
    public boolean handshakeSOAP() {
        // return Main.sensor.handshake();        
        return sensorsystem.handshake();
    
    }
    
}