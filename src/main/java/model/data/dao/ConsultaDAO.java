package model.data.dao;

import model.ConsultaMedica;
import model.Paciente;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.sql.Time;
import java.util.Date;

import static org.jooq.impl.DSL.table;

public class ConsultaDAO {
    public boolean agendarConsulta(DSLContext query, ConsultaMedica consultaMedica){
        Date fecha = consultaMedica.getFecha();
        Time hora = consultaMedica.getHora();
        String rutProfesional = consultaMedica.getRutProfesional();
        Table consultaTabla = table(DSL.name("consultaMedica"));
        Field[] columnas = consultaTabla.fields(
                "Fecha",
                "Hora",
                "RutProfesional"
        );
        int results = 0;
        try {
            results = query.insertInto(consultaTabla,columnas[0],columnas[1],columnas[2])
                    .values(fecha,hora,rutProfesional)
                    .execute();
        }catch (Exception e){

        }
        return results==1;
    }
    public boolean eliminarConsulta(DSLContext query,ConsultaMedica consultaMedica){
        Date fecha = consultaMedica.getFecha();
        Time hora = consultaMedica.getHora();
        int result = 0;
        try {
            result = query.deleteFrom(
                            DSL.table("consultaMedica"))
                    .where(DSL.field("Hora").eq(hora))
                    .execute();
        }catch (Exception e){
            System.out.println(e);
        }
        return result == 1;
    }
}
