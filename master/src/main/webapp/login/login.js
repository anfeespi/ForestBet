const registerButton = document.querySelector('.register-btn');

// Agregar un evento de clic al botón de registro
registerButton.addEventListener('click', function() {
    // Redirigir a la página register.html
    window.location.href = 'register.html';
});

// Obtener el botón de inicio de sesión
const loginButton = document.querySelector('.loginButton');

// Agregar un evento de clic al botón de inicio de sesión
loginButton.addEventListener('click', function() {
    window.location.href = 'mainpage.html';
});