<!DOCTYPE html>
<html >
    <head>
        <%@include file="header.jsp"%>
        <title>Registrati</title>
        <link rel="stylesheet" href="./resources/css/style.css">
        <link rel="stylesheet" href="./resources/css/form.css">
    </head>
    <body background="./resources/img/background-form.jpg" style="background-attachment: fixed;">
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
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
        <div class="registrazione">  
            <div class="tab-content">
                <div id="signup">   
                    <h1>Registrazione</h1>          
                    <form action="./confermaRegistrazione" method="post">   	  
                        <div class="top-row">
                            <div class="field-wrap">
                                <input name="nome" type="text" placeholder="Nome" required autocomplete="off" />
                            </div>    
                            <div class="field-wrap">
                                <input name="cognome" type="text" placeholder="Cognome" required autocomplete="off"/>
                            </div>
                        </div>	  
                        <div class="field-wrap">
                            <input name="email" type="email" placeholder="E-mail" autocomplete="off"/>
                        </div>  
                        
                        <div class="field-wrap">
                            <input name="nu" type="text" placeholder="Username" required autocomplete="off"/>
                        </div>		  
                        <div class="field-wrap">
                            <input name="pass" type="password" placeholder="Password" required autocomplete="off"/>
                        </div>   
                        <button type="submit" class="button button-block"/>Registrati</button>       
                    </form>

                </div>            
            </div><!-- tab-content -->  
        </div> 
        <!-- /form -->
        <div id="footer">
            Copyright<sup>&copy;</sup> Musei Belli 2016
        </div>
    </body>
</html>
