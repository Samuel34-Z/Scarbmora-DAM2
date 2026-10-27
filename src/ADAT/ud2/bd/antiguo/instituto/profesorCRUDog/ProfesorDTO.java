package adat.ud2.bd.antiguo.instituto.profesorCRUDog;

import java.time.LocalDate;
import java.util.List;

import adat.ud2.bd.antiguo.instituto.materiaCRUD.MateriaDTO;

public class ProfesorDTO {
    private int id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private List<MateriaDTO> materiasImparte;
    // private List<String> cursosImparte;
    private String direccion;
    private String telefono;

    public ProfesorDTO(int id, String nombre, String apellidos, LocalDate fechaNacimiento,
            List<MateriaDTO> materiasImparte/*
                                          * ,
                                          * List<String> cursosImparte
                                          */, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.materiasImparte = materiasImparte;
        // this.cursosImparte = cursosImparte;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ProfesorDTO(String nombre, String apellidos, LocalDate fechaNacimiento,
            List<MateriaDTO> materiasImparte/*
                                          * ,
                                          * List<String> cursosImparte
                                          */, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.materiasImparte = materiasImparte;
        // this.cursosImparte = cursosImparte;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ProfesorDTO(int id) {
        this.id = id;
    }

    public ProfesorDTO() {
    }

    public int getId() {
        return id;
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

    public List<MateriaDTO> getMateriasImparte() {
        return materiasImparte;
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
        String materias = "[";
        for (MateriaDTO codigoMateria : materiasImparte) {
            if (materiasImparte.getLast() == codigoMateria) {
                materias += codigoMateria + "]";  
            }
            materias += codigoMateria + ", ";
        }

        return "ProfesorDTO [ id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
                + fechaNacimiento +  ", materiasImparte=" + materias + /*", cursosImparte=" + cursosImparte
                +  */", direccion=" + direccion + ", telefono=" + telefono + "]";
    }

}
