package adat.ud2.bd.prueba;

public class PersonaDTO {
    private int codigo_persona;
    private String nif;
    private String nombre;

    public PersonaDTO(int codigo_persona, String nif, String nombre) {
        this.codigo_persona = codigo_persona;
        this.nif = nif;
        this.nombre = nombre;
    }

    public PersonaDTO(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    public PersonaDTO(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public PersonaDTO() {
    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "PersonaDTO [codigo persona=" + codigo_persona + ", nif=" + nif + ", nombre=" + nombre + "]";
    }

}
