<html>
    <head>
        <%@include file="header.jsp"%>
        <title>Dettagli evento</title>
        <link rel="stylesheet" href="./resources/css/style.css">
    </head>
    <body style="background:url(./resources/img/background-activity.jpg) fixed white">
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

                                if (myname == null) {%>
                            <li class="dropdown">				  
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-12">

                                                <form class="form" role="form" method="post" action="./controllaLogin" accept-charset="UTF-8" id="login-nav">
                                                    <div class="form-group">
                                                        <input type="text" name="nu" class="form-control" id="exampleInputEmail2" placeholder="Username">
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                        <input type="password" name="pass" class="form-control" id="exampleInputPassword2" placeholder="Password">
                                                        <!--<div class="help-block text-right"><a href="">Password dimenticata?</a></div>-->
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit" class="btn btn-primary btn-block">Accedi</button>
                                                    </div>
                                                </form>

                                            </div>
                                            <div class="bottom text-center">
                                                Sei nuovo qui? <a href="./registrazione"><b>Registrati</b></a>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <%} else {%>
                            <li class="dropdown">				  
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b><%=myname%></b> <span class="caret"></span></a>
                                <ul id="login-dp" class="dropdown-menu">
                                    <li style="padding-bottom: 10px;">
                                        <button onclick="location.href = './profilo?nu=<%=myname%>';" class="btn btn-primary btn-block">Profilo</button>
                                        <button onclick="location.href = './logout';" class="btn btn-primary btn-block">Logout</button>
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

        <c:forEach items="${attivitaID}" var="a">

            <c:if test="${a.tipo=='evento'}">
                <div id="news" style="margin-top: 80px; width: 80%;" align="center">
                    <div class="img" align="left">
                        <div class="row">
                            <div class="col-md-12">
                                <img src="${a.immagine}" width="100%">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <span class="img-title">${a.titolo}</span>
                                <form action="./comprato" method="post">
                                    <div class="img-description">
                                        ${a.descrizione}
                                        <br/><br/>
                                        <b>Costo Ingresso:</b> &euro;${a.tariffaOrdinaria}
                                        <input type="hidden" name="costo" value="${a.tariffaOrdinaria}">
                                        <input type="hidden" name="user" value="<%=myname%>">
                                        <input type="hidden" name="idAtt" value="${a.codice}">
                                        <br/><br/>
                                        <b>Data:</b> ${a.data}
                                        <input type="hidden" name="data" value="${a.data}">
                                        <br/>
                                        <b>Data Fine:</b> ${a.dataFine}
                                        
                                        <div class="input-group date col-md-3">
                                            <select name="cat">
                                                <c:forEach items="${categorie}" var="c">
                                                    <option value="${c.codice}">${c.descrizione} (- ${c.percSconto}%)</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <%if (myname != null) {%>
                                        <div class="buy">
                                            <button type="submit" class="btn btn-primary btn-block">Compra</button>
                                        </div>
                                        <%} else {%>
                                        <div class="buy">
                                            <button disabled class="btn btn-primary btn-block">Effettua il login!</button>
                                        </div>
                                        <%}%>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${a.tipo=='base'}">
                <div id="news" style="margin-top: 80px; width: 80%;" align="center">
                    <div class="img" align="left">
                        <div class="row">
                            <div class="col-md-12">
                                <img src="${a.immagine}" width="100%">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <span class="img-title">${a.titolo}</span>
                                <div class="img-description">
                                    ${a.descrizione}
                                    <br/><br/>
                                    <b>Costo Ingresso:</b> &euro;${a.tariffaOrdinaria}
                                    <br/><br/>
                                    <b>Data:</b>
                                    <form action="./compra" method="post">
                                        <input type="hidden" name="id" value="${a.codice}" class="form-control">
                                        <div class="input-group date col-md-3" data-provide="datepicker">
                                            <input type="date" required name="data" class="form-control datepicker">
                                            <div class="input-group-addon">
                                                <span class="glyphicon glyphicon-th"></span>
                                            </div>
                                        </div>
                                        
                                        <div class="input-group date col-md-3">
                                            <select name="cat">
                                                <c:forEach items="${categorie}" var="c">
                                                    <option value="${c.codice}">${c.descrizione} (- ${c.percSconto}%)</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        
                                        <%if (myname != null) {%>
                                        <div class="buy">
                                            <button type="submit" class="btn btn-primary btn-block">Compra</button>
                                        </div>
                                        <%} else {%>
                                        <div class="buy">
                                            <button disabled class="btn btn-primary btn-block">Effettua il login!</button>
                                        </div>
                                        <%}%>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

        </c:forEach>

        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script>
                                                function comprato() {
                                                    alert("Il biglietto per l'evento scelto è stato ACQUISTATO!");
                                                    window.location = "./";
                                                }
                                                $('.datepicker').datepicker({
                                                    dateFormat: "yy-mm-dd"
                                                });
        </script>

    </body>
</html>
