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
        <title>Request Data</title>
        <link rel="stylesheet" type="text/css" href="style.css">



        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("select").change(function () {
                    $(this).find("option:selected").each(function () {
                        var optionValue = $(this).attr("value");
                        if (optionValue) {
                            $(".box").not("." + optionValue).hide();
                            $("." + optionValue).show();
                        } else {
                            $(".box").hide();
                        }
                    });
                }).change();
            });
        </script>






    </head>








    <body background="img/background.png">
        <ul class="nav">

            <div class="login">
                <a href="#">LOGIN </a>
            </div>


            <div class="logo">
                <a href="#">LOGO </a>
            </div>



            <li> <a href="index.html"> Home </a></li>
            <li> <a href="index.html"> About </a></li>
            <li> <a href=""> Services </a></li>
            <li> <a href=""> Contact</a></li>



        </ul>


        <div>
            <select>
                <option>Select Data</option>
                <option value="red">Location</option>
                <option value="green">Date</option>
                <option value="blue">Sensor</option>
            </select>
        </div>
        <div class="red box">

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
                        <td> <input type="reset" value="Clear" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>


        </div>
        <div class="green box">                  
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
                        <td> <input type="reset" value="Clear" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
        </div>
        <div class="blue box">
            
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
                        <td> <input type="reset" value="Clear" /></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
        </div>


        <div class="heading">Services </div>
        <form action="myServlet" method="POST">
            <table align="center" border="0" width="3" cellspacing="4" cellpadding="6">
                <tbody class="table1">


                </tbody>
            </table>
        </form>
    </body>

</html>