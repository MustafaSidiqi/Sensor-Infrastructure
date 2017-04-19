/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorserver;

import java.net.MalformedURLException;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author MSC
 */
@WebService
public interface UserAuthenticationInterface {
        @WebMethod boolean login(String name, String pass);
        //@WebMethod boolean instantiateLogin() throws MalformedURLException;
        //@WebMethod void nulstil();
        //@WebMethod String log();
}
