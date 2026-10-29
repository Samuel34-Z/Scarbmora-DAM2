package pser.ud1.conversacionHilos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(new FileReader("src\\pser\\ud1\\conversacionHilos\\Fichero.txt"))) {
            final int NUM_PERSONAS = 2;
            Thread[] personas = new Thread[NUM_PERSONAS];
            Espacio lugar = new Espacio();
            for (int i = 0; i < personas.length; i++) {
                personas[i] = new Persona(i + "", lugar);
                personas[i].start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
