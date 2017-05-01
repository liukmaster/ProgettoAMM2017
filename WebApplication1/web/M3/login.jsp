<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        
        <meta charset="UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Form di login">
        <meta name="author" content="Luca Fadda">
        
        <LINK REL="stylesheet" TYPE="text/css" media="all" HREF="style.css">
    
    </head>
    
    
    <body>
        <!-- setto il valore login che verrà salvato sulla variabile title ripresa nell'header.jsp-->
        <c:set var="title" value="Login" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        
        
        <div class="strutturaLogin">
            
            <c:if test="${errori == true}">
                <div id="invaidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
            
            <form action="Login.java" method="post">
            <div id="Login">
                <p class="memberLogin">Member Login</p>
                
                <div>
                    <label for="userName" class="lo">Username<br/></label>
                    <input type="text" name="username" class="username" id="userName" placeholder="username" required/>
                    <br/><br/>
                </div>
                <div> 
                    <label for="password" class="lo">Password<br/></label>
                    <input type="password" name="password" class="password" id="userPass" placeholder="password" required/>
                    <br/>
                </div>
                
                <br/><input class="bottoneLogin" type="submit" value="Log In" />
                <input type="reset" class="bottoneReset" value="reset"/>
                
            </div>
                
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
