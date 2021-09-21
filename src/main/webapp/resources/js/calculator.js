const form = document.querySelector("form")
form.addEventListener("submit", event => {
    getResult(event)
})

function getResult(e) {
    e.preventDefault()
    const operacao = document.querySelector("#operacao").value
    const op1 = document.querySelector("#op1").value
    const op2 = document.querySelector("#op2").value

    if (verifyOperators(op1, op2, operacao)) {
        postResult(op1, op2, operacao)
    }
}

/**
 * Verifica se os operadores estão setados corretamente
 * @param {String} op1 Número 1
 * @param {String} op2 Número 2
 * @param {String} operacao Operação escolhida
 * @returns {Boolean} true se é válido para a requisição, false se inválido
 */
function verifyOperators(op1, op2, operacao) {
    // transcendental só precisa do op1
    if (operacao === 'tanh') {
        if (op1) {
          return true
        }
    } else {
        // elementar precisa do op1 e op2
        if (op1 && op2) {
            return true
        }
    }
    return false
}

function definirTipo(operacao) {
    if (operacao) {
        if (operacao === "tanh") {
            return "transcendental"
        } else {
            return "elementar"
        }
    }
    return ""
}

/**
 * Envia para o servidor a requisição
 * @param {String} op1 Número 1
 * @param {String} op2 Número 2
 * @param {String} operacao Operação escolhida
 */
function postResult(op1, op2, operacao) {
    const tipo = definirTipo(operacao)
    if (tipo) {
        const xhttp = new XMLHttpRequest()
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const result = document.querySelector("#resultado")
                result.innerHTML = `Resultado: ${this.responseText}`
                saveLog(op1, op2, operacao, this.responseText, tipo)
            }
        }
        let urlCalcService
        if (tipo == "elementar") {
            urlCalcService = `http://localhost:8083/calc/${tipo}?op1=${op1}&op2=${op2}&operacao=${operacao}`
        } else {
            urlCalcService = `http://localhost:8084/calc/${tipo}?op1=${op1}&op2=${op2}&operacao=${operacao}`
        }
        xhttp.open("POST", urlCalcService, true)
        xhttp.setRequestHeader('Access-Control-Allow-Origin', '*')
        xhttp.setRequestHeader('Content-Type', 'text/plain')
        xhttp.send()
    }
}

function saveLog(op1, op2, operacao, resultado, tipo) {
    const xhttp = new XMLHttpRequest()
    const urlLog = `logs?op1=${op1}&op2=${op2}&operacao=${operacao}&resultado=${resultado}&tipo=${tipo}`
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Log salvo!")
        }
    }

    xhttp.open("POST", urlLog)
    xhttp.send()
}

const operator = document.querySelector("#operacao")
const divOp2 = document.querySelector(".item.n2")

operator.addEventListener("change", function() {
    if (operator.value === "tanh") {
        divOp2.style.display = "none"
        divOp2.lastElementChild.value = ""
    } else {
        divOp2.style.display = ""
    }
})