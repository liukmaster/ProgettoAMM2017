<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="js/js_nerdbook.js"></script>
<aside>      
    <input type="text" class="search" name="search">
    <div id="Persone">
        <h2>Persone</h2>
    </div>
    <c:forEach var="amiciutente" items="${amiciutente}">
        <c:if test="${amiciutente.getId() != UtenteLoggato.getId()}">
            <div id="elencoamici">
                <p class="spaPersone"><a href="Bacheca?user=${amiciutente.id}">${amiciutente.nome} ${amiciutente.cognome}</a></p>
            </div>
        </c:if>
    </c:forEach>
    <!-- Elenco gruppi -->
    <div id="gruppi">
        <h2>Gruppi</h2>${messaggio}
    </div>
    <c:forEach var="gruppi" items="${gruppiutente}">
        <div id="elencogruppi">
            <p class="spaGruppi">${gruppi.nomeGruppo} ${[gruppi.fondatore.nome]}</p>
        </div>
        <c:forEach var="users" items="${gruppi.membri}">
            <div class="partecipanteGruppo">
                ${users.nome}             
            </div>
        </c:forEach>
    </c:forEach>
</aside>

