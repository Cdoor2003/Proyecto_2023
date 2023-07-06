package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Profesional;

import java.io.IOException;

@WebServlet(name = "DespedirProfesionalServlet", value = "/despedirProfesional")
public class DespedirProfesionalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rutProfesional = req.getParameter("rutProfesional");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/despedirProfesional.jsp");
        Profesional profesional = new Profesional("","",rutProfesional,Integer.parseInt(""),"","","","");
        if (!rutProfesional.isEmpty()){
            if (profesional.despedirProfesional()){
                req.setAttribute("respuesta","Se ha despedido correctamente al profesional");
            }else{
                req.setAttribute("repuesta","El rut ingresado no es valido");
            }
        }else{
            req.setAttribute("respuesta","No se ha ingresado ningun rut");
        }
        requestDispatcher.forward(req,resp);
    }
}
