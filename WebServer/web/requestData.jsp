<%-- 
    Document   : login
    Created on : Mar 10, 2017, 10:12:26 PM
    Author     : Mustafa
--%>

<%@page import="brugerautorisation.transport.soap.Brugeradmin"%>
<%@page import="brugerautorisation.data.Bruger"%>

<%@page import="mainframe.UserAuthenticationInterface"%>
<%@page import="javax.xml.ws.Service"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login page</title>
    </head>
    <body>
        <h1>Request data from database:</h1>
        <%


            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
            QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
            Service service = Service.create(url, qname);
            Brugeradmin ba = service.getPort(Brugeradmin.class);

            //ba.sendGlemtAdgangskodeEmail("jacno", "Dette er en test, husk at skifte kode");
            // ba.ændrAdgangskode("jacno", "kode3stljl", "xxx");
            try {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
                // String newpass = request.getParameter("newpass");
                //ba.ændrAdgangskode(user, pass, newpass);
                Bruger b = ba.hentBruger(user, pass);
                out.println("Fik bruger = " + b);
                out.println(pass);
                System.out.println(b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    <tbody>
        <tr>
            <td>Logged in as: </td>
            <td>  </td> 
        </tr>
        <tr>
            <td>Password</td>
            <td> </td>
        </tr>
    </tbody>
</table>
<form action="mainframeConnect" method="POST">

    <table border="0">

        <tbody>
            <tr>

                <td>Sensor: </td>
                <td>
                    <select name="Sensor">
                        Sensor: <option>Temperature</option>
                        <option>Sound-Level</option>
                        <option>Sunlight</option>
                    </select></td>


            </tr>
            <tr>
                <td>Date From:</td>
                <td><input type="text" name="dataFrom" value="DD/MM/YYYY" size="20" /></td>
            </tr>
            <tr>
                <td>Date To:</td>
                <td><input type="text" name="dateTo" value="DD/MM/YYYY" size="20" /></td>
            </tr>
        </tbody>
    </table>
    <input type="reset" value="Clear" />
    <input type="submit" value="Submit" />
</form>

</body>
</html>
