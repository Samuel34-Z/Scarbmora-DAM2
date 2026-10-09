package pser.ud1.partidos;

import java.util.ArrayList;
import java.util.List;

public class EleccionesMunicipales {
    public static void main(String[] args) {

        final int CENSO = 1000;
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
            if (partidos[i].getNumVotos() > mayorVotos) {
                mayorVotos = partidos[i].getNumVotos();
                masVotados.clear();
                masVotados.add(i);
            } else if (partidos[i].getNumVotos() == mayorVotos) {
                masVotados.add(i);
            }

        }
        if (masVotados.size() == 1) {
            System.out.println("Partido ganador " + partidos[masVotados.get(0)]);
        } else {
            System.out.println("Partidos Empatados");
            for (Integer puesto : masVotados) {
                System.out.println(partidos[puesto]);
            }
        }

    }
}
