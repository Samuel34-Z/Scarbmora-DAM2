package pser.ud1.llegaElJefe;

public class Jefe extends Thread {
    Oficina oficina;

    public Jefe(Oficina oficina) {
        this.oficina = oficina;
    }
/* 
    public void avisar(Oficina oficina) {
        synchronized (oficina) {
            
        }
    } */

    @Override
    public void run() {
        oficina.entrar(this);
        /* avisar(oficina); */
    }
}