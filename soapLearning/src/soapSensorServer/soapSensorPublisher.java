/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapSensorServer;

import javax.xml.ws.Endpoint;

/**
 *
 * @author nb
 */
public class soapSensorPublisher {
    
    public static void main(String[] args) {
        
        System.out.println("Initializing Sensor Webservices...");
        
        String http;
        
        http = "http://localhost:9999/ws/sensor";
        
        Endpoint.publish(http, new soapSensorFunctions());
        
        System.out.println(http);
        
        System.out.println("Done!");
    }
    
}