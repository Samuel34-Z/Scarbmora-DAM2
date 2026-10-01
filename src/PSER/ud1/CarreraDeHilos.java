package pser.ud1;

import java.util.Random;

public class CarreraDeHilos {
    public static void main(String[] args) {
        int hilos = 10;

        for (int i = 0; i < hilos; i++) {
            InnerCarreraDeHilos hilo = new InnerCarreraDeHilos();
            hilo.setName("hilo" + i);
            hilo.start();
        }
    }
}

class InnerCarreraDeHilos extends Thread {

    @Override
    public void run() {
        int distanciaCarrera = 100;

        for (int i = 0; i < distanciaCarrera; i++) {
            try {
                Random rd = new Random();
                Thread.sleep(rd.nextInt(0,100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Vicoria "+getName());

    }
}
