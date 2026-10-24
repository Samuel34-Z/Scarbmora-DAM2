package adat.ud2.bd.instituto.materiaCRUD;

public class MateriaDTO {
    private int codigoMateria;
    private String nombre;
    private String siglas;

    public MateriaDTO(int codigoMateria, String nombre, String siglas) {
        this.codigoMateria = codigoMateria;
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public MateriaDTO(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public MateriaDTO(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    @Override
    public String toString() {
        return "MateriaDTO [codigoMateria=" + codigoMateria + ", nombre=" + nombre + ", siglas=" + siglas + "]";
    }

}
