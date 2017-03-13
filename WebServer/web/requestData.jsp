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

        <form action="mainframeConnect" method="POST">

            <table border="0" width="3" cellspacing="4" cellpadding="6">
                <tbody>
                    <tr>
                        <td>Logged in as: </td>
                        <td>Username:</td>
                        <td>Location:</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>From: </td>
                        <td><input type="date" name="fromDate"></td>
                        <td>To:</td>
                        <td><input type="date" name="toDate"></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Location: </td>
                        <td><select name="location">
                                <option>Location</option>
                                <option>DTU Lyngby</option>
                                <option>DTU Ballerup</option>
                            </select></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Sensor: </td>
                        <td><select name="sensor">
                                <option>Sensor</option>
                                <option>Temperature</option>
                                <option>Noise Level</option>
                                <option>Humidity</option>
                            </select>

                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>    <input type="reset" value="Clear" /></td>
                        <td>    <input type="submit" value="Request" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>








        </form>

    </body>
</html>
