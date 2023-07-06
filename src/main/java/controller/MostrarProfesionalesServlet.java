package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Profesional;

import java.io.IOException;

@WebServlet(name = "MostrarProfesionalesServlet", value = "/mostrarProfesionales")
public class MostrarProfesionalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/mostrarProfesionales.jsp");
        Profesional profesional= new Profesional("","","",0,"","","","");
        req.setAttribute("profesionales",profesional.obtenerProfesionales());
        requestDispatcher.forward(req,resp);
    }
}
