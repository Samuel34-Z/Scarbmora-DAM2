package ADAT.ud1.descatalogado;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Samuel
 */

public class Ejercicio1 {

    public static void main(String[] args) {

        String ruta = "prueba.txt";
        File archivo = new File(ruta);
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));

        try {
            if (archivo.createNewFile()) {
                System.out.println("El archivo no existe, se creará");
            } else {
                System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
                System.out.println("Nombre del Archivo: " + archivo.getName());
                System.out.println("Tamaño: " + archivo.length() + "B");
                System.out.println("Ultima Modificación: " + formato.format(new Date(archivo.lastModified())));
                String esDirectorio = archivo.isDirectory() ? "Es un directorio" : "No es un directorio";
                System.out.println(esDirectorio);
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

    }
}
