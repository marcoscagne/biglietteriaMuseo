<%@page import="java.util.List"%>
<%@page import="biglietteria.Servizi"%>
<%@page import="biglietteria.Servizi"%>
<%@page import="biglietteria_config.HibernateUtil"%>
<%@page import="CRUD.CRUD"%>
<%@page import="org.hibernate.Query"%>
<!DOCTYPE html>
<html >
    <head>
        <%@include file="header.jsp"%>
        <title>Riepilogo Acquisto</title>
        <link rel="stylesheet" href="./resources/css/normalize.css">
        <link rel="stylesheet" href="./resources/css/style.css">
        <link rel="stylesheet" href="./resources/css/form.css">
    </head>
    <body background="./resources/img/background-buyment.jpg">

        <div align="center" />
        <div id="menu">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="./">National Museum</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="./">Home<span class="sr-only">(current)</span></a></li>
                            <li><a href="./attivita">Attivit&agrave;</a></li>
                            <li><a href="./gallery">Gallery</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <%                               
                                String myname = (String) session.getAttribute("username");

                                if (myname == null) {
                                    response.sendRedirect("./?m=DeviEffettuareIlLogin!");
                                } else {%>
                                    <li><a href="./logout">Logout</a></li>
                                <%}
                            %>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <div class="registrazione">  
            <div class="tab-content">
                <div id="signup">   
                    <h1>Acquisto avvenuto con successo!</h1>
                    <h3>Riepilogo:</h3><hr style="border-top: 1px solid black"><br/>
                    ${costo}&euro; - ${sconto}%
                    <br/>
                    ${data}
                    </br><br/>
                    <h4><b>Servizi Scelti</b></h4>
                    <% Integer[] servizi = (Integer[]) session.getAttribute("servizi");%>
                    
                    <%
                        for (Integer s : servizi){
                            CRUD c = new CRUD (HibernateUtil.getSessionFactory());
                            Servizi servizio = c.servizio(s);
                            out.print(servizio.getDescrizione());
                            out.print(servizio.getPrezzo()+"&euro;");
                            out.print("<br/>");
                        }
                    %>
                    <div id="out">
                    </div>
                </div>
            </div><!-- tab-content -->  
        </div> 
        <!-- /form -->  
        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>
        
        <script>
            
        </script>
        
    </body>
</html>
