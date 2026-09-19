package ADAT.ud1.descatalogado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio1nio {
    public static void main(String[] args) {
        Path path = Path.of("prueba.txt");
        try {
            if (Files.exists(path)) {

                System.out.println("Ruta absoluta: " + path.toAbsolutePath());
                System.out.println("Nombre: " + path.getFileName());
                System.out.println("Tamaño: " + Files.size(path));

                System.out.println("Última modificación" + Files.getLastModifiedTime(path));
                System.out.println("Es un directorio?: " + Files.isDirectory(path));
            } else {

                Files.createFile(path);

            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }
    }

}
