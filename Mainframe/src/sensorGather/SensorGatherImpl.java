package sensorGather;

import brugerautorisation.data.Bruger;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
//import brugerautorisation.transport.rmi.Brugeradmin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class SensorGatherImpl extends UnicastRemoteObject implements SensorGatherI {

    //private SensorGatherLogik logik;
    loginData l;
    //private Brugeradmin BI;
    private ArrayList<Integer> sensorData = new ArrayList<>();
    //private ArrayList<Integer> temp = new ArrayList<>();
    private int dataAmount;
    private boolean isDataSent = false;
    //private boolean dataIsStored;

    public SensorGatherImpl() throws java.rmi.RemoteException {

        //logik = new SensorGatherLogik();
        //try {
        //    BI = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        //} catch (MalformedURLException | NotBoundException | RemoteException e) {
        //    e.printStackTrace();
        //}
    }

    @Override
    public int getDataAmount(ArrayList<Integer> sensorData) {
        dataAmount = sensorData.size();
        return dataAmount;
    }

    @Override
    public void storeData(Integer x) {
        sensorData.add(x);
        dataAmount++;
    }

    @Override
    public ArrayList<Integer> getSensorData() {
        //temp.clear();
        //temp = sensorData;
        //sensorData.clear();
        isDataSent = true;
        return sensorData;
    }

    @Override
    public void clearDataArray() {
        if (isDataSent) {
            sensorData.clear();
        }
        isDataSent = false;
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


    @Override
    public loginData getLogin() throws RemoteException {
       return l;
    }

    @Override
    public void setLogin(String brugernavn, String password) throws RemoteException {
        loginData.brugernavn = brugernavn;
        loginData.password = password;
    }
}
