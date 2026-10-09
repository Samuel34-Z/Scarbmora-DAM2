package pser.ud1.aparcamientos;

public class SimulacionAparcamiento {
    public static void main(String[] args) {
        final int NUM_PLAZAS = 10;
        final int NUM_CONDUCTORES = 50;
        Thread[] conducotres = new Thread[NUM_CONDUCTORES];
        Plaza[] plazas = new Plaza[NUM_PLAZAS];

        for (int i = 0; i < conducotres.length; i++) {
            conducotres[i] = new Conductor(plazas,"Conductor "+i);
            conducotres[i].start();
        }

        for (Thread conductor : conducotres) {
            try {
                conductor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
