package adat.ud2.bd.prueba.coche;

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

public class PrincipalCoche {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        Connection con = Conexion.getConection();
        CocheDAOimp cocheDAO = new CocheDAOimp(con);
        do {
            System.out.println("==MENÚ==");
            System.out.println("1.Crear tabla");
            System.out.println("2.Agregar coche");
            System.out.println("3.Listar coches");
            System.out.println("4.Buscar coche");
            System.out.println("5.Actualizar coche");
            System.out.println("6.Eliminar coche");
            System.out.println("7.Salir");
            System.out.print("Introduce la operación que desea realizar: ");
            int operacion = sc.nextInt();
            sc.nextLine();

            switch (operacion) {
                case 1:
                    boolean tablaCreada = false;
                    try (BufferedReader in = new BufferedReader(
                            new FileReader("src\\adat\\ud2\\bd\\prueba\\coche\\crearTabla.sql"))) {

                        String sql = in.readAllAsString();

                        Statement sentencia = con.createStatement();
                        sentencia.execute(sql);
                        tablaCreada = true;

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out
                            .println(tablaCreada ? "Tabla creada con éxito" : "Error creando la tabla");
                    break;

                case 2:
                    CocheDTO coche = pedirDatosCoche();

                    boolean cocheAgregado = cocheDAO
                            .agregarCoche(coche);

                    System.out.println(cocheAgregado ? "Coche agregado con éxito" : "Error agregando el coche");

                    break;

                case 3:
                    List<CocheDTO> lista = cocheDAO.listarCoches();

                    for (CocheDTO cocheDTO : lista) {
                        System.out.println(cocheDTO.toString());
                    }
                    break;
                case 4:

                    System.out.print("Introduce la matrícula del coche: ");
                    String matricula = sc.nextLine();
                    coche = cocheDAO.buscarCoche(matricula);

                    if (coche == null) {
                        System.out.println("No se ha encontrado esa matrícula");
                    } else {
                        System.out.println(coche.toString());
                    }

                    break;
                case 5:
                    coche = pedirDatosCoche();
                    System.out.println(cocheDAO.actualizarCoche(coche) ? "Coche actualizado con éxito"
                            : "Error actualizando coche");
                    break;

                case 6:

                    System.out.print("Introduce la matricula del coche a eliminar: ");
                    matricula = sc.nextLine();
                    System.out.println(cocheDAO.eliminarCoche(matricula) ? "Coche eliminado con éxito"
                            : "Error al eliminar coche");

                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Opción introducida no válida");
                    break;
            }
        } while (!salir);
    }

    private static CocheDTO pedirDatosCoche() {
        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Introduce la marca: ");
        String marca = sc.nextLine();
        System.out.print("Introduce el modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Introduce el codigo del propietario: ");
        int codigoPropietario = sc.nextInt();
        CocheDTO coche = new CocheDTO(matricula, marca, modelo, codigoPropietario);
        return coche;
    }
}
