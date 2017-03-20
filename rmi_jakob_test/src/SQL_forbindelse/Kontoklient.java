package SQL_forbindelse;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;

public class Kontoklient implements java.io.Serializable{

    public static void main(String[] arg) throws Exception {
        //  KontoI k =(KontoI) Naming.lookup("rmi://javabog.dk:20099/kontotjeneste");
        //System.setSecurityManager(new RMISecurityManager());
        
                ArrayList<String> data;
        // Amazon IP server: 52.56.199.233
        //sql_interface db = (sql_interface) Naming.lookup("rmi://localhost:53067/WEB_SQL");
        sql_interface db = (sql_interface) Naming.lookup("rmi://ubuntu4.javabog.dk:53067/WEB_SQL");
        data = db.getAllBySensorID_RMI(1);
        for (String d : data) {
            System.out.println(d);
        }

        /*   System.out.println( "Saldo er: "+ k.saldo() );
                
                k.overførsel(100,"Taras");
                k.overførsel(50,"Taras");
                
		System.out.println( "Saldo er: "+ k.saldo() );
                
		k.overførsel(-200,"Taras");
		k.overførsel(51,"Taras");
                
		System.out.println( "Saldo er: "+ k.saldo() );
                
		ArrayList<String> bevægelser = k.bevægelser();

		System.out.println( "Bevægelser er: "+ bevægelser );
         */
    }
}
