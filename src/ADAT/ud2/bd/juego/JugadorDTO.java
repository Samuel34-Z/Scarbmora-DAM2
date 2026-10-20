package adat.ud2.bd.juego;

import java.sql.Date;

public class JugadorDTO {
    private int idJugador;
    private String nombreCuenta;
    private String nombreJugador;
    private double experiencia;
    private Date fechaNacimiento;
    private String correoElectronico;
    private int nivel;

    public JugadorDTO(int idJugador, String nombreCuenta, String nombreJugador, double experiencia,
            Date fechaNacimiento, String correoElectronico, int nivel) {
        this.idJugador = idJugador;
        this.nombreCuenta = nombreCuenta;
        this.nombreJugador = nombreJugador;
        this.experiencia = experiencia;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.nivel = nivel;
    }

    public JugadorDTO(String nombreCuenta, String nombreJugador, double experiencia, Date fechaNacimiento,
            String correoElectronico, int nivel) {
        this.nombreCuenta = nombreCuenta;
        this.nombreJugador = nombreJugador;
        this.experiencia = experiencia;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.nivel = nivel;
    }

    public JugadorDTO() {
    }

    public JugadorDTO(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public double getExperiencia() {
        return experiencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "JugadorDTO [idJugador=" + idJugador + ", nombreCuenta=" + nombreCuenta + ", nombreJugador="
                + nombreJugador + ", fechaNacimiento=" + fechaNacimiento + ", correoElectronico=" + correoElectronico
                + ", nivel=" + nivel + ", experiencia=" + experiencia + "]";
    }

}
