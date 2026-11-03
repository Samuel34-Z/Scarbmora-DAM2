package pser.ud1.conversacionHilos;

import java.io.BufferedReader;
import java.io.IOException;

public class Persona extends Thread {
    BufferedReader lector;
    String nombre;

    public Persona(String nombre, BufferedReader lector) {
        this.nombre = nombre;
        this.lector = lector;
    }

    @Override
    public void run() {
        hablar();
    }

    private void hablar() {
        synchronized (lector) {
            String frase;

            try {
                while ((frase = lector.readLine()) != null) {
                    lector.notify();
                    System.out.println(nombre + " " + frase);
                    lector.wait();
                }
                lector.notify();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
