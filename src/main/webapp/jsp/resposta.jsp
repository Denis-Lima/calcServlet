<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP que imprime seu nome</title>
    </head>
    <body>
        <c:forEach items="${logs}" var="log">
            <p>${log.id} ${log.dataOperacao} ${log.tipoOperacao.id} ${log.tipoOperacao.tipo}</p>
        </c:forEach>
    </body>
</html>