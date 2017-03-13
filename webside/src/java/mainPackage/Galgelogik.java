package mainPackage;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "galgeleg.GalgelegI")
public class Galgelogik extends UnicastRemoteObject implements GalgelegI {

    private ArrayList<String> muligeOrd = new ArrayList<String>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String LogStatus;
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;
    private String brugernavn;
    private ArrayList<String> highscore = new ArrayList<String>();

    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }

    public String getSynligtOrd() {
        return synligtOrd;
    }

    public String getOrdet() {
        return ordet;
    }

    public int getAntalForkerteBogstaver() {
        return antalForkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }

    public boolean erSpilletVundet() {
        return spilletErVundet;
    }

    public boolean erSpilletTabt() {
        return spilletErTabt;
    }

    public boolean erSpilletSlut() {
        return spilletErTabt || spilletErVundet;
    }

    public ArrayList getHighscore() {
        return highscore;
    }

    public Galgelogik() throws java.rmi.RemoteException {
        muligeOrd.add("bil");
        muligeOrd.add("computer");
        muligeOrd.add("programmering");
        muligeOrd.add("motorvej");
        muligeOrd.add("busrute");
        muligeOrd.add("gangsti");
        muligeOrd.add("skovsnegl");
        muligeOrd.add("solsort");
        //nulstil();
        try {
            hentOrdFraDr();
            System.out.println("Hentede succesfuldt ord fra dr.dk's hjemmeside");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Mislykkedes med at hente ord fra dr.dk - anvender standard udvalg");
        }
    }

    public void nulstil() {
        highscore.clear();
        brugteBogstaver.clear();
        antalForkerteBogstaver = 0;
        spilletErVundet = false;
        spilletErTabt = false;
        ordet = muligeOrd.get(new Random().nextInt(muligeOrd.size()));
        opdaterSynligtOrd();
        try {
            loadHighscore();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Galgelogik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void opdaterSynligtOrd() {
        synligtOrd = "";
        spilletErVundet = true;
        for (int n = 0; n < ordet.length(); n++) {
            String bogstav = ordet.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + "*";
                spilletErVundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {
        if (bogstav.length() != 1) {
            return;
        }
        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (brugteBogstaver.contains(bogstav)) {
            return;
        }
        if (spilletErVundet || spilletErTabt) {
            return;
        }

        brugteBogstaver.add(bogstav);

        if (ordet.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true;
            System.out.println("Bogstavet var korrekt: " + bogstav);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false;
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            antalForkerteBogstaver = antalForkerteBogstaver + 1;
            if (antalForkerteBogstaver > 6) {
                spilletErTabt = true;
            }
        }
        opdaterSynligtOrd();
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + ordet);
        System.out.println("- synligtOrd = " + synligtOrd);
        System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + brugteBogstaver);
        if (spilletErTabt) {
            System.out.println("- SPILLET ER TABT");
        }
        if (spilletErVundet) {
            System.out.println("- SPILLET ER VUNDET");
        }
        System.out.println("---------- ");
    }

    public String getLogStatus() {

        LogStatus = "";
        LogStatus += "---------- " + "\n";
        //  LogStatus.add("- ordet (skult) = " + ordet);
        LogStatus += "- synligtOrd = " + synligtOrd + "\n";
        LogStatus += "- forkerteBogstaver = " + antalForkerteBogstaver + "\n";
        LogStatus += "- brugeBogstaver = " + brugteBogstaver + "\n";
        if (spilletErTabt) {
            LogStatus += "- SPILLET ER TABT \n";
            LogStatus += "Ordet var: " + ordet + "\n";
        }
        if (spilletErVundet) {
            LogStatus += "- SPILLET ER VUNDET \n";
        }
        LogStatus += "---------- " + "\n";

        return LogStatus;
    }

    public static String hentUrl(String url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    public void hentOrdFraDr() throws Exception {
        String data = hentUrl("http://dr.dk");
        System.out.println("data = " + data);

        data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zæøå]", " ");
        System.out.println("data = " + data);
        muligeOrd.clear();
        muligeOrd.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

        System.out.println("muligeOrd = " + muligeOrd);
        nulstil();
    }

    public boolean loggedIn(String bruger, String adgangskode) throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = null;
        brugernavn = bruger;
        ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

        try {
            Bruger b = ba.hentBruger(brugernavn, adgangskode);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void highScore() {
        if (erSpilletSlut()) {
            highscore.add("" + antalForkerteBogstaver + " " + brugernavn);
        }
    }

    public void saveHighscore() throws FileNotFoundException, IOException {
        highScore();
        Collections.sort(highscore);
        BufferedWriter w = null;
        w = new BufferedWriter(new FileWriter("highscore.txt"));
        for (String hs : highscore) {
            w.write(hs);
            w.newLine();
        }
        w.flush();
        w.close();
    }

    public void loadHighscore() throws FileNotFoundException {
        Scanner inFile1 = new Scanner(new File("highscore.txt")).useDelimiter(",\\s*");

        while (inFile1.hasNext()) {
            // find next line
            String token1 = inFile1.nextLine();
            highscore.add(token1);
        }
        Collections.sort(highscore);
        inFile1.close();
    }
}
