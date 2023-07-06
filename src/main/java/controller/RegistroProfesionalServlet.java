package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Profesional;

import java.io.IOException;

@WebServlet(name = "RegistroProfesionalServlet", value = "/registroProfesional")
public class RegistroProfesionalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String rut = req.getParameter("rut");
        int telefono = Integer.parseInt(req.getParameter("telefono"));
        String email = req.getParameter("correoElectronico");
        String profesion = req.getParameter("profesion");
        String tipoContrato = req.getParameter("tipoContrato");
        String contraseña = req.getParameter("contraseña");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/crearCuentaProfesional.jsp");
        if(!nombre.isEmpty() && !apellido.isEmpty() && !rut.isEmpty() && telefono!=0 && !email.isEmpty() && !profesion.isEmpty() && !tipoContrato.isEmpty() && !contraseña.isEmpty()){
            Profesional profesional = new Profesional(nombre,apellido,rut,telefono,email,profesion,tipoContrato,contraseña);
            if(profesional.registroProfesional()){
                req.setAttribute("respuesta","El registro se completo correctamente");
            }else{
                req.setAttribute("respuesta","El rut ingresado ya ha sido ingresado previamente");
            }
        }else{
            req.setAttribute("respuesta","Hay campos sin completar");
        }
        requestDispatcher.forward(req,resp);
    }
}
