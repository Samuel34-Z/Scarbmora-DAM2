package pser.ud1.aparcamientos;

import java.util.Random;

public class Conductor extends Thread {

    private final int MIN_APARCADO = 1000;
    private final int MAX_APARCADO = 5000;
    private Plaza[] plazas;
    private int posicion;
    private String nombreConductor;

    Random rd = new Random();

    public Conductor(Plaza[] plazas, String nombreConductor) {
        this.plazas = plazas;
        this.nombreConductor = nombreConductor;
    }

    @Override
    public void run() {

        for (int i = 0; i < plazas.length; i++) {
            if (!plazas[i].isPosicionOcupada()) {
                plazas[i].aparcar();
                posicion = i;
                break;
            }
        }

        try {
            sleep(rd.nextInt(MIN_APARCADO, MAX_APARCADO));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plazas[posicion].salir();

    }

}
