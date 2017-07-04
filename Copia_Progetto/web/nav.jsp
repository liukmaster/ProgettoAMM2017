<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav>
    <div id="spazioVuoto"></div>
    <div class="bachecaProfiloScritte">
        <!-- setto la pagina attiva, cosi poi faccio un controllo sul nav -->
        <c:set var="pagina" value="bacheca" scope="request"/> 
        <div id="BachecaPersonale" <c:if test="${title == 'Bacheca'}">class="active"</c:if>>
                <a href="Bacheca">Bacheca Personale</a>
            </div>
            <div id="ProfiloPersonale" <c:if test="${title == 'Profilo'}">class="active"</c:if>>
                <a href="Profilo">Profilo Personale</a>
            </div>
        </div>
        <div id="spazioLogin"> 
            <div class="utenteLoggato"> 
                <a href="Bacheca?user=${UtenteLoggato.id}">${UtenteLoggato.nome} ${UtenteLoggato.cognome}</a> 
        </div>
        <div class="logout">
            <c:if test="${UtenteLoggato != null}">
                <!-- decisione prende il valore logout, faccio il controllo nella servlet-->
                <a href="Login?decisione=logout">Logout</a>
            </c:if>
        </div>
    </div>
</nav>

