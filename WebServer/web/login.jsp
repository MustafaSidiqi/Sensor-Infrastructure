<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="newpackage.GalgelegI"%>
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
                <%
            GalgelegI spil = null;
            boolean aktiv = false;
            try {
                Registry registry = LocateRegistry.getRegistry("ubuntu4.javabog.dk", 53518);
                spil = (GalgelegI) registry.lookup("GalgelegI15351");
                //    spil.nulstil();
                spil.logStatus();

            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        <form name="loginForm" action="mainframeConnect" method="POST">
            <table border="0" cellspacing="5" cellpadding="5">

                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="" size="20" /></td>
                          

                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
                </tbody>
            </table> 
        </form>
        
                <%
            String brugernavn = "jacno";
            String adgangskode = "xxx";
            if (!aktiv) {
                aktiv = spil.loggedIn(brugernavn, adgangskode);
            }
            if (aktiv == true) {
                out.println("Welcome " + brugernavn + " <meta http-equiv=refresh content=2;URL=\"requestData.jsp\">");

            } else {
                out.println("You have entered a wrong username " + brugernavn + " <meta http-equiv=refresh content=5;URL=\"login.jsp\">");
                out.println("<br><br/> Redirecting...");            }
        %>
    </body>
</html>