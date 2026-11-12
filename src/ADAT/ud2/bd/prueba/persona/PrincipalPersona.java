package adat.ud2.bd.prueba.persona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import adat.ud2.bd.prueba.Conexion;

public class PrincipalPersona {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        Connection con = Conexion.getConection();
        PersonaDAOimp personaDAO = new PersonaDAOimp(con);

        do {

            System.out.println("==MENÚ==");
            System.out.println("1. Crear tabla");
            System.out.println("2. Listar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Agregar persona");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Actualizar persona");
            System.out.println("7. Salir");
            System.out.print("Que operación desea realizar?: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    if (crearTabla()) {
                        System.out.println("Tabla creada con éxito");
                    } else {
                        System.out.println("Error creando la tabla");
                    }

                    break;

                case 2:

                    List<PersonaDTO> lista = personaDAO.listarPersonas();

                    for (PersonaDTO personaDTO : lista) {
                        System.out.println(personaDTO.toString());
                    }
                    break;

                case 3:

                    System.out.print("Introduce el código de la persona a buscar: ");
                    int codigoPersona = sc.nextInt();

                    PersonaDTO persona = personaDAO.buscarPersona(codigoPersona);

                    if (persona != null) {
                        System.out.println(persona.toString());
                    } else {
                        System.out.println("No se ha encontrado ninguna persona con el código " + codigoPersona);
                    }

                    break;

                case 4:

                    persona = pedirPersona(false);

                    if (persona != null) {
                        if (personaDAO.agregarPersona(persona)) {
                            System.out.println("Persona agregada con éxito");
                        } else {
                            System.out.println("Error agregando la persona");
                        }
                    }

                    break;

                case 5:

                    System.out.print("Introduce el código de la persona a eliminar: ");
                    codigoPersona = sc.nextInt();

                    if (personaDAO.eliminarPersona(codigoPersona)) {
                        System.out.println("Perona eliminada con éxito");
                    } else {
                        System.out.println("Error eliminando la persona con el código " + codigoPersona);
                    }

                    break;

                case 6:
                    persona = pedirPersona(true);
                    if (persona != null) {
                        if (personaDAO.actualizarPersona(persona)) {
                            System.out.println("Persona actualizada con éxito");
                        } else {
                            System.out.println("Error actualizando la persona");
                        }
                    }

                    break;

                case 7:
                    System.out.println("Cerrando menú...");
                    salir = true;
                    sc.close();
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Dato introducido incorrecto");
                    break;
            }

        } while (!salir);
    }

    private static PersonaDTO pedirPersona(boolean codigo) {
        int codigoPersona = 0;
        if (codigo) {
            System.out.print("Introduce el código de la persona: ");
            codigoPersona = sc.nextInt();
            sc.nextLine();
        }
        System.out.print("Introduce el NIF de la persona: ");
        String nif = sc.nextLine();
        if (!nif.matches("\\d{8}[A-Z]")) {
            System.out.println("NIF introducido es incorrecto");
            return null;
        }
        System.out.print("Introduce el nombre de la persona: ");
        String nombre = sc.nextLine();

        return codigo ? new PersonaDTO(codigoPersona, nif, nombre) : new PersonaDTO(nif, nombre);
    }

    private static boolean crearTabla() {
        boolean tablaCreada = false;
        try (BufferedReader in = new BufferedReader(
                new FileReader("src\\adat\\ud2\\bd\\prueba\\persona\\CrearTabla.sql"))) {

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
