<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="title" value="Descrizione" scope="request"/>
        <!-- inserisco le meta-informazioni -->
        <meta charset="UTF-8">
        <meta name="author" content="Luca Fadda">
        <meta name="keywords" content="Nerd Book Social">
        <LINK REL="stylesheet" TYPE="text/css" HREF="style1.css" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/js_nerdbook.js"></script>
        <title>Descrizione</title> 
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp"/>
            <nav>
                <div class="Sommario">
                    <div id="spazioVuoto"></div>
                    <div id="sommariolink">
                        <h2> Sommario link interni</h2>
                        <ul>
                            <li class="desc"><a href="#Descrizione" >Descrizione</a></li>
                            <li class="desc"><a href="#Iscrizione" >Iscrizione</a></li>
                            <li class="desc"><a href="#Pagamento" >Pagamento</a></li>
                        </ul>
                    </div>
                    <div id="descLogin">
                        <a href="Login"><p>Login</p></a>
                    </div>
                </div>
                
            </nav>
            <div id="content">
                <div class="d_i_p">
                    <div id="Descrizione" class="sub_d_i_p">
                        <h2>Descrizione del sito</h2>
                        <p>Benvenuto su NerdBook, il sito di incontri per Nerd.<br></p>                    
                    </div>
                    <div id="Iscrizione" class="sub_d_i_p">
                        <h2>Iscrizione</h2>
                        <p>Per qualsiasi dubbio tu abbia in qualche linguaggio, non aspettare,<br> contattaci e ti aiuteremo!
                        </p>
                    </div>
                    <div id="Pagamento" class="sub_d_i_p">
                        <h2>Pagamento</h2>
                        <p>
                            L'iscrizione al sito e' completamente gratuita. Non aspettare!<br/>
                            Iscriviti subito.
                        </p>
                    </div>
                </div>
            </div>
            <div id="push"></div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
