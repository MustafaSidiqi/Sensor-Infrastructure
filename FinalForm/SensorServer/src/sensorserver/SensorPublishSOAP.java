/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author nb
 */
public class SensorPublishSOAP {
    
    static String http = "http://0.0.0.0:5735/sensorSOAPapi";
    
        public static void publish(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello World!");
        System.out.println("Docker Learning");
        System.out.println(http);
        
        Endpoint.publish(http, new SensorImplSOAP());
        
        System.out.println("WSDL Generated.");
    }
    
}