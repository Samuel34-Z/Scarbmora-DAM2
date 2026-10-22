package pser.ud1.aparcamientos;

public class Parking {
    final int NUM_PLAZAS = 10;
    private Plaza[] plazas = new Plaza[NUM_PLAZAS];

    public Parking() {
        for (int i = 0; i < plazas.length; i++) {
            plazas[i] = new Plaza();
        }
    }

    @Override
    public String toString() {
        String mostrarPlazas = "[";

        for (int i = 0; i < plazas.length; i++) {

            mostrarPlazas += plazas[i] + ((i+1 == plazas.length) ? "]" : ",");
        }

        return mostrarPlazas;
    }

    public void salir(int posicion){
        plazas[posicion].salir();
    }

    public Plaza[] getPlazas() {
        return plazas;
    }

}
