<html>
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <link rel="stylesheet" href="./resources/css/style.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </head>
    <body>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="./resources/js/bootstrap.min.js"></script>
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
                            <li class="active"><a href="./">Home<span class="sr-only">(current)</span></a></li>
                            <li><a href="./attivita">Attivit&agrave;</a></li>
                            <li><a href="#">Gallery</a></li>
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
                            <li><a href="./logout">Logout</a></li>
                                <%}
                                %>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <img src="./resources/img/title-image.jpg" class="title-image"/>
        <div class="title-div">
            <h1 class="title">National Museum</h1>
        </div>
        <p style="color:red"><b>${msg}</b></p>
        <div id="news" align="center">
            <div class="row">
                
                <c:forEach items="${attivita}" var="a">
                    <div class="col-lg-4">
                        <div class="img" align="left">
                            <img src="${a.immagine}" width="100%">

                            <span class="img-title">${a.titolo}</span>
                            <div class="img-description">
                                <i style="float:right;">Tipo: ${a.tipo}</i>
                                <br/>
                                <div style="height: 100px; overflow: auto">
                                    ${a.descrizione}
                                </div>
                                <br/>
                                <b>Data:</b> ${a.data}
                                <div class="buy">
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
