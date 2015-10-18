<%-- 
    Document   : editCartao
    Created on : 17/10/2015
    Author     : bruna
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="servlet" >          
            <%-- Bandeira: <input type="text" name="txtBandeira" value="${Cartao.bandeira}"><br /> --%>
            Taxa Crédito: <input type="text" name="txtTaxaCredito" value="${Cartao.taxaCredito}"><br />
            Taxa Débito: <input type="text" name="txtTaxaDebito" value="${Cartao.taxaDebito}"><br />
            
            <input type="hidden" name="id" value="${Cartao.idCartao}" />
            <input type="hidden" name="acao" value="salvarCartao" />
            <input type="submit" value="Submeter" />


        </form>

    </body>
</html>
