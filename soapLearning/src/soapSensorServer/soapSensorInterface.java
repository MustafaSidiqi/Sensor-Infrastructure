/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapSensorServer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author nb
 */

@SOAPBinding(style = SOAPBinding.Style.RPC)

@WebService
public interface soapSensorInterface {
    
    @WebMethod int postData(String data);
    
}