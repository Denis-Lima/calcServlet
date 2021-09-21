<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
      <a href="calculadora">Calculadora</a>
      <a class="primary" href="logs">Logs</a>
    </div>
    <div class="vh center">
      <div class="logs">
        <h3>Filtrar logs:</h3>
          <input type="text" id="filtro" placeholder="Digite para filtrar" onkeyup="filtrar()" />
        </div>
      <div class="center">
        <table>
          <thead>
            <tr>
              <td>Data da operação</td>
              <td>Tipo de operação</td>
              <td>Operação</td>
              <td>Cálculo</td>
            </tr>
          </thead>
          <tbody id="tbody">
            <c:if test="${!logs.isEmpty()}">
              <c:forEach var="log" items="${logs}">
                <tr>
                  <fmt:parseDate value="${log.dataOperacao}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${parsedDate}" /></td>
                  <td><c:out value="${log.tipoOperacao.tipo}" /></td>
                  <td><c:out value="${log.operacao}" /></td>
                  <td><c:out value="${log.args}" /></td>
                </tr>
              </c:forEach>
            </c:if>
          </tbody>
        </table>
      </div>
    </div>
    <script src="./resources/js/filter.js"></script>
  </body>
</html>
