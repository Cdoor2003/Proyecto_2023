<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 05-07-2023
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
        <title>Mostrar Profesionales</title>
        <link rel="stylesheet" href="estilos3.css">
        <link rel="shortcut icon" href="iconoHospital.png">
</head>
<body>
<div class="container1">
        <table>
                <thead>
                <tr>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Rut</th>
                        <th>Profesion</th>
                        <th>Tipo contrato</th>
                        <th>Correo electronico</th>
                        <th>Telefono</th>
                </tr>
                </thead>
                <c:forEach items="${profesionales}" var="profesional">
                        <tbody>
                        <tr>
                                <td>${profesional.getValue("Nombre")}</td>
                                <td>${profesional.getValue("Apellido")}</td>
                                <td>${profesional.getValue("Rut")}</td>
                                <td>${profesional.getValue("Profesion")}</td>
                                <td>${profesional.getValue("TipoContrato")}</td>
                                <td>${profesional.getValue("email")}</td>
                                <td>${profesional.getValue("telefono")}</td>
                        </tr>
                        </tbody>
                </c:forEach>
        </table>
</div>
</body>
</html>
