/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class helloWorldPub{

	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9998/ws/hello", new helloWorldImpl());
    }

}