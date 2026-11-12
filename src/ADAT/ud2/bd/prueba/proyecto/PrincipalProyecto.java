package adat.ud2.bd.prueba.proyecto;

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

public class PrincipalProyecto {
    private static Scanner sc = new Scanner(System.in);
    private static String tabla = "src\\adat\\ud2\\bd\\prueba\\proyecto\\CrearTabla.sql";
    private static Connection con = Conexion.getConection();

    public static void main(String[] args) {

        boolean salir = false;

        ProyectoDAOimp proyectoDAO = new ProyectoDAOimp(con);

        do {

            System.out.println("==MENÚ==");
            System.out.println("1.Crear tabla");
            System.out.println("2.Listar proyectos");
            System.out.println("3.Buscar proyecto");
            System.out.println("4.Actualizar proyecto");
            System.out.println("5.Eliminar proyecto");
            System.out.println("6.Agregar proyecto");
            System.out.println("7.Salir");
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
                    List<ProyectoDTO> listaProyectos = proyectoDAO.listarProyectos();

                    for (ProyectoDTO proyectoDTO : listaProyectos) {
                        System.out.println(proyectoDTO.toString());
                    }

                    break;

                case 3:

                    int codigoProyecto = pedirCodigoProyecto();

                    ProyectoDTO proyecto = proyectoDAO.buscarProyecto(codigoProyecto);

                    if (proyecto != null) {
                        System.out.println(proyecto.toString());
                    } else {
                        System.out.println("No se ha encontrado ningún proyecto con ese código");
                    }

                    break;

                case 4:

                    proyecto = pedirProyecto(true);

                    System.out.println(proyectoDAO.actualizarProyecto(proyecto) ? "Proyecto actualizado con éxito"
                            : "Error actualizando el proyecto");

                    break;

                case 5:
                    codigoProyecto = pedirCodigoProyecto();

                    System.out.println(proyectoDAO.eliminarProyecto(codigoProyecto) ? "Proyecto eliminado con éxito"
                            : "Error eliminando proyecto");

                    break;

                case 6:
                    proyecto = pedirProyecto(false);

                    System.out.println(proyectoDAO.agregarProyecto(proyecto) ? "Proyecto agregado con éxito"
                            : "Error agregando proyecto");

                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    sc.close();
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;

                default:
                    System.out.println("Opción elegida incorrecta");
                    break;
            }

        } while (!salir);
    }

    private static ProyectoDTO pedirProyecto(boolean codigo) {
        int codigoProyecto = -1;
        if (codigo) {

            codigoProyecto = pedirCodigoProyecto();
        }
        ProyectoDTO proyecto = null;

        System.out.print("Introduce el nombre del proyecto: ");
        String nombreProyecto = sc.nextLine();
        System.out.print("Introduce el presupuesto: ");
        double presupuestoProyecto = sc.nextDouble();
        sc.nextLine();
        if (codigo) {
            proyecto = new ProyectoDTO(codigoProyecto, nombreProyecto, presupuestoProyecto);
        } else {
            proyecto = new ProyectoDTO(nombreProyecto, presupuestoProyecto);
        }

        return proyecto;

    }

    private static int pedirCodigoProyecto() {
        System.out.print("Introduce el código del proyecto: ");
        int codigoProyecto = sc.nextInt();
        sc.nextLine();

        return codigoProyecto;
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
