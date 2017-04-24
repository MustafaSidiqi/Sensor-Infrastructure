<%@page import="java.rmi.registry.Registry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>
<%@page import="java.rmi.registry.LocateRegistry"%>

<%@page import="javax.xml.ws.Service"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URL"%>
<%@page import="javax.xml.namespace.QName"%>

<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         %>

<DOCTYPE html>
    <html>

    <head>

        <title> SensorInfrastructure</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body background="img/background.png">
        <ul class="nav">

            <div class="login">
                <a href="login.jsp">LOGIN </a>
            </div>


            <div class="logo">
                <a href="#">LOGO </a>
            </div>



            <li> <a href="index.html"> Home </a></li>
            <li> <a href="index.html"> About </a></li>
            <li> <a href=""> Services </a></li>
            <li> <a href=""> Contact</a></li>



        </ul>




        <div class="heading">Login </div>

        <form name="loginForm" action="loginRMI" method="POST">
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


    </body>
    
</html>
    </html>