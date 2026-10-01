package pser.ud1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EleccionesMunicipales {
    public static void main(String[] args) {

        final int CENSO = 10000;
        final int NUM_PARTIDOS = 5;
        Thread[] hilos = new Thread[CENSO];
        Partido[] partidos = new Partido[NUM_PARTIDOS];

        for (int i = 0; i < NUM_PARTIDOS; i++) {
            partidos[i] = new Partido("Numero" + i);
        }

        for (int i = 0; i < CENSO; i++) {
            hilos[i] = new Votante(partidos, NUM_PARTIDOS);
            hilos[i].start();
        }

        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Votos de cada Partido");
        int mayorVotos = -1;
        List<Integer> masVotados = new ArrayList<>();
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            System.out.println(partidos[i]);
            if (partidos[i].getVoto() > mayorVotos) {
                mayorVotos = partidos[i].getVoto();
                masVotados.clear();
                masVotados.add(i);
            } else if (partidos[i].getVoto() == mayorVotos) {
                masVotados.add(i);
            }

        }
        if (masVotados.size() == 1) {
            System.out.println("Partido ganador" + partidos[masVotados.get(0)]);
        } else {
            System.out.println("Partidos Empatados");
            for (Integer puesto : masVotados) {
                System.out.println(partidos[puesto]);
            }
        }

    }
}

class Votante extends Thread {
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

        partidos[rd.nextInt(numPartidos)].votar();

    }
}

class Partido {
    private int voto;
    private String nombrePartido;

    public synchronized void votar() {
        voto++;
    }

    public Partido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }

    public int getVoto() {
        return voto;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    @Override
    public String toString() {
        return "Partido " + nombrePartido + "-> " + voto + " votos";
    }

}