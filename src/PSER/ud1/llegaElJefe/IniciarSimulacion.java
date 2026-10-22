package pser.ud1.llegaElJefe;

import java.util.Random;

public class IniciarSimulacion {
    public static void main(String[] args) {

        final int NUM_PERSONAS = 20;
        Thread[] hilos = new Thread[NUM_PERSONAS];
        Random rd = new Random();
        int jefe = rd.nextInt(NUM_PERSONAS);
        Oficina oficina = new Oficina();

        for (int i = 0; i < NUM_PERSONAS; i++) {
            if (i == jefe) {
                hilos[i] = new Jefe(oficina);
            } else {
                hilos[i] = new Empleado(oficina);
            }
            hilos[i].start();
        }
    }
}
