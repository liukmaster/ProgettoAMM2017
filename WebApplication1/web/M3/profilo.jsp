<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <c:set var="title" value="il tuo profilo" scope="request" />
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Luca Fadda">
        <meta name="description" content="inserimento dati profilo">
        <LINK REL="stylesheet" TYPE="text/css" HREF="style.css">
    </head>
    <body>
        
        <jsp:include page="header.jsp"/>
        <c:set var="page" value="profilo" scope="request"/>
        
        <nav class="profiloNav">               
            <ul>
                <li class="attivo"><a href="profilo.jsp">Profilo</a></li>
                <li><a href="bacheca.jsp">Bacheca</a></li>
            </ul>
        </nav>
        
        <div class="left">
                
                <input type="text" class="search" name="search">
                <h2>Persone</h2>
                <p class="spaPersone">Pinco Pallino</p>
                <p class="spaPersone">Riccardo Rossi</p>
                <p class="spaPersone">Mario Bianchi</p>
            
            
                <h2>Gruppi</h2>
                <p class="spaGruppi">Mongolfieristi</p>
                <p class="spaGruppi">Ritardatari</p>
            
        </div>
        <div class="strutturaProfilo">
            <div class="omino1">
                <span class="omino1"></span>
            </div>
               
        <form>
            
                
                <label class="pro" for="NomeUtente">Nome</label>
                <input type="text" name="NomeUtente" id="NomeUtente" required/>
                <br/><br/>
           
                <label class="pro" for="CognomeUtente">Cognome</label>
                <input type="text" name="cognome" id="CognomeUtente" required/>
                <br/><br/>
            
                <label class="pro" for="dataDiNascita">Nato il</label>
                <input type="date" name="dataDiNascita" id="dataDiNascita" required/>
                <br/><br/>
            
                <label class="pro" for="frasePresentazione">Frase di <br> presentazione</label>
                <textarea name="frasePresentazione" id="frasePresentazione"></textarea>
                <br/><br/>
                                   
                <label class="pro" for="password">Password</label>
                <input type="password" name="password" id="password" required/>
                <br/><br/>
            
                <label class="pro" for="confermaPassword">Conferma password</label>
                <input type="password" name="confermaPassword" id="confermaPassword" required/>
               
                <br/><br/><input type="submit" value="conferma"/>
              
        </form>    
          </div>    
        <footer>
            <div id="contatti" class="contatti">
                    <h2>CONTATTI</h2>
                <p>Luca Fadda Cagliari liukfadd@hotmail.it - Tel: 3481415700</p>
            </div>
            <div id="chisono" class="chisono">
                    <h2>CHI SONO</h2>
                    <p>Sono Luca e questo e' il mio sito. Sono un laureando</p>
            </div>
            <div id="argomenti" class="argomenti">
                <h2>ARGOMENTI</h2>
                <p>
                 Linguaggi informatici, in particolare Java 
                </p>
            </div>   
        </footer>
    </body>
</html>
