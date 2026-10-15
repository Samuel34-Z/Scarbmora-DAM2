package adat.ud1.examen;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel
 */

public class FaltasSerializadas {
    public static void main(String[] args) {
        List<String> listaFaltas = new ArrayList<>();
        List<FaltasAsistencia> listaDatos = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader("DATOS\\consultaxeradorinformes.csv"))) {
            String cadena;
            while ((cadena = in.readLine()) != null) {
                if (cadena.contains("\"Non\"")) {
                    listaFaltas.add(cadena);
                }
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

        for (String string : listaFaltas) {
            String[] datos = string.split(";");
            String[] fecha = datos[3].replace("\"", "").replace("\"", "").split("/");

            listaDatos.add(new FaltasAsistencia(
                    LocalDate.of(Integer.valueOf(fecha[0]), Integer.valueOf(fecha[1]), Integer.valueOf(fecha[2])),
                    Integer.valueOf(datos[6].replace("\"", "").replace("\"", "")),
                    datos[5].replace("\"", "").replace("\"", ""), datos[2].replace("\"", "").replace("\"", ""),
                    datos[1].replace("\"", "").replace("\"", "").replace(",", "")));

        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DATOS\\FaltasAsistencia.dat"))) {

            for (FaltasAsistencia faltasAsistencia : listaDatos) {
                out.writeObject(faltasAsistencia);
                System.out.println(faltasAsistencia);
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

    }
}
