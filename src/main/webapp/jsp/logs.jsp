<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./resources/css/logs.css" />

    <title>Logs</title>
  </head>
  <body>
    <div class="nav">
      <a href="calculator.html">Calculadora</a>
      <a class="primary" href="logs.html">Logs</a>
    </div>
    <div class="vh center">
      <div class="center">
        <table>
          <thead>
            <tr>
              <td>Data da operação</td>
              <td>Tipo de operação</td>
              <td>Operação</td>
              <td>Argumento 1</td>
              <td>Argumento 2</td>
            </tr>
          </thead>
          <tbody>
            <c:if test="${!logs.isEmpty()}">
              <c:forEach var="log" items="${logs}">
                <tr>
                  <td><c:out value="${log.dataOperacao}" /></td>
                  <td><c:out value="${log.tipoOperacao.tipo}" /></td>
                  <td><c:out value="${log.operacao}" /></td>
                  <td><c:out value="${log.argumento1}" /></td>
                  <td><c:out value="${log.argumento2}" /></td>
                </tr>
              </c:forEach>
            </c:if>
          </tbody>
        </table>
      </div>
    </div>
  </body>
</html>
