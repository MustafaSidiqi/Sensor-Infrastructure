package brugerautorisation.transport.rmi;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.Bruger;
import java.rmi.Naming;

public class Brugeradminklient {
	public static void main(String[] arg) throws Exception {
//		Brugeradmin ba =(Brugeradmin) Naming.lookup("rmi://localhost/brugeradmin");
		Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

    //ba.sendGlemtAdgangskodeEmail("s153712", "Her er din bøgse kode");
		//ba.ændrAdgangskode("s143322", "xxx", "xxxx");
		Bruger b = ba.hentBruger("jacno", "xxx");
		System.out.println("Fik bruger = " + b);
		System.out.println("Data: " + Diverse.toString(b));
		ba.sendEmail("jacno", "xxx", "Hurra det virker!", "Jeg er så glad");

		Object ekstraFelt = ba.getEkstraFelt("jacno", "xxx", "s123456_testfelt");
		System.out.println("Fik ekstraFelt = " + ekstraFelt);

		ba.setEkstraFelt("jacno", "xxx", "s123456_testfelt", "Hej fra Jacob"); // Skriv noget andet her

		String webside = (String) ba.getEkstraFelt("jacno", "xxx", "webside");
		System.out.println("webside = " + webside);
	}
}
