<%-- 
    Document   : login
    Created on : Mar 10, 2017, 10:12:26 PM
    Author     : Mustafa
--%>

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
            String username = request.getParameter("usrename");
            String password = request.getParameter("password");
        %>
    <tbody>
        <tr>
            <td>Username</td>
            <td><%= username%></td>
        </tr>
        <tr>
            <td>Password</td>
            <td> <%= password%></td>
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
