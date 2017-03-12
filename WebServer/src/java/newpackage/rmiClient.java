/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.rmi.Naming;

/**
 *
 * @author Mustafa
 */
public class rmiClient {

    	public static void main(String[] arg) throws Exception {

		WebserverInterface WSI = (WebserverInterface) Naming.lookup("rmi://link/WebserverInterface");
                WSI.setPassword(password);
                WSI.setUsername(username);
                
	}
    
}
