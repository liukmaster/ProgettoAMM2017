<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <c:set var="title" value="Login" scope="request"/>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Form di login">
        <meta name="author" content="Luca Fadda">
        <LINK REL="stylesheet" TYPE="text/css" HREF="style1.css" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="container">
            <!-- setto il valore login che verrà salvato sulla variabile title ripresa nell'header.jsp-->
            <jsp:include page="header.jsp"/>
            <div id="content">
                <div class="strutturaLogin">
                    <form action="Login" method="post">
                        
                            <div id="memberLogin">
                                Member Login
                            </div>
                            <div class="UsernamePasswordLogin">
                                <div class="in">                                   
                                    <input type="text" name="username" id="userName" placeholder="username" required/>
                                </div>
                                <div class="in">
                                    <input type="password" name="password" id="userPass" placeholder="password" required/>
                                </div>
                            </div>
                            <div id="bottoni">
                                <input id="bottonelogin" name="bottoneLogin" type="submit" value="Log In"/>
                                <input name="registrazione" type="reset" value="reset"/>
                            </div>                        
                    </form>
                    <c:if test="${errori == true}">
                        <div id="errors">I dati inseriti non sono corretti!</div>
                    </c:if>
                </div>     
            </div>
            <div id="push"></div>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>
