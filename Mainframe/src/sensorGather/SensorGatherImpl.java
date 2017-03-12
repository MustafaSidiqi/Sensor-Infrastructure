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
    //private Brugeradmin BI;
    private ArrayList<Integer> sensorData = new ArrayList<>();
    //private ArrayList<Integer> temp = new ArrayList<>();
    private int dataAmount;
    private boolean isDataSent = false;
    private static String username = "na";
    private static String password = "na";
    private static final String sensorID = "0001";
    private static final String sensorType = "Temperature";
    private static final String sensorDataType = "Integer";
    private static final String sensorUnit = "Celcius";
    private static final String sensorName = "Temperature Data";
    
    
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
    public int getDataAmount() {
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
/*
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
*/

    @Override
    public String getUsername() throws RemoteException {
       return username;
    }
    
    @Override
    public String getPassword() throws RemoteException {
       return password;
    }
    
    @Override
    public void setLogin(String brugernavn, String password) throws RemoteException {
        SensorGatherImpl.username = brugernavn;
        SensorGatherImpl.password = password;
    }

    @Override
    public String getID() throws RemoteException {
        return sensorID;
    }

    @Override
    public String getType() throws RemoteException {
        return sensorType;
    }

    @Override
    public String getDataType() throws RemoteException {
        return sensorDataType;
    }

    @Override
    public String getUnit() throws RemoteException {
        return sensorUnit;
    }

    @Override
    public String getName() throws RemoteException {
        return sensorName;
    }
}
