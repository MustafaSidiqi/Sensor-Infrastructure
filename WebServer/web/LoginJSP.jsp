<%@page import="brugerautorisation.data.Bruger"%>
<%@page import="brugerautorisation.transport.rmi.Brugeradmin"%>
<%@page import="java.rmi.Naming"%>
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
        <form name="loginForm" action="RequestData.jsp" method="POST">

            <table border="0">

                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="usrename" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="text" name="password" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="submit" value="Submit" />
            <%
                Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

                //ba.sendGlemtAdgangskodeEmail("jacno", "Dette er en test, husk at skifte kode");
                //ba.?ndrAdgangskode("s153168", "kodelb3hs1", "password");
                Bruger b = ba.hentBruger("s153168", "password");


            %>

        </form>
    </body>
</html>