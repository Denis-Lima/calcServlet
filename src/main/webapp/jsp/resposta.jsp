<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP que imprime seu nome</title>
    </head>
    <body>
        <p>
            Seu nome é:
            <span>
                <%=request.getAttribute("nomeCompleto")%>
            </span>
        </p>
    </body>
</html>