function filtrar() {

    const input = document.getElementById("filtro")
    const filtroUsuario = input.value.toUpperCase()
    const tBody = document.getElementById("tbody")
    const tRows = tBody.getElementsByTagName("tr")

    for (let i = 0; i < tRows.length; i++) {
        const tRow = tRows[i]
        const datasRow = tRow.getElementsByTagName('td')
        for (let j = 0; j < datasRow.length; j++) {

            const tData = datasRow[j]
            if (tData) {
                txtValue = tData.textContent || tData.innerText
                if (txtValue.toUpperCase().indexOf(filtroUsuario) > -1) {
                    tRow.style.display = ""
                    break
                } else {
                    tRow.style.display = "none"
                }
            }
        }
    }
}