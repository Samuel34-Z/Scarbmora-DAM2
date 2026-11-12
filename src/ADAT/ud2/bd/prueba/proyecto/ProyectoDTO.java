package adat.ud2.bd.prueba.proyecto;

public class ProyectoDTO {
    private int codigoProyecto;
    private String nombreProyecto;
    private double presupuesto;

    public ProyectoDTO(int codigoProyecto, String nombreProyecto, double presupuesto) {
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
        this.presupuesto = presupuesto;
    }

    public ProyectoDTO(String nombreProyecto, double presupuesto) {
        this.nombreProyecto = nombreProyecto;
        this.presupuesto = presupuesto;
    }

    public ProyectoDTO(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public ProyectoDTO() {
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    @Override
    public String toString() {
        return "ProyectoDTO [codigoProyecto=" + codigoProyecto + ", nombreProyecto=" + nombreProyecto + ", presupuesto="
                + presupuesto + "]";
    }

}
