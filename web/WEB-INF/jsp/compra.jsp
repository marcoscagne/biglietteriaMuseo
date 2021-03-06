<!DOCTYPE html>
<html >
    <head>
        <%@include file="header.jsp"%>
        <title>Personalizzazione acquisto</title>
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
                                    response.sendRedirect("./?m=DevieffettuareilLogin!");
                                } else {%>
                            <li class="dropdown">				  
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><%=myname%></b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                        <li style="padding-bottom: 10px;">
                                            <button onclick="location.href='./profilo?nu=<%=myname%>';" class="btn btn-primary btn-block">Profilo</button>
                                            <button onclick="location.href='./logout';" class="btn btn-primary btn-block">Logout</button>
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
                    <form action="./comprato" method="post">
                        <div class="row">
                            <b>Acquisto del biglietto per il</b><br/>${data}<br/>
                            <b>+</b>
                        </div>
                        <c:forEach items="${attivita}" var="a">
                            <input type="hidden" name="costo" value="${a.tariffaOrdinaria}">
                            <input type="hidden" name="idAtt" value="${a.codice}">
                        </c:forEach>
                        <input type="hidden" name="user" value="<%=myname%>">
                        <input type="hidden" name="data" value="${data}">
                        <input type="hidden" name="cat" value="${categoria.codice}">
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
                var serv = "";
                for(i=0;i<serviziScelti.length;i++)
                    serv += "servizi[]="+serviziScelti[i]+"&";
                $.get("./salvaCarrello?"+serv,  function (data){
                        
                });
            }
            
        </script>
    </body>
</html>
