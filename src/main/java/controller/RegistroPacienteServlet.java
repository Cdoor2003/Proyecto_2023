package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paciente;

import java.io.IOException;
@WebServlet(name = "RegitroPacienteServlet", value = "/registroPaciente")
public class RegistroPacienteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String rut = req.getParameter("rut");
        String email = req.getParameter("correoElectronico");
        String contraseña = req.getParameter("contraseña");
        if(!nombre.isEmpty() && !apellido.isEmpty() && !rut.isEmpty() && !email.isEmpty() && !contraseña.isEmpty()){
            Paciente paciente = new Paciente(nombre,apellido,rut,email,contraseña);
            if (paciente.registroPaciente()){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/menuPaciente.jsp");
                requestDispatcher.forward(req,resp);
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/crearCuentaPaciente.jsp");
                req.setAttribute("respuesta","El rut ingresado ya ha sido registrado previamente");
                requestDispatcher.forward(req,resp);
            }
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/crearCuentaPaciente.jsp");
            req.setAttribute("respuesta","Hay campos sin completar");
            requestDispatcher.forward(req,resp);
        }
    }
}
