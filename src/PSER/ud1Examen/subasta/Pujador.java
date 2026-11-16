package pser.ud1Examen.subasta;

import java.util.Random;

public class Pujador extends Thread {

    private final double MAX_PRESUPUESTO = 1501;
    private final double MIN_PRESUPUESTO = 500;
    private double maxIncremento = 51;
    private final double MIN_INCREMENTO = 10;
    private Articulo articulo;
    Random rd = new Random();
    private final double PRESUPUESTO = rd.nextDouble(MIN_PRESUPUESTO, MAX_PRESUPUESTO);
    private long MIN_ESPERA = 50;
    private long MAX_ESPERA = 201;

    public Pujador(ThreadGroup grupo, Articulo articulo, String nombre) {
        super(grupo, nombre);
        this.articulo = articulo;
    }

    @Override
    public void run() {
        boolean tienePresupuesto = true;
        boolean alcanzoPrecioObjetivo = false;
        do {
            synchronized (articulo) {
                tienePresupuesto = articulo.getPrecioActual() + MIN_INCREMENTO < PRESUPUESTO;
                if ((!getName().equals(articulo.getMaximoPostor()))
                        && (tienePresupuesto)) {
                    double cantidadRestante = PRESUPUESTO - articulo.getPrecioActual();
                    if (cantidadRestante < maxIncremento) {
                        maxIncremento = cantidadRestante;
                    }
                    double aumento = rd.nextDouble(MIN_INCREMENTO, maxIncremento);
                    alcanzoPrecioObjetivo = articulo.aumentarPrecio(aumento, getName());
                }
            }
            if (alcanzoPrecioObjetivo) {
                getThreadGroup().interrupt();
            }

            try {
                sleep(rd.nextLong(MIN_ESPERA, MAX_ESPERA));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (tienePresupuesto && (!isInterrupted()));
    }

}
