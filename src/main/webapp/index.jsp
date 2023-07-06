<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Pagina oficial</title>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <link rel="shortcut icon" href="iconoHospital.png">
</head>
<body>
<header>
  <h1>Consultorio Pulmahue</h1>
</header>
<br>
<div class="container">
  <h4>Inicio de sesión</h4>
  <%
    String mensaje = (String) request.getAttribute("respuesta");
    if (mensaje != null && !mensaje.isEmpty()) {
  %>
  <h3><%= mensaje %></h3>
  <%
    }
  %>
  <form action="inicioSesion" method="post">
    <div class="iniciar">
      <input name="rut" type="text" maxlength="12" required>
      <label>RUT de usuario</label>
    </div>
    <div class="iniciar">
      <input name="contraseña" type="password" required>
      <label>Contraseña</label>
    </div>
    <input type="submit" value="Iniciar">
    <div class="registrar">
      Quiero hacer el <a href="crearCuentaPaciente.jsp">registro</a>
    </div>
  </form>
</div>
</body>
</html>