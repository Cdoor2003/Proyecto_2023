<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 05-07-2023
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Menú Director</title>
    <link rel="stylesheet" href="estilos2.css">
    <link rel="shortcut icon" href="iconoHospital.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<ul class="opciones">
    <li class="opcion">
        <a href="agendarConsulta.jsp">
            <i class="fa-solid fa-user-tie"></i>
            <span>Agendar Consulta</span>
        </a>
    </li>
    <li class="opcion">
        <a href="eliminarConsulta.jsp">
            <i class="fa-solid fa-user"></i>
            <span>Eliminar Consulta</span>
        </a>
    </li>
    <li class="opcion">
        <a href="index.jsp">
            <i class="fa-solid fa-right-from-bracket"></i>
            <span>Salir</span>
        </a>
    </li>
</ul>
</body>
</html>