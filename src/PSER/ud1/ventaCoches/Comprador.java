package pser.ud1.ventaCoches;

import java.util.Random;

public class Comprador extends Thread {
    Vendedor vendedor;
    String nombre;
    Boolean cocheComprado;
    Coche coche;

    public Comprador(Vendedor vendedor, String nombre) {
        this.vendedor = vendedor;
        this.nombre = nombre;
        coche = null;
        cocheComprado = false;
    }

    @Override
    public void run() {

        synchronized (vendedor) {

            while (coche == null) {
                try {
                    vendedor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coche = vendedor.buscarCocheLibre();
            }
            coche.revisar(nombre);
        }

        Random rd = new Random();

        try {
            sleep(rd.nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cocheComprado = coche.decidisionDeCompra();

        if (!cocheComprado) {
            coche.irse();
        }

    }
}
