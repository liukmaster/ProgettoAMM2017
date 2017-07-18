
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="nuovopost">
    <form action="Bacheca" method="post">
        <div>
            <label id="scrittapubblicapost">Pubblica Post</label>
            <div class="pronuovopost">
                <textarea name="postditesto" id="textPost" placeholder="Contenuto..."></textarea>
            </div>
            <div class="pronuovopost">
                <label id="imgfile">File d'immagine</label>
                <input name="postimmagine" type="url" id="imgPost">
            </div>
        </div>
        <button type="submit" id="pubblicapost" name="pubblicapost" value="si">Pubblica</button>
        <c:choose>
            <c:when test="${postpubblicatoconsuccesso == true}">
                post pubblicato
            </c:when>
            <c:otherwise>
                ${postvuoto} 
            </c:otherwise>
        </c:choose>
    </form>     
</div>