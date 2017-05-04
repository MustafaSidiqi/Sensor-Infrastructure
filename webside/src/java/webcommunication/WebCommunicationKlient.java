package webcommunication;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class WebCommunicationKlient implements java.io.Serializable {

    public static void main(String[] arg) throws Exception {

        //Setup RMI connection 
        WebInterface db = (WebInterface) Naming.lookup("rmi://localhost:53168/data");

        //Test with Hello World 
        System.out.println(db.getMessage());

        //Request by location 
        System.out.println(db.CallgetAllByLocation("", "test_fromCanada"));

        //Request by type 
        System.out.println(db.CallgetAllByType("", 0));

        //Request by sensorID
        ArrayList<String> temp = db.CallgetAllBySensorID("offdata", 0);
        for (String object : temp) {
            System.out.println(object);
        }

        //Data convertion and request 
        String sDate1 = "27/04/2017";

        java.util.Date utilStartDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        System.out.println(sDate1 + "\t" + sqlStartDate);

        //Request by date. Get all data by date
        temp = db.CallgetAllByDate("offdata", sqlStartDate);
        for (String object : temp) {
            System.out.println(object);
        }

        //Request by sensorID and interval.
        temp = db.CallgetIntervalBySensorID("", 0, sqlStartDate, sqlStartDate);
        for (String object : temp) {
            System.out.println(object);
        }

        //User register and login 
        if (db.CallcreateUser("mustafa", "sidiqi", "ms@gmail.com", "hva")) {
            System.out.println("User Created");
        }
    }
}
