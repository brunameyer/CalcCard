<%-- 
    Document   : listCartao
    Created on : 14/10/2015, 19:24:36
    Author     : felipe_tubandt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${lista}" var="umCartao">
            ${umCartao.descricao} - <a href="servlet?acao=excluirCartao&id=${umCartao.id}"> Excluir</a> - 
            <a href="servlet?acao=editarCartao&id=${umCartao.id}">Editar</a>
            <br/>            
        </c:forEach>
            
            <a href="servlet?acao=novoCartao">Novo</a>
        
    </body>
</html>
