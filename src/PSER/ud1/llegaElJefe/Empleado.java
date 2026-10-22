package pser.ud1.llegaElJefe;

public class Empleado extends Thread {
    Oficina oficina;

    public Empleado(Oficina oficina) {
        this.oficina = oficina;
    }

    @Override
    public void run() {
        oficina.entrar(this);
        /* if (oficina.getEstaElJefe() == true) {
            System.out.println("Hola jefe!, me pongo a trabajar...");
        } else {
            System.out.println("ZZZZZZ");
            synchronized (oficina) {
                try {
                    wait();
                    System.out.println("buenos días jefe, aquí estoy trabajando");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } */

    }
}
