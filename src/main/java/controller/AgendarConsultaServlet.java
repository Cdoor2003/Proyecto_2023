package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ConsultaMedica;
import model.data.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AgendarConsultaServlet", value = "/agendarConsulta")
public class AgendarConsultaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fecha = req.getParameter("fecha");
        String hora = req.getParameter("hora");
        String rutProfesional = req.getParameter("rutProfesional");
        String rutExtraido = null;
        if (!fecha.isEmpty() && !hora.isEmpty()){
            Connection connection = DBConnector.connection("cesfam","root","");
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from profesional where rut = ?");
                preparedStatement.setString(1,req.getParameter("rutProfesional"));
                ResultSet set = preparedStatement.executeQuery();
                while (set.next()){
                    rutExtraido = set.getString(3);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(rutExtraido != null){
                ConsultaMedica consultaMedica = new ConsultaMedica(fecha,hora,rutProfesional);
                if (consultaMedica.agendarConsulta()){
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/agendarConsulta.jsp");
                    req.setAttribute("respuesta","Se ha agendado correctamente la consulta");
                    requestDispatcher.forward(req,resp);
                }else{
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/agendarConsulta.jsp");
                    req.setAttribute("respuesta","Hay algun dato ingresado incorrectamente");
                    requestDispatcher.forward(req,resp);
                }
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/agendarConsulta.jsp");
                req.setAttribute("respuesta","El rut del profesional no existe");
                requestDispatcher.forward(req,resp);
            }
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/agendarConsulta.jsp");
            req.setAttribute("respuesta","Hay campos sin completar");
            requestDispatcher.forward(req,resp);
        }

    }
}
