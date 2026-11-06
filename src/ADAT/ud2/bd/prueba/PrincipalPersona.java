package adat.ud2.bd.prueba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PrincipalPersona {
    public static void main(String[] args) {
        boolean salir = false;
        PersonaDAOimp personaDAO = new PersonaDAOimp();
        do {

            System.out.println("MENÚ");
            System.out.println("====");
            System.out.println("1. Crear tabla");
            System.out.println("2. Listar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Agregar persona");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Actualizar persona");
            System.out.println("7. Salir");
            System.out.print("Que operación desea realizar?: ");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearTabla();
                    break;

                case 2:

                    List<PersonaDTO> lista = personaDAO.listarPersonas();

                    for (PersonaDTO personaDTO : lista) {
                        System.out.println(personaDTO.toString());
                    }

                    break;
                case 7:
                    System.out.println("Cerrando menú...");
                    salir = true;
                    sc.close();
                    break;
                default:
                    System.out.println("Dato introducido incorrecto");
                    break;
            }

        } while (!salir);
    }

    private static boolean crearTabla() {
        boolean tablaCreada = false;
        try (BufferedReader in = new BufferedReader(new FileReader("src\\adat\\ud2\\bd\\prueba\\CrearTabla.sql"))) {

            String sql = in.readAllAsString();

            Conexion.getConection().createStatement().execute(sql);
            tablaCreada = true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tablaCreada;
    }
}
