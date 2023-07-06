package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConsultaMedica;

import java.io.IOException;

@WebServlet(name = "EliminarConsultaServlet", value = "/eliminarConsulta")
public class EliminarConsultaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fecha = req.getParameter("fecha");
        String hora = req.getParameter("hora");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/eliminarConsulta.jsp");
        ConsultaMedica consultaMedica = new ConsultaMedica(fecha,hora,"");
        if (!fecha.isEmpty() && !hora.isEmpty()){
            if (consultaMedica.eliminarConsulta()){
                req.setAttribute("respuesta","Se ha eliminado correctamente la consulta");
            }else{
                req.setAttribute("repuesta","Hay un dato mal ingresado");
            }
        }else{
            req.setAttribute("respuesta","Hay campos vacios");
        }
        requestDispatcher.forward(req,resp);
    }
}
