/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dockingsystem;

import javax.xml.ws.Endpoint;

public class sensorPubSOAP {
    
    //static String http = "http://ubuntu4.javabog.dk:5735/hello"; // Javabog.dk
    static String http = "http://localhost:7777/ws/sensor"; // Localhost
    
    public void publish() {
        
        System.out.println("Setting up SOAP API WSDL @:");
        System.out.println(http);
        
        Endpoint.publish(http, new sensorImpSOAP());
        
        System.out.println("WSDL Generated.");
    }
    
}
