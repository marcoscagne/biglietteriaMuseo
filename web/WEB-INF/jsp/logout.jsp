<%-- 
    Document   : logout
    Created on : 23-apr-2016, 10.31.24
    Author     : FSEVERI\scagnellato3082
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("./");
        %>
    </body>
</html>
