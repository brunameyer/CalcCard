<%-- 
    Document   : listCartao
    Created on : 14/10/2015, 19:24:36
    Author     : felipe_tubandt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Colocar no editCartao.jsp --%>             
        <form action="servlet">
            Descricao: <input type="text" name="txtDescricao" value="${bandeira.descricao}"><br />
            <input type="submit" value="Submeter" />
            
            
            
            
        </form>
    </body>
</html>
