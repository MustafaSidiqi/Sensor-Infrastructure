/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapclientlearning;

import soaphelloworld.*;
//import server.helloWorld;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClientLearning{

	public static void main(String[] args) throws Exception {

	URL url = new URL("http://ubuntu4.javabog.dk:5735/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soaphelloworld/", "helloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("Niklas"));

    }

}
