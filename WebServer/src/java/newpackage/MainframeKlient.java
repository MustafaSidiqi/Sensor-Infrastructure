/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;

/**
 *
 * @author Mustafa
 */
public class MainframeKlient {

    static int indexMax = 0;

    public static void main(String[] arg) throws Exception {

        WebserverInterface WSI;
        try {
            System.setSecurityManager(new RMISecurityManager());
            WSI = (WebserverInterface)Naming.lookup("rmi://localhost:1099/cybercommunicationscenter");
            WSI.cyberLogin("s153158", "password");

        } catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }

    }

    //boolean aktiv = true; // Boolean til at se om spillet skal spilles
}
