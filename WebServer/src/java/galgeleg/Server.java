/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Kunoh
 */
public class Server {

    public static void main(String[] arg) throws Exception {
        // Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
        //    java.rmi.registry.LocateRegistry.createRegistry(43764); // start i server-JVM

        try {

            GalgelegI stub = (GalgelegI) new Galgelogik();

            Registry registry = LocateRegistry.createRegistry(53518);
            registry.bind("GalgelegI15351", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
        //   GalgelegI k = new Galgelogik();
        // Endpoint.publish("http://[::]:43764/galgeleg", k);
        //   Naming.rebind("rmi://localhost/kontotjeneste", k);
        //  System.out.println("Kontotjeneste registreret.");
    }

}
