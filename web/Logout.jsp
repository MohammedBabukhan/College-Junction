<%-- 
    Document   : logout
    Created on : Oct 29, 2024, 5:04:44 PM
    Author     : Mohammed Babukhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("Login.html");
        %>
    </body>
</html>
