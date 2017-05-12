<%-- 
    Document   : logout
    Created on : May 12, 2017, 8:57:00 PM
    Author     : Mustafa Sidiqi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
//Check if the user is already logged in 
if(session.getAttribute("currentSessionUser") == null) {
            response.sendRedirect("index.html");
} else {
    session.removeAttribute("currentSessionUser");
    response.sendRedirect("index.html");
}
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
