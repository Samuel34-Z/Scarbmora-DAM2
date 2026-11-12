package adat.ud2.bd.prueba.personaProyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import adat.ud2.bd.prueba.Conexion;

public class PrincipalPersonaProyecto {
    private static Scanner sc = new Scanner(System.in);
    private static String tabla = "src\\adat\\ud2\\bd\\prueba\\personaProyecto\\CrearTabla.sql";

    private static Connection con = Conexion.getConection();

    public static void main(String[] args) {

        PersonaProyectoDAOimp personaProyectoDAO = new PersonaProyectoDAOimp(con);
        boolean salir = false;

        do {
            System.out.println("==MENÚ==");
            System.out.println("1.Crear tabla");
            System.out.println("2.Listar todas las personas con proyectos");
            System.out.println("3.Listar los proyectos de una persona");
            System.out.println("4.Listar las personas asociadas a un proyecto");
            System.out.println("5.Agregar proyecto a una persona");
            System.out.println("6.Eliminar proyecto de una persona");
            System.out.println("7.Salir");
            System.out.print("Introduce la operación que desea realizar: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println(crearTabla() ? "Tabla creada con éxito" : "Error creando la tablas");

                    break;

                case 2:
                    List<PersonaProyectoDTO> lista = personaProyectoDAO.listarTodos();

                    for (PersonaProyectoDTO personaProyectoDTO : lista) {

                        System.out.println(personaProyectoDTO.toString());
                    }

                    break;

                case 3:

                    System.out.print("Introduce el código de la persona: ");
                    int codigoPersona = sc.nextInt();
                    sc.nextLine();

                    lista = personaProyectoDAO.listarProyectosConPersona(codigoPersona);

                    for (PersonaProyectoDTO personaProyectoDTO : lista) {
                        System.out.println(personaProyectoDTO.toString());
                    }

                    break;

                case 4:

                    System.out.print("Introduce el código del proyecto: ");
                    int codigoProyecto = sc.nextInt();
                    sc.nextLine();

                    lista = personaProyectoDAO.listarPersonasConProyecto(codigoProyecto);

                    for (PersonaProyectoDTO personaProyectoDTO : lista) {
                        System.out.println(personaProyectoDTO.toString());
                    }

                    break;

                case 5:
                    System.out.print("Introduce el código de la persona: ");
                    codigoPersona = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce el código del proyecto: ");
                    codigoProyecto = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce las horas asignadas: ");
                    int horasAsignadas = sc.nextInt();
                    sc.nextLine();

                    System.out.println(
                            personaProyectoDAO.agregarProyectoAPersona(codigoProyecto, codigoPersona, horasAsignadas)
                                    ? "Proyecto agregado con éxito"
                                    : "Error agregando proyecto");

                    break;

                case 6:
                    System.out.print("Introduce el código de la persona: ");
                    codigoPersona = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Introduce el código del proyecto: ");
                    codigoProyecto = sc.nextInt();
                    sc.nextLine();

                    System.out.println(personaProyectoDAO.quitarProyectoAPersona(codigoProyecto, codigoPersona)
                            ? "Proyecto quitado con éxito"
                            : "Error quitando el proyecto");

                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    sc.close();

                    break;

                default:
                    System.out.println("Opción introducida no válida");
                    break;
            }

        } while (!salir);
    }

    private static boolean crearTabla() {
        boolean tablaCreada = false;

        try (BufferedReader in = new BufferedReader(new FileReader(tabla))) {

            String sql = in.readAllAsString();

            try (Statement sentencia = con.createStatement()) {

                sentencia.execute(sql);
                tablaCreada = true;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tablaCreada;
    }
}
