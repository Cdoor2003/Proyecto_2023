package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paciente;

import java.io.IOException;

@WebServlet(name = "MostrarPacientesServlet", value = "/mostrarPacientes")
public class MostrarPacientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/mostrarPacientes.jsp");
        Paciente paciente = new Paciente("","","","","");
        req.setAttribute("pacientes",paciente.obtenerPacientes());
        requestDispatcher.forward(req,resp);
    }
}
