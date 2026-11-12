package adat.ud2.bd.prueba.personaProyecto;

public class PersonaProyectoDTO {
    private int codigoPersona;
    private int codigoProyecto;
    private int horasAsignadas;

    public PersonaProyectoDTO(int codigoPersona, int codigoProyecto, int horasAsignadas) {
        this.codigoPersona = codigoPersona;
        this.codigoProyecto = codigoProyecto;
        this.horasAsignadas = horasAsignadas;
    }

    public PersonaProyectoDTO(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public PersonaProyectoDTO(int codigoPersona, int codigoProyecto) {
        this.codigoPersona = codigoPersona;
        this.codigoProyecto = codigoProyecto;
    }

    public PersonaProyectoDTO() {
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    @Override
    public String toString() {
        return "PersonaProyectoDTO [codigoPersona=" + codigoPersona + ", codigoProyecto=" + codigoProyecto
                + ", horasAsignadas=" + horasAsignadas + "]";
    }

}
