package adat.ud2.bd.nuevo.instituto.dto;

import java.time.LocalDate;

public class ProfesorDTO {
    private int codigoProfesor;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    // private List<String> cursosImparte;
    private String direccion;
    private String telefono;

    public ProfesorDTO(int codigoProfesor, String nombre, String apellidos, LocalDate fechaNacimiento/*
                                          * ,
                                          * List<String> cursosImparte
                                          */, String direccion, String telefono) {
        this.codigoProfesor = codigoProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        // this.cursosImparte = cursosImparte;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ProfesorDTO(String nombre, String apellidos, LocalDate fechaNacimiento/*
                                          * ,
                                          * List<String> cursosImparte
                                          */, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        // this.cursosImparte = cursosImparte;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ProfesorDTO(int id) {
        this.codigoProfesor = id;
    }

    public ProfesorDTO() {
    }

    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /*
     * public List<String> getCursosImparte() {
     * return cursosImparte;
     * }
     * 
     */
    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {

        return "ProfesorDTO [ codigoProfesor=" + codigoProfesor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento +/*", cursosImparte=" + cursosImparte
                +  */", direccion=" + direccion + ", telefono=" + telefono + "]";
    }

}
