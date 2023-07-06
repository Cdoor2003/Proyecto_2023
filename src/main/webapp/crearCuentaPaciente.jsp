<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 03-07-2023
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <title>Crear cuenta paciente</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div class="container">
    <h4>Crea tu cuenta</h4>
    <%
        String mensaje = (String) request.getAttribute("respuesta");
        if (mensaje != null && !mensaje.isEmpty()) {
    %>
    <h3><%= mensaje %></h3>
    <%
        }
    %>
    <form action="registroPaciente" method="post">
        <div class="iniciar">
            <input name="nombre" type="text" required>
            <label>Nombre</label>
        </div>
        <div class="iniciar">
            <input name="apellido" type="text" required>
            <label>Apellido</label>
        </div>
        <div class="iniciar">
            <input name="rut" type="text" maxlength="12" required>
            <label>Rut</label>
        </div>
        <div class="iniciar">
            <input name="correoElectronico" type="email" required>
            <label>Correo electronico</label>
        </div>
        <div class="iniciar">
            <input name="contraseña" type="password" required>
            <label>Contraseña</label>
        </div>
        <input type="submit" value="Crear cuenta">
        <div class="registrar">
            <a href="index.jsp">Salir</a>
        </div>
    </form>
</div>
</body>
</html>