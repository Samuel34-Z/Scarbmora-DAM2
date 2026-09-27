package PSER.ud1;

public class Contador {
    static int contador = 0;

    public static void main(String[] args) {

        int nHilos = 10;
        Thread[] hilos = new Thread[nHilos];

        for (int i = 0; i < nHilos; i++) {
            hilos[i] = new HiloImplementador(contador);
            hilos[i].start();
        }

        for (Thread thread : hilos) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El contador es: " + contador);
    }

    public static void setContador(int contador) {
        Contador.contador = contador;
    }

}

class HiloImplementador extends Thread {
    int contador = 0;

    public HiloImplementador(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        contador++;
        Contador.setContador(contador);
    }
}