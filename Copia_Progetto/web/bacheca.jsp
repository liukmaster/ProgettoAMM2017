<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Luca Fadda">

        <LINK REL="stylesheet" TYPE="text/css" HREF="style.css">
    </head>
    <body>

        <header>
            <h1>NerdBook</h1>
        </header> 
        <jsp:include page="nav.jsp"/>
        <nav class="BachecaNav">

            <ul>

                <li><a href="profilo.jsp">Profilo</a></li>
                <li class="attivo"><a href="bacheca.jsp">Bacheca</a></li>

            </ul>
            <div class="utenteLoggato">
                <p>${utente.nome} ${utente.cognome}</p>
            </div>


            <div class="logout">
                <!-- se il paramentro user è vuoto vuol dire che sono loggato (es. luca), mentre se ha un valore
                vuol dire che io(Luca) sto cercando di visualizzare la bacheca di un'altra persona-->  
                <c:if test="${empty param.user}">
                    <!-- decisione prende il valore logout, faccio il controllo nella servlet-->
                    <p><a href="Login?decisione=logout">Logout</a></p>
                </c:if>
            </div>
        </nav>

        <div class="left">

            <input type="text" class="search" name="search">
            <h2>Persone</h2>
            <c:forEach var="amiciutente" items="${amiciutente}">
                <p class="spaPersone">${amiciutente.nome} ${amiciutente.cognome}</p>
            </c:forEach>
            
            <!-- Elenco gruppi -->
            <h2>Gruppi</h2>
            <c:forEach var="gruppi" items="${gruppiutente}">
                <p class="spaGruppi">${gruppi.nomeGruppo}</p>
            </c:forEach>
        </div>

        <!-- Elenco post -->
        <c:forEach var="post" items="${posts}">
            <div class="post">
                <c:if test="${post.tipoDiPost == 'TEXT'}">
                    <p>${post.contenutoPost}</p>
                </c:if>
                <c:if test="${post.tipoDiPost == 'IMAGE'}">
                    <img alt="Post con foto" src="${post.contenutoPost}">
                </c:if>
            </div>
        </c:forEach>

        <!--
    <div class="strutturaBacheca">
    
        <div id="postNormale" class="postNormale">
             <p class="a">Post Normale</p>
             <p class="autorePost"> luca giurato<p>
            
                
                
        </div>
        <div id="postImmagine" class="postImmagine">
            <p class="a">Post con immagine</p>
            <p class="autorePost">Luca Giurato</p>
            <p>Un esempio di codice scritto in Java</p>
        <!-- <img title="computer" src="immagini/Jnodo.jpg" alt="immagine non trovata" height="350" width="350"> 
     </div>
     <div id="postURL" class="postURL">
          <p class="a">Post con URL</p>
         <p class="autorePost">Luca Giurato</p>
         <p>Questo e' il link che riporta a Wikipedia per il linguaggio Java</p>
         <a class="linkJava" href="https://it.wikipedia.org/wiki/Java_(linguaggio_di_programmazione)" target="_blank">JavaWiki</a>
     </div>
 </div>
        -->
        <jsp:include page="footer.jsp"/>
    </body>
</html>
