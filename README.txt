Para comenzar este es un proyecto basado en modulos con dos diferentes motores de bases de datos (MySQL y MongoDB), se realizó con módulos pensando en la escalabilidad del mismo, de modo que se pudiese actualizar con mas API's y deportes. 
Se manejan dos ETLs los cuales por un lado, extraen la información de las bases de datos y la tabulan y, por el otro lado, la base de datos de MongoDB tiene una llave foránea de MySQL Workbench.
Se trabaja con diferentes API's con el fin de tener información actualizada. Es un proyecto SpringBoot, usando Thymeleaf y Bootstrap para el front. 
El módulo de formulamodule realiza el cargue por parte de la API a base de datos y tambien funciona como un backend para el manejo de la misma.
El módulo datamodule funciona como gestor de los datos de la empresa, de clientes y de apuestas, y en caso de necesitar informes.
El módulo login funciona como gestor de usuario y contraseña de todos los usuarios, guardando su ID del modulo anterior para realizar un inicio de sesión exitoso.
El módulo Master funciona como front y también gestor de los 3 backs anteriores, siendo el funcionamiento completo del aplicativo.