package pser.ud1.partidos;

import java.util.Random;

public class Votante extends Thread {
    Random rd = new Random();
    int pensar = 500;
    Partido[] partidos;
    int numPartidos;

    public Votante(Partido[] partidos, int numPartidos) {
        this.partidos = partidos;
        this.numPartidos = numPartidos;
    }

    @Override
    public void run() {
        try {
            sleep(rd.nextInt(pensar));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int seleccionPartido = rd.nextInt(numPartidos);
        partidos[seleccionPartido].votar();

    }
}
