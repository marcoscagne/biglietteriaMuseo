<!DOCTYPE html>
<html >
    <head>
        <%@include file="header.jsp"%>
        <title>Il tuo profilo</title>
        <link rel="stylesheet" href="./resources/css/style.css">
        <link rel="stylesheet" href="./resources/css/form.css">
    </head>
    <body background="./resources/img/background-buyment.jpg" style="background-attachment: fixed;">
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
            <%if(!myname.equals("root")){%>
                <div class="tab-content">
                    <div id="signup">   
                        <h1>Profilo</h1>
                        <c:forEach items="${cliente}" var="cl">
                            <form action="./modificaProfilo" method="post" onsubmit="return testpass(this)">   	  
                                <div class="top-row">
                                    <div class="field-wrap">
                                        <input type="text" name="nome" placeholder="Nome" value="${cl.nome}" required autocomplete="off" />
                                    </div>    
                                    <div class="field-wrap">
                                        <input type="text" name="cognome" placeholder="Cognome" value="${cl.cognome}" required autocomplete="off"/>
                                    </div>
                                </div>	  
                                <div class="field-wrap">
                                    <input type="email" name="email" placeholder="E-mail" value="${cl.email}" required autocomplete="off"/>
                                </div>  
                                <div class="field-wrap">
                                    <select name="cat" class="cat">
                                        <option value="" disabled>Categoria</option>
                                        <c:forEach items="${categorie}" var="c">
                                            <c:set var="categoriaUser" scope="session" value="${cl.codiceCat.codice}"/>
                                            <c:set var="categ" scope="session" value="${c.codice}"/>
                                            <option <c:if test="${categoriaUser.equals(categ)}"><c:out value="selected"/></c:if> value="${c.codice}">${c.descrizione}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="field-wrap">
                                    <input type="text" name="nu" placeholder="Username" value="${cl.username}" required autocomplete="off"/>
                                </div>		  
                                <div class="field-wrap">
                                    <input type="password" name="pass" id="pass" placeholder="Password" required autocomplete="off"/>
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
                    <table class="listino" align="center">
                        <tr>
                            <td><b>Evento</b></td>
                            <td><b>Data</b></td>
                            <td><b>Prezzo</b></td>
                        </tr>
                    <c:forEach items="${biglietti}" var="b">
                            <tr>
                                <td>${b.codiceAtt.titolo}</td>
                                <td>${b.codiceAtt.data}</td>
                                <td>&euro; ${b.codiceAtt.tariffaOrdinaria}</td>
                            </tr>
                    </c:forEach>
                    </table>
                </div><!-- tab-content -->
            <%}else{%>
                <div class="tab-content">
                    <div id="signup">   
                        <h1>Administrator</h1>
                        
                    </div>
                </div>
            <%}%>
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
