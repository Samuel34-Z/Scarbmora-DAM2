package pser.ud1.ventaCoches;

public class Vendedor extends Thread {
    Coche[] coches;

    @Override
    public void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
