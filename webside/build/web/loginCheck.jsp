<%-- 
    Document   : loginCheck
    Created on : May 12, 2017, 7:59:03 PM
    Author     : Mustafa Sidiqi
--%>

<%@page import="webcommunication.loginServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//Check if the user is already logged in 
if(session.getAttribute("currentSessionUser") == null) {
            response.sendRedirect("login.jsp");
} else {
    response.sendRedirect("getDatabaseValues");
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
