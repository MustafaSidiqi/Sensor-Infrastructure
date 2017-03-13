/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galgeleg;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Kunoh
 */
public class Klient {

    public static void main(String[] arg) throws Exception {

        //    URL url=new URL("http://ubuntu4.javabog.dk:43764/galgeleg?wsdl");
        //    QName qname= new QName("http://galgeleg/","GalgelegImplService");
        //    Service service= Service.create(url,qname);
        //    GalgelegI k = (GalgelegI) service.getPort(GalgelegI.class);
        //    Galgelogik spil = new Galgelogik();
        //    spil.nulstil();
        // spil.hentOrdFraDr();
        //    spil.logStatus();
        GalgelegI spil = null;
        ArrayList<String> highscore = new ArrayList();
        String input = "";

        try {
            Registry registry = LocateRegistry.getRegistry("ubuntu4.javabog.dk", 53518);
            spil = (GalgelegI) registry.lookup("GalgelegI15351");
            spil.nulstil();
            spil.logStatus();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner keyboard = new Scanner(System.in);
        while (true) {
            if (input.equals("9")){
                break;
            }
            while (true) {
                System.out.println("Brugernavn: ");
                String brugernavn = keyboard.nextLine();
                System.out.println("Adgangskode: ");
                String adgangskode = keyboard.nextLine();
                if (spil.loggedIn(brugernavn, adgangskode)) {
                    break;
                } else {
                    System.out.println("Forkert brugernavn eller kode");
                }
            }
            while (true) {
                System.out.println("Tryk 1: Start spil");
                System.out.println("Tryk 2: Se highscore");
                System.out.println("Tryk 3: Log ud");
                System.out.println("Tryk 9: Afslut spil");
                input = keyboard.nextLine();
                if(input.equals("3") || input.equals("9")){
                    break;
                }
                Thread.sleep(300);
                switch (input) {

                    case "1":
                        spil.nulstil();
                        while (true) {
                            System.out.println(spil.getLogStatus());
                            System.out.println("Gæt et bogstav: ");
                            String bogstav = keyboard.nextLine();
                            spil.gætBogstav(bogstav);
                            if (spil.erSpilletSlut()) {
                                System.out.println(spil.getLogStatus());
                                spil.saveHighscore();
                                break;
                            }
                        }
                        break;
                    case "2":
                        int i = 1;
                        highscore = spil.getHighscore();
                        System.out.println("");
                        for (String s : highscore){
                            System.out.println(i + ". " + s);
                            i++;
                        }
                        System.out.println("");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
