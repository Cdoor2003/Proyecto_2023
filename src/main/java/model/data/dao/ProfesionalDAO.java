package model.data.dao;

import model.Paciente;
import model.Profesional;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.table;
public class ProfesionalDAO {
    public boolean registrarProfesional(DSLContext query, Profesional profesional){
        String nombre = profesional.getNombre();
        String apellido = profesional.getApellido();
        String rut = profesional.getRut();
        int telefono = profesional.getTelefono();
        String email = profesional.getEmail();
        String profesion = profesional.getProfesion();
        String tipoContrato = profesional.getTipoContrato();
        String contraseña = profesional.getContraseña();
        Table profesionalTabla = table(DSL.name("profesional"));
        Field[] columnas = profesionalTabla.fields(
                "Nombre",
                "Apellido",
                "Rut",
                "Profesion",
                "TipoContrato",
                "email",
                "Contraseña",
                "telefono"
        );
        int results = 0;
        try {
            results = query.insertInto(profesionalTabla,columnas[0],columnas[1],columnas[2],columnas[3],columnas[4],columnas[5],columnas[6],columnas[7])
                    .values(nombre,apellido,rut,telefono,email,profesion,tipoContrato,contraseña)
                    .execute();
        }catch (Exception e){

        }
        return results==1;
    }
    public boolean despedirProfesional(DSLContext query, Profesional profesional){
        String rutExtraido = profesional.getRut();
        int result = 0;
        try {
            result = query.deleteFrom(
                            DSL.table("profesional"))
                    .where(DSL.field("Rut").eq(rutExtraido))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result == 1;
    }
}
