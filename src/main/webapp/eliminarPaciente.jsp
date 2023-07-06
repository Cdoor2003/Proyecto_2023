<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 03-07-2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Eliminar paciente</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <link rel="shortcut icon" href="iconoHospital.png">
</head>
<body>
<div class="container">
    <h4>Eliminar paciente</h4>
    <%
        String mensaje = (String) request.getAttribute("respuesta");
        if (mensaje != null && !mensaje.isEmpty()) {
    %>
    <h3><%= mensaje %></h3>
    <%
        }
    %>
    <form action="eliminarPaciente" method="post">
        <div class="iniciar">
            <input name="rutPaciente" type="text" maxlength="12" required>
            <label>Rut paciente</label>
        </div>
        <input type="submit" value="Eliminar paciente">
        <div class="registrar">
            <a href="menuDirector.jsp">Salir</a>
        </div>
    </form>
</div>
</body>
</html>