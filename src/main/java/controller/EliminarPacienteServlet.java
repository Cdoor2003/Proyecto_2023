package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paciente;
import model.Profesional;

import java.io.IOException;

@WebServlet(name = "EliminarPacienteServlet", value = "/eliminarPaciente")
public class EliminarPacienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rutPaciente = req.getParameter("rutPaciente");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/eliminarPaciente.jsp");
        Paciente paciente = new Paciente("","",rutPaciente,"","");
        if (!rutPaciente.isEmpty()){
            if (paciente.eliminarPaciente()){
                req.setAttribute("respuesta","Se ha eliminado correctamente al paciente");
            }else{
                req.setAttribute("repuesta","El rut ingresado no es valido");
            }
        }else{
            req.setAttribute("respuesta","No se ha ingresado ningun rut");
        }
        requestDispatcher.forward(req,resp);
    }
}
