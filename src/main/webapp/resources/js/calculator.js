const form = document.querySelector('form')
form.addEventListener('submit', event => {
    getResult(event)
})

function getResult(e) {
    e.preventDefault()
    const operacao = document.querySelector("#operacao").value
    const op1 = document.querySelector("#op1").value;
    const op2 = document.querySelector("#op2").value;

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
    // elementar precisa do op1 e op2
    if (['soma', 'subtracao'].includes(operacao)) {
        if (op1 && op2) {
            return true
        }
    // transcendental só precisa do op1
    } else {
        if (op1) {
            return true
        }
    }
    return false
}

/**
 * Envia para o servidor a requisição
 * @param {String} op1 Número 1
 * @param {String} op2 Número 2
 * @param {String} operacao Operação escolhida
 */
function postResult(op1, op2, operacao) {
    const xhttp = new XMLHttpRequest()
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const result = document.querySelector('#resultado')
            result.innerHTML = `Resultado: ${this.responseText}`
        }
    }
    xhttp.open("POST", `/calc?op1=${op1}&op2=${op2}&operacao=${operacao}`, true)
    xhttp.send()
}