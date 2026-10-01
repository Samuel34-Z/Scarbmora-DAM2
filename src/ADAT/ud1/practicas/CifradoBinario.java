package adat.ud1.practicas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Ignacio Rodríguez
 */

public class CifradoBinario {
    public static void main(String[] args) {

        try {
            cifradoBinario("1.png", "archivocifrado.png");
            cifradoBinario("archivocifrado.png", "2.png");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo.");
        }
    }

    public  static void cifradoBinario(String rutaOrigen, String rutaDestino) throws FileNotFoundException, IOException {

       try ( var origen = new FileInputStream(rutaOrigen);
        var destino = new FileOutputStream(rutaDestino);) {

            int cifrado;

            while ((cifrado = origen.read()) != -1) {
                destino.write(~cifrado);
            } 
    }
}
}
