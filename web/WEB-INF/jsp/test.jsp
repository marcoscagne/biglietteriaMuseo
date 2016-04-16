<%-- 
    Document   : test
    Created on : 13-apr-2016, 13.17.04
    Author     : FSEVERI\scagnellato3082
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%--String nu=request.getParameter("nu");%>
        <%String p=request.getParameter("pass");--%>
        NomeUtente: ${nomeUtente}<%--=nu--%>
        Password: ${password}<%--=p--%>
        
    </body>
</html>
