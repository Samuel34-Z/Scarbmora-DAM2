package pser.ud1;

public class ContarEnHilos {

    public static void main(String[] args) {
        int nHilos = 100;
        Thread[] hilos = new Thread[nHilos];
        InnerContador contador = new InnerContador();
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
        System.out.println("El contador es: " + contador.getContador());

    }

}

class HiloImplementador extends Thread {
    InnerContador cont;

    public HiloImplementador(InnerContador cont) {
        this.cont = cont;
    }

    @Override
    public void run() {

        cont.incrementar();

    }
}

class InnerContador {
    private int contador;

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}