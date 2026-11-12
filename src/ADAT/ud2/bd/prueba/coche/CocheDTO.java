package adat.ud2.bd.prueba.coche;

public class CocheDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private int codigo_propietario;

    public CocheDTO(String matricula, String marca, String modelo, int codigo_propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.codigo_propietario = codigo_propietario;
    }

    public CocheDTO(String matricula) {
        this.matricula = matricula;
    }

    public CocheDTO() {
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCodigo_propietario() {
        return codigo_propietario;
    }

    @Override
    public String toString() {
        return "CocheDTO [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", codigo_propietario="
                + codigo_propietario + "]";
    }

}
