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
                <a href="login.jsp">LOGIN </a>
            </div>
            <div class="logo">
                <a href="#">LOGO </a>
            </div>
            <li> <a href="index.html"> Home </a></li>
            <li> <a href="index.html"> About </a></li>
            <li> <a href="requestData.jsp"> Services </a></li>
            <li> <a href=""> Contact</a></li>
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
                <button class="tablinks" onclick="openCity(event, 'Sensor')" id="defaultOpen">Sensor</button>
                <button class="tablinks" onclick="openCity(event, 'Location')">Location</button>
                <button class="tablinks" onclick="openCity(event, 'Date')">Date</button>
                <button class="tablinks" onclick="openCity(event, 'Type')">Type</button>
            </div>
            <div id="Sensor" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'SensorByID')" id="defaultOpen">Sensor ID</button>
                    <button class="tablinks" onclick="openCity(event, 'SensorByDate')">Date Interval</button>
                </div>
            </div>

            <div id="Location" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright">x</span>
                <div class="tab">

                    <button class="tablinks" onclick="openCity(event, 'LocationByID')" id="defaultOpen">Location ID</button>
                    <button class="tablinks" onclick="openCity(event, 'LocationByDate')">Date Interval</button>

                </div>
            </div>

            <div id="Date" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright">x</span>
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'DateByID')" id="defaultOpen">Date ID</button>
                    <button class="tablinks" onclick="openCity(event, 'DateByDate')">Date Interval</button>
                </div>
            </div>

            <div id="Type" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright">x</span>
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'TypeByID')" id="defaultOpen">Type ID</button>
                    <button class="tablinks" onclick="openCity(event, 'TypeByDate')">Date Interval</button>
                </div>
            </div>

            <div id="SensorByID" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright">x</span>
                <h3>Sensor By ID</h3>
                <div>
                    <form method="post" action="myServlet">
                        <select name="database">
                            <option selected="selected">Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <select name="sensorID" id="SensorID">
                            <option selected="selected"  value="Select ID">Select ID</option>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                        <input type="submit" name="requestSensorByID" value="Send Request" />
                    </form>
                </div>
                <textarea rows="4" cols="50"> 
                </textarea>
            </div>
            <div id="SensorByDate" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Sensor By Interval</h3>
                <div>
                    <form method="post" action="myServlet">
                        <select name="database">
                            <option selected="selected">Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <select name="sensorID" id="SensorID">
                            <option selected="selected"  value="Select ID">Select ID</option>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                        <br>
                        <input type="date" name="From">
                        <input type="date" name="To">
                        <br><br><br>
                        <input type="submit" name="requestSensorByDate" value="Send Request " />
                    </form>
                </div>
                <br>
            </div>
            <div id="LocationByID" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Location By ID</h3>
                <div>
                    <form method="Post" action="myServlet">
                        <select name="database">
                            <option>Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <select name="LocationID">
                            <option value="Lyngby">Lyngby</option>
                            <option value="Stue">Stue</option>
                        </select>
                        <input type="submit" name="requestLocationByID" value="Send Request " />
                    </form>
                </div>
                <br>

            </div>

            <div id="LocationByDate" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Location By Interval</h3>
                <div>
                    <form method="Post" action="myServlet">
                        <select name="database">
                            <option>Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <select name="LocationID">
                            <option value="Lyngby">Lyngby</option>
                            <option value="Stue">Stue</option>
                        </select>
                        <br>
                        <input type="date" name="From">
                        <input type="date" name="To">
                        <br><br><br>
                        <input type="submit" name="requestLocationByDate" value="Send Request " />
                    </form>
                </div>
                <br>

            </div>

            <div id="DateByID" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Date By ID</h3>
                <div>
                    <form method="Post" action="myServlet">
                        <select name="database">
                            <option>Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <input type="date" name="From">
                        <br><br><br>
                        <input type="submit" name="requestDateByID" value="Send Request " />
                    </form>
                </div>
                <br>

            </div>

            <div id="DateByDate" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Date By Interval</h3>
                <div>
                    <form method="Post" action="myServlet">
                        <select name="database">
                            <option>Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <input type="date" name="From">
                        <input type="date" name="To">
                        <br><br><br>
                        <input type="submit" name="requestDateByDate" value="Send Request " />
                    </form>
                </div>
                <br>

            </div>

            <div id="TypeByID" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Type By ID</h3>
                <div>
                    <form method="post" action="myServlet">
                        <select name="database">
                            <option selected="selected">Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <select name="TypeByIDID" id="TypeID">
                            <option selected="selected"  value="Select ID">Select ID</option>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>

                        <br><br><br>
                        <input type="submit" name="requestTypeByID" value="Send Request " />
                    </form>
                </div>
                <br>

            </div>

            <div id="TypeByDate" class="tabcontent">
                <span onclick="this.parentElement.style.display = 'none'" class="topright"></span>
                <h3>Type By interval</h3>
                <div>
                    <form method="post" action="myServlet">
                        <select name="database">
                            <option selected="selected">Choose Database</option>
                            <option value="offdata">Main</option>
                            <option value="expdata">Exp</option>
                        </select>
                        <br>
                        <select name="TypeByDateID" id="TypeID">
                            <option selected="selected"  value="Select ID">Select ID</option>
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                        <br>
                        <input type="date" name="From">
                        <input type="date" name="To">
                        <br><br><br>
                        <input type="submit" name="requestTypeByDate" value="Send Request " />
                    </form>
                </div>
                <br>
                <textarea rows="4" cols="50"> 
                </textarea>
            </div>
        </tbody>
    </table>
</form>
<textarea rows="4" cols="50"> 
    <%
        out.print("display data: ");
        //retrieve your list from the request, with casting 
        ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");

        //print the information about every category of the list
        for (String object : list) {
            out.println(object);
        }


    %>
</textarea>
</body>
</html>


