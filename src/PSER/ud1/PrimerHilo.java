package pser.ud1;

public class PrimerHilo {
    public static void main(String[] args) {
        int nHilos = 10;
        Thread[] hilos = new Thread[nHilos];
        for (int i = 0; i < nHilos; i++) {
            InnerPrimerHilos hilo = new InnerPrimerHilos();

            /* 
            Thread hilo2 = new Thread(new Runnable() {

                @Override
                public void run() {
                    int nSout = 10;
                    for (int i = 0; i < nSout; i++) {
                        System.out.println(getName() + " > " + i);
                    }
                }

            });
            */
            hilo.setName("hilo " + (i + 1));
            hilos[i] = hilo;
            hilo.start();

        }
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin del programa");

    }
}

class InnerPrimerHilos extends Thread {

    @Override
    public void run() {
        int nSout = 10;
        for (int i = 0; i < nSout; i++) {
            System.out.println(getName() + " > " + i);
        }

    }

}
