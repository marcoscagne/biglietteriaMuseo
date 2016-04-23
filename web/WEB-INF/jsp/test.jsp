<%-- 
    Document   : test
    Created on : 13-apr-2016, 13.17.04
    Author     : FSEVERI\scagnellato3082
--%>

<%@page import="java.util.ArrayList"%>
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
        <h1>Hello World!</h1>
        NomeUtente: ${nomeUtente}
        Password: ${password}
        
        <%
            CRUD c = new CRUD(HibernateUtil.getSessionFactory());
            String nu=(String)request.getAttribute("nomeUtente");
            String p=(String)request.getAttribute("password");
            String pa=c.getPwdCliente(nu);
            
            if(pa!=null && pa.equals(p)){
                session.setAttribute("username",request.getAttribute("nomeUtente"));
                response.sendRedirect("./");
            }else{
                response.sendRedirect("./?m=nomeUtenteOpasswordErrati!");
                out.print("*** NOME UTENTE O PASSWORD ERRATI!! ***");
            }
        %>
        
    </body>
</html>
