package adat.ud1.examen;

import java.io.FileWriter;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author Samuel
 */

public class ExportarJsonEmpleados {

    public static void main(String[] args) {
        List<Empleado> empleados = List.of(
                new Empleado(1, "Ana García", "Informática", 35000),
                new Empleado(2, "Luis Pérez", "Recursos Humanos", 28000),
                new Empleado(3, "María López", "Informática", 42000));

        String fichero = "DATOS\\empleados.json";
        exportarJson(empleados, fichero);
    }

    public static boolean exportarJson(List<Empleado> empleados, String fichero) {

        Gson gson = new Gson();

        String jsonListaEmpleados = gson.toJson(empleados);

        try (FileWriter out = new FileWriter(fichero)) {
            out.write(jsonListaEmpleados);
        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }
        return false;
    }
}
