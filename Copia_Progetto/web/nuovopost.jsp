
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<div class="nuovopost">
    <form action="Bacheca" method="post">
        <div>
            <div id="scrittapubblicapost">Pubblica Post</div>
            <div class="pro">              
                <label for="textPost">Contenuto</label>
                <textarea name="postditesto" id="textPost"></textarea>
            </div>
            <div class="pro">
                <label for="imgPost">File d'immagine</label>
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