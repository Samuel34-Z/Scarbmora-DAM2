package pser.ud1.aparcamientos;

import java.util.Random;

public class Conductor extends Thread {

    private final int MIN_APARCADO = 10;
    private final int MAX_APARCADO = 50;
    private Plaza[] plazas;
    private int posicion;
    private String nombreConductor;
    private Parking parking;

    Random rd = new Random();

    public Conductor(Parking parking, String nombreConductor) {
        this.parking = parking;
        this.plazas = parking.getPlazas();
        this.nombreConductor = nombreConductor;
    }

    @Override
    public void run() {

        boolean aparca = false;
        while (!aparca) {
            for (int i = 0; i < plazas.length && !aparca; i++) {
                if (!plazas[i].isPlazaOcupada()) {
                    plazas[i].aparcar(nombreConductor);
                    posicion = i;
                    aparca = true;
                    System.out.println(parking.toString());
                }
            }

        }

        try {
            sleep(rd.nextInt(MIN_APARCADO, MAX_APARCADO));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parking.salir(posicion);

    }

}
