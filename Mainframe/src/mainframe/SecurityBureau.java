/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainframe;

import brugerautorisation.transport.soap.Brugeradmin;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author nb
 */
@WebService(endpointInterface = "mainframe.UserAuthenticationInterface")
public class SecurityBureau extends UnicastRemoteObject implements UserAuthenticationInterface{

    SensorCommandCenter nsa;
    CyberCommunicationCenter nasa;
    DataManipulationService db;
    
    SecurityBureau() throws MalformedURLException {
        URL url = new URL("http://ubuntu4.javabog.dk:9901/kontotjeneste?wsdl");
        QName qname = new QName("https://niklasbuhl.xyz/sensorinfrastructure/", "UserAuthenticationInterfaceService");
        Service service = Service.create(url, qname);
        UserAuthenticationInterface g = service.getPort(UserAuthenticationInterface.class);
    }

    // Backgroundcheck User
    
    @Override
    public boolean login(String name, String pass) {
        Brugeradmin ba;
        try {
            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
            QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
            Service service = Service.create(url, qname);
            ba = service.getPort(Brugeradmin.class);
        } catch (MalformedURLException e1) {
            return false;
        }
        try {
            ba.hentBruger(name, pass);
            return true;

        } catch (IllegalArgumentException e) {
        }
        return false;
    }
    
    /******* ***************************************************************************
     * 
     * Klienten der skal forsøge at logge ind skal indeholde:
     * 
     * 
        URL url = new URL("http://ubuntu4.javabog.dk:9901/kontotjeneste?wsdl");
        QName qname = new QName("http://galgeleg/", "GalgelegImplService");
        Service service = Service.create(url, qname);
        UserAuthenticationInterface g = service.getPort(UserAuthenticationInterface.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Du skal logge ind før, at du kan spille Galgeleg");
        boolean isLoggedIn = false;
        while (!isLoggedIn) {

            System.out.println("Indtast dit brugernavn (studie-nr.)");
            String bruger = scanner.nextLine();

            System.out.println("Indtast dit password");
            String password = scanner.nextLine();

            if (g.login(bruger, password)) {
                System.out.println("Logged in with username: " + bruger + " and password: " + password);
                isLoggedIn = true;
            } else {
                System.out.println("Wrong userlogin!");
            }
        }
     ***********************************************************************************************************/

}
