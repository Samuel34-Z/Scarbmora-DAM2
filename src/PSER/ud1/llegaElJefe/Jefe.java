package pser.ud1.llegaElJefe;

public class Jefe extends Thread {
    Oficina oficina;

    public Jefe(Oficina oficina) {
        this.oficina = oficina;
    }

    @Override
    public void run() {
        synchronized (oficina) {
            System.out.println("EL JEFE HA LLEGADO!");
            oficina.entrar(this);
            oficina.notifyAll();
        }
    }
}