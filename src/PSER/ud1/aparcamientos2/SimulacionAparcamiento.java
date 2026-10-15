package pser.ud1.aparcamientos2;

public class SimulacionAparcamiento {
    public static void main(String[] args) {
        
        final int NUM_CONDUCTORES = 50;
        Thread[] conducotres = new Thread[NUM_CONDUCTORES];
        Parking parking = new Parking();
        
        System.out.println(parking.toString());
        for (int i = 0; i < conducotres.length; i++) {
            conducotres[i] = new Conductor(parking, "C" + i);
            conducotres[i].start();
        }

        for (Thread thread : conducotres) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(parking.toString());
    }
}
