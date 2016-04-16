<%-- 
    Document   : test
    Created on : 13-apr-2016, 13.17.04
    Author     : FSEVERI\scagnellato3082
--%>

<%@page import="org.hibernate.SessionFactory"%>
<%@page import="biglietteria_config.HibernateUtil"%>
<%@page import="biglietteria.CRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>controllaLogin</title>
    </head>
    <body>
        
        <% 
            SessionFactory factory = HibernateUtil.getSessionFactory();
            CRUD c = new CRUD(factory);
            c.listClienti();
        %>
        
        
        
        <h1>Hello World!</h1>
        NomeUtente: ${nomeUtente}
        Password: ${password}
        
    </body>
</html>
