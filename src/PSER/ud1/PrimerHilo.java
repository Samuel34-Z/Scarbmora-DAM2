package PSER.ud1;

public class PrimerHilo {
    public static void main(String[] args) {
        int nHilos = 10;
        for (int i = 1; i <= nHilos; i++) {
            InnerPrimerHilos hilo = new InnerPrimerHilos();
            hilo.setName("hilo " + i);
            hilo.start();
        }
    }
}

class InnerPrimerHilos extends Thread {

    @Override
    public void run() {
        System.out.println(getName());
    }

}
