package webcommunication;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Kontoklient implements java.io.Serializable {

    public static void main(String[] arg) throws Exception {
        //  KontoI k =(KontoI) Naming.lookup("rmi://javabog.dk:20099/kontotjeneste");
        //System.setSecurityManager(new RMISecurityManager());

        ArrayList<String> data;
        // Amazon IP server: 52.56.199.233
        WebInterface db = (WebInterface) Naming.lookup("rmi://localhost:53168/data");
        System.out.println(db.CallgetAllByLocation("", "test_fromCanada"));
        System.out.println(db.CallgetAllByType("", 0));

        System.out.println(db.getMessage());
        ArrayList<String> temp = db.CallgetAllBySensorID("offdata", 0);
        for (String object : temp) {
            System.out.println(object);
        }

        String sDate1 = "27/04/2017";
        java.util.Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        System.out.println(sDate1 + "\t" + date1);
    
        System.out.println(db.CallgetAllByDate("", (Date)date1));

    }
}
