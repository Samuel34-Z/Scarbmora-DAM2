package adat.ud2.bd.nuevo.instituto.dto;

public class MateriaProfesorDTO {
    private int codigoMateria;
    private int codigoProfesor;

    public MateriaProfesorDTO(int codigoMateria, int codigoProfesor) {
        this.codigoMateria = codigoMateria;
        this.codigoProfesor = codigoProfesor;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public int getCodigoProfesor() {
        return codigoProfesor;
    }
    
}
