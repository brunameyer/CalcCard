<%-- 
    Document   : listBandeira
    Created on : 09/10/2015, 20:45:43
    Author     : VDISOO0219
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
        <c:forEach items="${lista}" var="umaBandeira">
            
            ${umaBandeira.descricao} - <a href ></a>
            
                   
    </body>
    
</html>
