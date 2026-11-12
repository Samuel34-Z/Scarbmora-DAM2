package pser.ud1.ventaCoches;

public class Vendedor {
    Coche[] coches;

    public Vendedor(Coche[] coches) {
        this.coches = coches;
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
