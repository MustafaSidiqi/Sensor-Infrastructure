/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService
public interface GalgelegI extends java.rmi.Remote {

    public void nulstil() throws java.rmi.RemoteException;

    public void gætBogstav(String bogstav) throws java.rmi.RemoteException;

    public void logStatus() throws java.rmi.RemoteException;

    //public String getLogStatus() throws java.rmi.RemoteException;
    public String getLogStatus() throws java.rmi.RemoteException;

    public boolean erSpilletSlut() throws java.rmi.RemoteException;

    public boolean loggedIn(String brugernavn, String adgangskode) throws RemoteException, NotBoundException, MalformedURLException;

    public void saveHighscore() throws FileNotFoundException, IOException;

    public ArrayList getHighscore() throws java.rmi.RemoteException;
    
    public void hentOrdFraDr() throws Exception;
}
