package model;

import model.data.DBConnector;
import model.data.dao.ConsultaDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.Time;
import java.util.Date;

public class ConsultaMedica {
    private String fecha;
    private String hora;
    private String rutProfesional;

    public ConsultaMedica(String fecha, String hora, String rutProfesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.rutProfesional = rutProfesional;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRutProfesional() {
        return rutProfesional;
    }

    public void setRutProfesional(String rutProfesional) {
        this.rutProfesional = rutProfesional;
    }
    public boolean agendarConsulta(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new ConsultaDAO().agendarConsulta(query,this);
    }
    public boolean eliminarConsulta(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new ConsultaDAO().eliminarConsulta(query,this);
    }
}
