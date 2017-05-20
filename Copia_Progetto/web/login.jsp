<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <c:set var="title" value="Login" scope="request"/>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Form di login">
        <meta name="author" content="Luca Fadda">
        <LINK REL="stylesheet" TYPE="text/css" media="all" HREF="style.css">
    </head>
    <body>
        
        <!-- setto il valore login che verrà salvato sulla variabile title ripresa nell'header.jsp-->
        <h1 class="NerdBook">NerdBook - ${title}</h1>
        
        <div class="strutturaLogin">
            <c:if test="${errori == true}">
                <div id="errors">I dati inseriti non sono corretti!</div>
            </c:if>
            
            <form action="Login" method="post">
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
                
                <br/><input class="bottoneLogin" name="bottoneLogin" type="submit" value="Log In" />
                <input type="reset" class="bottoneReset"  value="reset"/>
                
            </div>
                
        </form>
        </div>
        <jsp:include page="footer.jsp"/>      
    </body>
</html>
