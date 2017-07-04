<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Profilo" scope="request"/>
    <head>
        <meta charset="UTF-8">
        <meta name="author" content="Luca Fadda">
        <meta name="description" content="inserimento dati profilo">
        <LINK REL="stylesheet" TYPE="text/css" HREF="style1.css" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/js_nerdbook.js"></script>
    </head>
    <body>
        <div id="container">
            <jsp:include page="header.jsp"/>
            <jsp:include page="nav.jsp"/>  
            <div id="content">
                <jsp:include page="aside.jsp"/>
                <div class="strutturaProfilo">
                    <form action="Profilo" method="post" name="ciao">
                        <div class="pro">                        
                            <label for="NomeUtente">Nome</label>
                            <input type="text" name="nomeUtente" id="NomeUtente" value="${UtenteLoggato.getNome()}"  readonly="" required/>
                        </div>
                        <div class="pro">                        
                            <label for="CognomeUtente">Cognome</label>
                            <input type="text" name="cognomeUtente" id="CognomeUtente" value="${UtenteLoggato.cognome}" required/>
                        </div>
                        <div class="pro">                        
                            <label for="dataDiNascita">Nato il </label>
                            <input type="text" name="dataDiNascita" id="dataDiNascita" value="${UtenteLoggato.dataDiNascita}" required/>
                        </div>
                        <div class="pro">                        
                            <label for="frasePresentazione">Frase di presentazione</label>
                            <textarea name="frasePresentazione" id="frasePresentazione"></textarea>
                        </div>
                        <div class="pro">                        
                            <label for="password">Password</label>
                            <input type="password" name="password"  value="${UtenteLoggato.password}" id="password" required/>
                        </div>
                        <div  class="pro">                        
                            <label for="confermaPassword">Conferma password</label>
                            <input type="password" name="confermaPassword" value="${UtenteLoggato.password}" id="confermaPassword" required/>
                        </div>
                        <input class="bottoneprofilo" id="confermaDati" type="submit" name="confermaDati" value="conferma"/>
                    </form>  
                        ${risultatoProfilo}
                </div>
            </div>
            <div id="push"></div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
