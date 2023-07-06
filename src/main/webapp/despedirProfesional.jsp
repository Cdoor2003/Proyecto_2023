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
    <title>Despedir funcionario</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div class="container">
    <h4>Despedir funcionario</h4>
    <%
        String mensaje = (String) request.getAttribute("respuesta");
        if (mensaje != null && !mensaje.isEmpty()) {
    %>
    <h3><%= mensaje %></h3>
    <%
        }
    %>
    <form action="despedirProfesional" method="post">
        <div class="iniciar">
            <input name="rutProfesional" type="text" maxlength="12" required>
            <label>Rut profesional</label>
        </div>
        <input type="submit" value="Despedir funcionario">
        <div class="registrar">
            <a href="menuDirector.jsp">Salir</a>
        </div>
    </form>
</div>
</body>
</html>