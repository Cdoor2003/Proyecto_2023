package model.data.dao;

import model.Paciente;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.table;

public class PacienteDAO {
    public boolean registrarPaciente(DSLContext query, Paciente paciente){
        String nombre = paciente.getNombre();
        String apellido = paciente.getApellido();
        String rut = paciente.getRut();
        String email = paciente.getEmail();
        String contraseña = paciente.getContraseña();
        Table pacienteTabla = table(DSL.name("paciente"));
        Field[] columnas = pacienteTabla.fields(
                "Nombre",
                "Apellido",
                "Rut",
                "email",
                "Contraseña"
        );
        int results = 0;
        try {
            results = query.insertInto(pacienteTabla,columnas[0],columnas[1],columnas[2],columnas[3],columnas[4])
                    .values(nombre,apellido,rut,email,contraseña)
                    .execute();
        }catch (Exception e){

        }
        return results==1;
    }
    public boolean eliminarPaciente(DSLContext query,Paciente paciente){
        String rutExtraido = paciente.getRut();
        int result = 0;
        try {
            result = query.deleteFrom(
                            DSL.table("paciente"))
                    .where(DSL.field("Rut").eq(rutExtraido))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result == 1;
    }
    public Result obtenerPacientes(DSLContext query){
        Result result = query.select().from(DSL.table("paciente")).fetch();
        return result;
    }
}
