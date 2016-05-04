<html>
    <head>
        <%@include file="header.jsp"%>
        <title>Attività proposte</title>
        <link rel="stylesheet" href="./resources/css/style.css">
    </head>
    <body style="background:url(./resources/img/background-activities.jpg) fixed white">
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
                            <li class="active"><a href="#">Attivit&agrave;</a></li>
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
        <div id="news" style="margin-top: 80px;" align="center">	
            <div class="row attivita">
                <c:forEach items="${attivita}" var="a">
                    <div class="col-md-6">
                        <img src="${a.immagine}" width="100%">
                        <div class="img" align="left">
                            <span class="img-title">${a.titolo}</span>
                            <div class="img-description">
                                <div style="height: 100px; overflow: auto">
                                    ${a.descrizione}
                                </div>
                                <div class="continua">
                                    <a href="./dettaglio?id=${a.codice}" class="btn btn-primary btn-block">Dettagli</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>
    </body>
</html>
