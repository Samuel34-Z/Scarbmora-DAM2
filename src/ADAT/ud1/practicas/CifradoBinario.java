package ADAT.ud1.practicas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Ignacio Rodríguez
 */

public class CifradoBinario {
    public static void main(String[] args) {
        String rutaOrigen = "1.png";
        String rutaDestino = "archivoCifrado.png";

        try {
            cifradoBinario(rutaOrigen, rutaDestino);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo.");
        }

    }

    private static void cifradoBinario(String rutaOrigen, String rutaDestino) {

        if (rutaOrigen == null || rutaDestino == null) {
            throw new IllegalArgumentException("La ruta es incorrecta");
        }

        try (var origen = new FileInputStream(rutaOrigen);
                var destino = new FileOutputStream(rutaDestino);) {

            int cifrado;

            while ((cifrado = origen.read()) != -1) {
                destino.write(~cifrado);
            }

            System.out.println("Archivo cifrado correctamente");


    }

}