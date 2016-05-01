<%-- 
    Document   : test
    Created on : 13-apr-2016, 13.17.04
    Author     : FSEVERI\scagnellato3082
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="biglietteria_config.HibernateUtil"%>
<%@page import="CRUD.CRUD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>controllaLogin</title>
    </head>
    <body>        
        <h1>Hello World!</h1>
        ${cliente.nome}
        ${cliente.cognome}
        ${cliente.email}
        ${cliente.codiceCat.codice}
        
        
        
        <%--
            CRUD c = new CRUD(HibernateUtil.getSessionFactory());
            String nu=(String)request.getAttribute("nomeUtente");
            String p=(String)request.getAttribute("password");
            String pa=c.getPwdCliente(nu);
            
            if(true){
                
                response.sendRedirect("./?m=registrazioneAvvenutaConSuccesso!EffettuaIlLogin!");
            }else{
                response.sendRedirect("./?m=erroreNellaRegistrazione!");
            }
        --%>
        
    </body>
</html>
