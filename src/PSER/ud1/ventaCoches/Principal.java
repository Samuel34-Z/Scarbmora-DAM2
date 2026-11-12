package pser.ud1.ventaCoches;

public class Principal {
    public static void main(String[] args) {
        final int NUM_PERSONAS = 50;
        final int NUM_UNIDADES = 20;
        int unidadesLeon = 10;
        int unidadesIbiza = 7;
        int unidadesAteca = 3;
        Thread[] hilos = new Thread[NUM_PERSONAS];
        Coche[] coches = new Coche[NUM_UNIDADES];
        Vendedor vendedor = new Vendedor(coches);

        for (int i = 0; i < coches.length; i++) {
            if (unidadesLeon > 0) {
                coches[i] = new Coche(Modelos.León);
                unidadesLeon--;
            } else if (unidadesIbiza > 0) {
                coches[i] = new Coche(Modelos.Ibiza);
                unidadesIbiza--;
            } else if (unidadesAteca > 0) {
                coches[i] = new Coche(Modelos.Ateca);
                unidadesAteca--;
            }

        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Comprador(vendedor, "" + i);
            hilos[i].start();
        }

        for (Thread persona : hilos) {
            try {
                persona.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
