<%-- 
    Document   : login
    Created on : Mar 10, 2017, 10:12:26 PM
    Author     : Mustafa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.ws.Service"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="java.net.URL"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Data</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
        <script type="text/javascript">
        </script>
    </head>
    <body background="img/background.png">
        <ul class="nav">

            <div class="login">
                <a href="logout.jsp"> LOGOUT </a>
            </div>
            <li> <a href="index.html"> Home </a></li>
            <li> <a href="about.jsp"> About </a></li>
            <li> <a href="requestData.jsp"> Services </a></li>
        </ul>
        <script>
            function openCity(evt, cityName) {
                var i, tabcontent, tablinks;
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " active";
            }

            // Get the element with id="defaultOpen" and click on it
            document.getElementById("defaultOpen").click();
        </script>
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

        <div class="heading">Services </div>
        <table align="center" border="0" width="3" cellspacing="4" cellpadding="6">
            <tbody class="table1">
            <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'Sensor')" id="defaultOpen">Upload Data</button>

            </div>
            <div id="Sensor" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'Experimental')" id="defaultOpen">Experimental Database</button>
                    <button class="tablinks" onclick="openCity(event, 'Official')">Official Database</button>
                </div>
            </div>

            <div id="Experimental" class="tabcontent">
                <h3>Upload to Experimental Database</h3>
                <div>
                    <form method="post" action="uploadexpdata">

                        <input type="number" name="ID" placeholder="Sensor ID" required>
                        <input type="text" name="loc" placeholder="Location" required>
                        <br>
                        <br>
                        <input type="text" name="type" placeholder="Type" required>
                        <input type="text" name="unit" placeholder="Unit" required>
                        <br>
                        <br>
                        <input type="number" name="value" placeholder="Value" required>
                        <br>
                        <br>
                        <input type="text" name="date" placeholder="YYYY-MM-DD" required >

                        <br>
                        <br>
                        <input type="submit" name="requestSensorByID" value="Send Request" />
                    </form>
                </div>
            </div>

            <div id="Official" class="tabcontent">
                <h3>Upload to Official Database</h3>
                <div>
                    <form method="post" action="uploadoffdata">

                        <input type="number" name="ID" placeholder="Sensor ID" required>
                        <input type="text" name="loc" placeholder="Location" required>
                        <br>
                        <br>
                        <input type="text" name="type" placeholder="Type" required>
                        <input type="text" name="unit" placeholder="Unit" required>
                        <br>
                        <br>
                        <input type="number" name="value" placeholder="Value" required>
                        <br>
                        <br>
                        <input type="text" name="date" placeholder="YYYY-MM-DD" required >

                        <br>
                        <br>
                        <input type="submit" name="requestSensorByID" value="Send Request" />
                    </form>
                </div>

                </tbody>
        </table>
    </form>

</body>
</html>


