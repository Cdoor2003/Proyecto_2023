package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.data.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "InicioSesionServlet", value = "/inicioSesion")
public class InicioSesionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rutDirector = null;
        String rutProfesional = null;
        String rutPaciente = null;
        String contraseñaDirector = null;
        String contraseñaProfesional = null;
        String contraseñaPaciente = null;
        Connection connection = DBConnector.connection("cesfam","root","");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from director where rut = ?");
            preparedStatement.setString(1,req.getParameter("rut"));
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                rutDirector = set.getString(3);
                contraseñaDirector = set.getString(4);
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from profesional where rut = ?");
            preparedStatement1.setString(1,req.getParameter("rut"));
            ResultSet set1 = preparedStatement1.executeQuery();
            while (set1.next()){
                rutProfesional = set1.getString(3);
                contraseñaProfesional = set1.getString(7);
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement("select * from paciente where rut = ?");
            preparedStatement2.setString(1,req.getParameter("rut"));
            ResultSet set2 = preparedStatement2.executeQuery();
            while (set2.next()){
                rutPaciente = set2.getString(3);
                contraseñaPaciente = set2.getString(5);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(rutDirector !=null){
            if(contraseñaDirector.equals(req.getParameter("contraseña"))){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/menuDirector.jsp");
                requestDispatcher.forward(req,resp);
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                req.setAttribute("respuesta","Contraseña mal ingresada");
                requestDispatcher.forward(req,resp);
            }
        } else if (rutProfesional != null) {
            if(contraseñaProfesional.equals(req.getParameter("contraseña"))){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/menuProfesional.jsp");
                requestDispatcher.forward(req,resp);
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                req.setAttribute("respuesta","Contraseña mal ingresada");
                requestDispatcher.forward(req,resp);
            }
        } else if (rutPaciente != null) {
            if(contraseñaPaciente.equals(req.getParameter("contraseña"))){
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/menuPaciente.jsp");
                requestDispatcher.forward(req,resp);
            }else{
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                req.setAttribute("respuesta","Contraseña mal ingresada");
                requestDispatcher.forward(req,resp);
            }
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            req.setAttribute("respuesta","El rut ingresado no existe");
            requestDispatcher.forward(req,resp);
        }
    }
}
