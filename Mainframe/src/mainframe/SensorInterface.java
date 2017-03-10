/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

/**
 *
 * @author nb
 */
public interface SensorInterface extends java.rmi.Remote {
    
    boolean sendData(String username, String password, String data);
    
}
