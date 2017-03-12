/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import javax.xml.ws.Endpoint;

/**
 *
 * @author triblex
 */
public class loginServerJavabog {

    public static void main(String[] args) throws Exception {
        UserAuthenticationInterface g = new SecurityBureau();
        Endpoint.publish("http://[::]:9901/kontotjeneste", g);
        System.out.println("UserloginServer initialiseret.");
    }
}
