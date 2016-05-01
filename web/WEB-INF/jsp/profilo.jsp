<!DOCTYPE html>
<html >
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta charset="UTF-8">
        <title>Profilo Utente</title>
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
    <body background="./resources/img/background-buyment.jpg" style="background-attachment: fixed;">
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
                    <h1>Profilo</h1>
                    <c:forEach items="${cliente}" var="cl">
                        <form action="#" method="post" onsubmit="return testpass(this)">   	  
                            <div class="top-row">
                                <div class="field-wrap">
                                    <input type="text" placeholder="Nome" value="${cl.nome}" required autocomplete="off" />
                                </div>    
                                <div class="field-wrap">
                                    <input type="text" placeholder="Cognome" value="${cl.cognome}" required autocomplete="off"/>
                                </div>
                            </div>	  
                            <div class="field-wrap">
                                <input type="email" placeholder="E-mail" value="${cl.email}" required autocomplete="off"/>
                            </div>  
                            <div class="field-wrap">
                                <select>
                                    <option value="" disabled>Categoria</option>
                                    <c:forEach items="${categorie}" var="c">
                                        <c:set var="categoriaUser" scope="session" value="${cl.codiceCat.codice}"/>
                                        <c:set var="categ" scope="session" value="${c.codice}"/>
                                        <option <c:if test="${categoriaUser.equals(categ)}"><c:out value="selected"/></c:if> value="${c.codice}">${c.descrizione}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="field-wrap">
                                <input type="text" placeholder="Username" value="${cl.username}" required autocomplete="off"/>
                            </div>		  
                            <div class="field-wrap">
                                <input type="password" id="pass" placeholder="Password" required autocomplete="off"/>
                            </div>
                            <div class="field-wrap">
                                <input type="password" id="confPass" placeholder="Conferma Password" autocomplete="off"/>
                            </div>
                            <button type="submit" class="button button-block"/> conferma Modifica Dati Profilo</button>       
                        </form>
                    </c:forEach>
                </div>
                    <br/><hr style="border-top: 1px solid black"><br/>
                    <h1>Biglietti Acquistati</h1>
                    <table border="1px solid black">
                    <c:forEach items="${biglietti}" var="b">
                            <tr>
                                <td>${b.codiceAtt.titolo}</td>
                                <td>${b.codiceAtt.data}</td>
                                <td>&euro; ${b.codiceAtt.tariffaOrdinaria}</td>
                            </tr>
                    </c:forEach>
                    </table>
            </div><!-- tab-content -->  
        </div> 
        <!-- /form -->  
        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>

        <script>
            function testpass(modulo) {
                if (modulo.pass.value != modulo.confPass.value) {
                    alert("La password inserita non coincide con la prima!")
                    modulo.confPass.focus()
                    modulo.pass.select()
                    return false
                }
                return true
            }
        </script>

    </body>
</html>
