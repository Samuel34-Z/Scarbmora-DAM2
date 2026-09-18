package ADAT.ud1.practicas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class ParticipacionEnClase {
    public static void main(String[] args) {
        File origen = new File("DATOS\\alumnos.txt");
        File destino = new File("DATOS\\Participación.txt");
        try (FileReader in = new FileReader(origen)) {
            List<String> alumnos = in.readAllLines();
            Random rd = new Random();
            String alSeleccionado = alumnos.get(rd.nextInt(alumnos.size()));
            System.out.println("El elegido es " + alSeleccionado);

            FileWriter out = new FileWriter(destino, true);
            out.write(LocalDateTime.now() + " - " + alSeleccionado + "\n");

            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");

        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }

}
