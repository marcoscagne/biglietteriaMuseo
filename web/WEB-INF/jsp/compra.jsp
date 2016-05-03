<!DOCTYPE html>
<html >
    <head>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="./resources/js/bootstrap.min.js"></script>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta charset="UTF-8">
        <title>Aggiungi Servizio</title>
        <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous"><!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
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
                        <a class="navbar-brand" href="#">National Museum</a>
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
                                    response.sendRedirect("./?m=Devi effettuare il Login!");
                                } else {%>
                            <li class="dropdown">				  
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><%=myname%></b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li>
                                        <a href="./profilo">Profilo</a>
                                        <br>
                                        <a href="./logout">Logout</a>
                                    </li>
                                </ul>
                            </li>
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
                    <h1>Acquisto di un biglietto</h1>          
                    <form action="./end" method="post">
                        <div class="row">
                            <b>Acquisto del biglietto per il</b><br/>${data}<br/>
                            <b>+</b>
                        </div>
                        <c:forEach items="${attivita}" var="a">
                            <input type="hidden" name="costo" value="${a.tariffaOrdinaria}">
                        </c:forEach>
                        <input type="hidden" name="data" value="${data}">
                        <div class="row">
                            <c:forEach items="${servizi}" var="s">
                                <div class="col-lg-4">
                                    <label><input type="checkbox" onchange="cambio(${s.codice})" id="${s.codice}">${s.descrizione}<br/><i>(+ &euro;${s.prezzo})</i></label>
                                </div>
                            </c:forEach>
                            <br/>
                            <button onclick="invia()" type="submit" class="button button-block"/>Conferma</button>
                        </div>
                    </form>
                </div>            
            </div><!-- tab-content -->  
        </div> 
        <!-- /form -->  
        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>

        <script>
            var serviziScelti = [];
            var i = 0;
            function cambio(id) {
                if ($("#" + id).prop('checked')) {
                    serviziScelti[i] = id;
                    i = i + 1;
                } else {
                    var a = serviziScelti.indexOf(id);
                    if (a != -1) {
                        serviziScelti.splice(a, 1);
                    }
                }
            }
            
            function invia(){
                
            }
            
        </script>
    </body>
</html>
