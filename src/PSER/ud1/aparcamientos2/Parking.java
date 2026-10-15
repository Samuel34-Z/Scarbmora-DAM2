package pser.ud1.aparcamientos2;

import java.util.ArrayList;
import java.util.List;

public class Parking {// TODO haz que sea como un parking electronico en el que tengas una lista de
                      // posiciones de plazas libres (agrega o quita al aparcar/salir)
    final int NUM_PLAZAS = 10;
    private Plaza[] plazas = new Plaza[NUM_PLAZAS];
    private List<Integer> plazasLibres = new ArrayList<>();

    public Parking() {
        for (int i = 0; i < plazas.length; i++) {
            plazas[i] = new Plaza();
            plazasLibres.add(i);
        }
    }

    @Override
    public String toString() {
        String mostrarPlazas = "[";

        for (int i = 0; i < plazas.length; i++) {

            mostrarPlazas += plazas[i] + ((i + 1 == plazas.length) ? "]" : ",");
        }

        return mostrarPlazas;
    }

    public Plaza[] getPlazas() {
        return plazas;
    }

    public List<Integer> getPlazasLibres() {
        return plazasLibres;
    }

}
