package pser.ud1.partidos;

public class Partido {
    private int numVotos;
    private String nombrePartido;

    public synchronized void votar() {
        numVotos++;
    }

    public Partido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    @Override
    public String toString() {
        return "Partido " + nombrePartido + "-> " + numVotos + " votos";
    }

}
