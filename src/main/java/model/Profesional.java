package model;

import model.data.DBConnector;
import model.data.dao.PacienteDAO;
import model.data.dao.ProfesionalDAO;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Profesional {
    private String nombre;
    private String apellido;
    private String rut;
    private int telefono;
    private String email;
    private String profesion;
    private String tipoContrato;
    private String contraseña;

    public Profesional(String nombre, String apellido, String rut, int telefono, String email, String profesion, String tipoContrato, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.profesion = profesion;
        this.tipoContrato = tipoContrato;
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

    public int getTelefono() {

        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public boolean registroProfesional(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new ProfesionalDAO().registrarProfesional(query,this);
    }
    public boolean despedirProfesional(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new ProfesionalDAO().despedirProfesional(query,this);
    }
    public Result obtenerProfesionales(){
        Connection connection = DBConnector.connection("cesfam","root","");
        DSLContext query = DSL.using(connection);
        return new ProfesionalDAO().obtenerProfesionales(query);
    }
}
