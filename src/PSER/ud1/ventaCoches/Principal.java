package pser.ud1.ventaCoches;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        final int NUM_PERSONAS = 51;
        final int NUM_UNIDADES = 20;
        Thread[] hilos = new Thread[NUM_PERSONAS];
        Coche[] coches = new Coche[NUM_UNIDADES];
        Random rd = new Random();
        int indexVendedor = rd.nextInt(NUM_PERSONAS);

        for (int i = 0; i < coches.length; i++) {
            coches[i] = new Coche(String.valueOf(i));
            // TODO instanciar N coches de cada tipo
        }

        for (int i = 0; i < hilos.length; i++) {
            if (i == indexVendedor) {
                hilos[i] = new Vendedor();
            } else {
                hilos[i] = new Comprador();
            }

            hilos[i].start();
        }

    }
}
