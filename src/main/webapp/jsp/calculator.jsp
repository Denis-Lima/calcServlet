<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./resources/css/calculator.css" type="text/css" />
    <title>Calculadora</title>
  </head>
  <body>
    <div class="nav">
      <a class="primary" href="calculator.html">Calculadora</a>
      <a href="logs.html">Logs</a>
    </div>
    <div class="center">
      <h1>Calculadora</h1>
      <form>
        <div class="center">
          <div class="item">
            <p>Insira um número</p>
            <input type="number" name="op1" id="op1" placeholder="Número 1" />
          </div>
          <div class="item center">
            <select name="operacao" id="operacao">
              <option value="soma">Soma (+)</option>
              <option value="subtracao">Subtração (-)</option>
              <option value="tanh">Tangente hiberbólica tahn(x)</option>
            </select>
          </div>
          <div class="item n2">
            <p>Insira outro número</p>
            <input type="number" name="op2" id="op2" placeholder="Número 2" />
          </div>
          <div class="item">
            <input type="submit" name="submit" id="submit" value="Calcular" />
          </div>
          <div>
            <p id="resultado"></p>
          </div>
        </div>
      </form>
    </div>
  </body>
  <script src="./resources/js/calculator.js"></script>
</html>
