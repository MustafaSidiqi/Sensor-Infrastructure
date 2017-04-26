/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapSensorClient;

import server.helloWorld;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import soapSensorServer.soapSensorFunctions;
import soapSensorServer.soapSensorInterface;

/**
 *
 * @author nb
 */
public class sensor {
    
    public static void main(String[] args) throws Exception {
        
        URL url = new URL("http://localhost:9999/ws/sensor?wsdl");
                
        QName qname = new QName("http://soapSensorServer/", "soapSensorFunctionsService");

        Service service = Service.create(url, qname);

        soapSensorInterface sensorServer = service.getPort(soapSensorInterface.class);

        System.out.println(sensorServer.postData("Username Password and Data Object"));

    }
    
}
