<%@page import="brugerautorisation.transport.soap.Brugeradmin"%>
<%@page import="javax.xml.ws.Service"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URL"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="brugerautorisation.data.Bruger"%>

<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
        <title>Login Page 
        </title>
    </head>

    <body>
        <form name="loginForm" action="mainframeConnect" method="POST">

            <table border="0">

                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="text" name="password" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="submit" value="Submit" />
            <%
  /*
                Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

                //ba.sendGlemtAdgangskodeEmail("jacno", "Dette er en test, husk at skifte kode");
                //ba.?ndrAdgangskode("s153168", "kodelb3hs1", "password");
                Bruger b = ba.hentBruger("s153168", "password");
*/

  ////SOAP 
  /*
            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
            QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
            Service service = Service.create(url, qname);
            Brugeradmin ba = service.getPort(Brugeradmin.class);

            //ba.sendGlemtAdgangskodeEmail("jacno", "Dette er en test, husk at skifte kode");
            // ba.?ndrAdgangskode("jacno", "kode3stljl", "xxx");
            try {
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
               // String newpass = request.getParameter("newpass");
                //ba.?ndrAdgangskode(user, pass, newpass);
                Bruger b = ba.hentBruger(user, pass);
                out.println("Fik bruger = " + b);
                out.println(pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
*/
            %>

        </form>
    </body>
</html>