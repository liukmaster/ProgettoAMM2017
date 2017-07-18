<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Bacheca" scope="request"/>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Luca Fadda">
        <meta name="description" content="bacheca">
        <link rel="stylesheet" type="text/css" href="style1.css" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/js_nerdbook.js"></script>
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp"/>
            <jsp:include page="nav.jsp"/>  
            <div id="content">
                <jsp:include page="aside.jsp"/>
                <div class="Sezionepost">
                    <!-- Elenco post con controllo testo o immagine -->
                    <jsp:include page="nuovopost.jsp"/>
                    <c:forEach var="post" items="${posts}">
                        <div class="post">
                            <p class="autorepost">${post.getUtente().nome} ${post.getUtente().cognome}</p>
                            <form action="Bacheca" method="post">
                                <!-- ogni bottone cancellapost si riferisce a un post e prenderà come valore l'id di quel post -->
                                <div class="formcancellapost">
                                    <c:if test="${UtenteLoggato.getNomeCognome() == post.getUtente().getNomeCognome()}">
                                        <button type="submit" id="cancellapost" name="cancellapost" value="${post.getId()}">x</button>
                                    </c:if>
                                </div>
                            </form>
                            <p>${post.contenutoPost}</p>
                            <c:if test="${post.tipoDiPost == 'URL'}">
                                <img id="immagini" src="${post.immaginePost}"  alt="Post con foto">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div id="push"></div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
