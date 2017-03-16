<%-- 
    Document   : login
    Created on : Mar 10, 2017, 10:12:26 PM
    Author     : Mustafa
--%>

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
        <form action="myServlet" method="POST">

            <table border="0" width="3" cellspacing="4" cellpadding="6">
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td></td>
                        <td>Location:</td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>From: </td>
                        <td><input type="date" name="fromDate">    
                        </td>
                        <td>To:</td>
                        <td><input type="date" name="toDate"></td>
                        <td><input type="submit" value="Request" name="getDateData" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Location: </td>
                        <td><select name="location">
                                <option>Location</option>
                                <option value="Lyngby">DTU Lyngby</option>
                                <option value="stue">DTU stue</option>
                            </td>
                            <td></select><input type="submit" value="Request" name="getLocationData" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Sensor: </td>
                        <td><select name="sensorID">
                                <option>Sensor</option>
                                <option value ="1" >Temperature</option>
                                <option value ="2" >Noise Level</option>
                                <option value = "3" >Humidity</option>
                            </select>

                        </td>
                        <td><input type="submit" value="Request" name="getSensordata" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>  </td>
                        <td>   </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>    <input type="reset" value="Clear" /></td>
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
