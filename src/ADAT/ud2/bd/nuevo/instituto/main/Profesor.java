package adat.ud2.bd.nuevo.instituto.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import adat.ud2.bd.nuevo.instituto.conexion.Conexion;
import adat.ud2.bd.nuevo.instituto.sql.DevolverConsulta;

public class Profesor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("MENU ALUMNOS");
            System.out.println("0. Crear Tabla/BD");
            System.out.println("1. Insertar");
            System.out.println("2. Listar");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Actualizar");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción:");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 0:
                    crearTabla();
                    break;
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    // Salir
                    sc.close();
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        } while (true);
    }

    private static void crearTabla() {
        Connection conexion = Conexion.getConection();

        try (Statement sentencia = conexion.createStatement();) {
            String fichero = "src\\adat\\ud2\\bd\\nuevo\\instituto\\sql\\Profesor.sql";
            String sql = DevolverConsulta.getConsulta(fichero);
            sentencia.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
