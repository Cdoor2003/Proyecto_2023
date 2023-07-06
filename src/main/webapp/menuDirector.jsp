<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 05-07-2023
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Menú Director</title>
    <link rel="stylesheet" href="estilos2.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<ul class="opciones">
    <li class="opcion">
        <a href="">
            <i class="fa-solid fa-user-tie"></i>
            <span>Mostrar Profesionales</span>
        </a>
    </li>
    <li class="opcion">
        <a href="">
            <i class="fa-solid fa-user"></i>
            <span>Mostrar Pacientes</span>
        </a>
    </li>
    <li class="opcion">
        <a href="crearCuentaProfesional.jsp">
            <i class="fa-sharp fa-solid fa-plus"></i>
            <span>Contratar Profesional</span>
        </a>
    </li>
    <li class="opcion">
        <a href="despedirProfesional.jsp">
            <i class="fa-solid fa-xmark"></i>
            <span>Despedir Profesional</span>
        </a>
    </li>
    <li class="opcion">
        <a href="eliminarPaciente.jsp">
            <i class="fa-solid fa-user-minus"></i>
            <span>Eliminar Paciente</span>
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
