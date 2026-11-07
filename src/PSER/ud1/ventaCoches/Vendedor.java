package pser.ud1.ventaCoches;

public class Vendedor extends Thread {
    Coche[] coches;

    public Vendedor(Coche[] coches) {
        this.coches = coches;
    }

    @Override
    public void run() {
        buscarCocheLibre();
    }

    public Coche buscarCocheLibre() {
        Coche cocheLibre = null;
        for (Coche coche : coches) {
            if (coche.estaLibre()) {
                cocheLibre = coche;
                break;
            }
        }

        return cocheLibre;
    }
}
