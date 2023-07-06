package model;

import model.data.DBConnector;
import model.data.dao.PacienteDAO;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Paciente {
    private String nombre;
    private String apellido;
    private String rut;
    private String email;
    private String contraseña;

    public Paciente(String nombre, String apellido, String rut, String email, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public boolean registroPaciente(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new PacienteDAO().registrarPaciente(query,this);
    }
    public boolean eliminarPaciente(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new PacienteDAO().eliminarPaciente(query,this);
    }
    public Result obtenerPacientes(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new PacienteDAO().obtenerPacientes(query);
    }
}
