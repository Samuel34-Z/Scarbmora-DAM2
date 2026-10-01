package adat.ud1.practicas;

/**
 * @author Hugo Romay
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RegistroAlumnos {
    
    final static int lineas = 1000;
    public static void main(String[] args) {
        
        Random rnd = new Random();
        
        /* File f = new File("alumnos.txt");
        if (f.exists()) {
            System.out.println("El fichero ya existe");
        } */

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("alumnos.txt"));) {
           for (int i = 1; i < lineas; i++) {
            
            Double nota = Math.round(rnd.nextDouble() * 10 * 100) / 100.0;

            bw.write("Alumno_" + i + ";" + nota);

            bw.newLine();
        } 
        } catch (IOException e) {
            System.out.println("Error " +e.getMessage());
        }
        
        System.out.println("Generadas las " + lineas + " lineas");
    }
}
