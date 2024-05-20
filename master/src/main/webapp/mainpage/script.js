document.getElementById('apuesta-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const dinero = document.getElementById('dinero').value;
    const cuota = document.getElementById('cuota').value;
    const documento = document.getElementById('documento').value;

    const apuestaRow = document.createElement('tr');
    apuestaRow.innerHTML = `<td>${dinero}</td><td>${cuota}</td><td>${documento}</td>`;

    document.getElementById('apuestas-list').appendChild(apuestaRow);

    document.getElementById('apuesta-form').reset();
});