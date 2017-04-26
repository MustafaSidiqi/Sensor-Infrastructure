/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapSensorServer;

import javax.jws.WebService;

@WebService(endpointInterface = "soapSensorServer.soapSensorInterface")
public class soapSensorFunctions implements soapSensorInterface {
    
    @Override
    public int postData(String data) {
        
        System.out.println(data);
        
        return 1;
        
    }
    
}



