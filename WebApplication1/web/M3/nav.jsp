<%-- 
    Document   : nav
    Created on : 27-apr-2017, 19.11.55
    Author     : fiest_000
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav>
    
    <ol>
        <li <c:if test="${page =='bacheca'}">class="active"</c:if>><a href="Bacheca">Bacheca Personale</a></li>
        <li <c:if test="${page =='profilo'}">class="active"</c:if>><a href="Profilo">Profilo Personale</a></li>
        
        
        
    </ol>
    
</nav>
