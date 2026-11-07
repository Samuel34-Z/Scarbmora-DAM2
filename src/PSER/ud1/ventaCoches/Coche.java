package pser.ud1.ventaCoches;

import java.util.Random;

public class Coche {
    private Modelos modelo;
    private boolean estaLibre;
    private int numClientesAnteriores;
    private boolean verDetalle;
    private String nombreComprador;

    public Coche(Modelos modelo) {
        this.modelo = modelo;
        estaLibre = true;
        numClientesAnteriores = 0;
    }

    public synchronized boolean estaLibre() {
        return estaLibre;
    }

    public void irse() {
        this.estaLibre = true;
        nombreComprador = null;
        numClientesAnteriores++;
    }

    public void revisar(String nombreComprador) {
        this.estaLibre = false;
        this.nombreComprador = nombreComprador;
    }

    public void detalles() {
        System.out.println("==Detalles==");
        System.out.println("Cliente provando el coche: " + nombreComprador);
        System.out.println(
                "Decisión del cliente: " + (decidisionDeCompra() ? "Comprar el coche" : "No comprar el coche"));

    }

    public boolean decidisionDeCompra() {
        Random rd = new Random();
        Boolean seraComprado = false;
        if (numClientesAnteriores > rd.nextInt(100)) {
            seraComprado = true;
        }

        return seraComprado;
    }

}
