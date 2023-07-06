<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 05-07-2023
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar Pacientes</title>
    <link rel="stylesheet" href="estilos3.css">
    <link rel="shortcut icon" href="iconoHospital.png">
</head>
<body>
<div class="container1">
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Rut</th>
            <th>Correo electronico</th>
        </tr>
        <c:forEach items="${pacientes}" var="paciente">
            <tr>
                <td>${paciente.getValue("Nombre")}</td>
                <td>${paciente.getValue("Apellido")}</td>
                <td>${paciente.getValue("Rut")}</td>
                <td>${paciente.getValue("email")}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
