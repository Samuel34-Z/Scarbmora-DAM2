package adat.ud1.examen;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Samuel
 */

public class FaltasAsistencia implements Serializable {
    LocalDate data;
    int sesion;
    String modulo;
    String curso;
    String alumno;

    public FaltasAsistencia(LocalDate data, int sesion, String modulo, String curso, String alumno) {
        this.data = data;
        this.sesion = sesion;
        this.modulo = modulo;
        this.curso = curso;
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "FaltasAsistencia [data=" + data + ", sesion=" + sesion + ", modulo=" + modulo + ", curso=" + curso
                + ", alumno=" + alumno + "]";
    }

}
