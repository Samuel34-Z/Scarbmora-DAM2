package pser.ud1.conversacionHilos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Espacio {

    public synchronized void hablar(String nombre) {
        try (BufferedReader in = new BufferedReader(new FileReader("src\\pser\\ud1\\conversacionHilos\\Fichero.txt"));) {

            String linea;
            while ((linea = in.readLine()) != null) {
                notify();
                System.out.println(nombre + ": " + linea);
                wait();
            }
            notify();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
