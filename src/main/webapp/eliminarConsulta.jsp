<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 05-07-2023
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
  <title>Agendar consulta</title>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <link rel="shortcut icon" href="iconoHospital.png">
</head>
<body>
<div class="container">
  <h4>Agendar Consulta</h4>
  <%
    String mensaje = (String) request.getAttribute("respuesta");
    if (mensaje != null && !mensaje.isEmpty()) {
  %>
  <h3><%= mensaje %></h3>
  <%
    }
  %>
  <form action="eliminarConsulta" method="post">
    <div class="iniciar">
      <input name="fecha" type="date" required>
      <label>Fecha</label>
    </div>
    <div class="iniciar">
      <input name="hora" type="time" required>
      <label>Hora</label>
    </div>
    <input type="submit" value="eliminar">
    <div class="registrar">
      <a href="menuPaciente.jsp">Salir</a>
    </div>
  </form>
</div>
</body>
</html>