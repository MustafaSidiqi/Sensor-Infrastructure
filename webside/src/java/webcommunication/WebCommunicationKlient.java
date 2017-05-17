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
       //WebInterface db = (WebInterface) Naming.lookup("rmi://ubuntu4.javabog.dk:53168/data");
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
        // 2017-04-27 
        String sDate1 = "2017/04/27";

        java.util.Date utilStartDate = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        System.out.println(sDate1 + "\t" + sqlStartDate);

        //Request by date. Get all data by date
        temp = db.CallgetAllByDate("offdata", sqlStartDate);
        System.out.println("Requesting by date");
        for (String object : temp) {
            System.out.println(object);
        }

        //Request by sensorID and interval.
        temp = db.CallgetIntervalBySensorID("", 0, sqlStartDate, sqlStartDate);
        for (String object : temp) {
            System.out.println(object);
        }

        //User register and login 
        System.out.println("User ID: " + db.CallgetID("mustafa2", "sidiqi10"));

        System.out.println("CallgetLocationList");

        temp = db.CallgetSensorIDlist("");
        for (String object : temp) {
            System.out.println(object);
        }

    }
}
