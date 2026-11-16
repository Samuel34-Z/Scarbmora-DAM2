package pser.ud1Examen.laboratorio;

public class Entrada {
    private String hash;
    private int numConsultas;

    public Entrada(String hash, int numConsultas) {
        this.hash = hash;
        this.numConsultas = numConsultas;
    }

    public void aumentarConsultas() {
        numConsultas++;
    }

    public String getHash() {
        return hash;
    }

    public int getNumConsultas() {
        return numConsultas;
    }

}
