/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "server.helloWorld")
public class helloWorldImpl implements helloWorld{

	@Override
	
        public String getHelloWorldAsString(String name) {

            return "Hello World JAX-WS " + name;
	}

}