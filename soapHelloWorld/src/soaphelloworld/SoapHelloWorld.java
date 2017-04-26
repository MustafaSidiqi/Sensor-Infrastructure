/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soaphelloworld;

import javax.xml.ws.Endpoint;

/**
 *c
 * @author nb
 */
public class SoapHelloWorld {
    
    static String http = "http://ubuntu4.javabog.dk:5735/hello";
    //static String http = "http://0.0.0.0:5735/hello";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello World!");
        System.out.println("Docker Learning");
        System.out.println(http);
        
        Endpoint.publish(http, new helloWorldImpl());
        
        System.out.println("WSDL Generated.");
    }
    
}
