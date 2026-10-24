package adat.ud2.bd.instituto.materiaCRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class mainMateria {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

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
                    System.out.println(crearTabla() ? "Tabla creada con éxito" : "Error de creación de tabla");
                    break;
                case 1:
                    insertarMateria();
                    break;
                case 2:
                    listarMaterias();
                    break;
                case 3:
                    buscarMateria();
                    break;
                case 4:
                    actualizarMateria();
                    break;
                case 5:
                    eliminarMateria();
                    break;
                case 6:
                    sc.close();
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    llamadaErronea();
                    break;
            }
        } while (true);
    }

    private static void eliminarMateria() {
        System.out.println("Introduce el código de la materia a eliminar");
        int codigo = sc.nextInt();
        System.out
                .println(MateriaDAO.borrarMateria(codigo) ? "Materia eliminada con éxito" : "Error eliminando materia");
    }

    private static void actualizarMateria() {
        System.out.println("Introduzca el código de la materia");
        int codigo = sc.nextInt();
        System.out.println("Introduzca el nombre de la materia");
        String nombre = sc.nextLine();
        System.out.println("Introduzca las siglas de la materia");
        String siglas = sc.nextLine();
        System.out.println(MateriaDAO.actualizarMateria(new MateriaDTO(codigo, nombre, siglas))
                ? "Materia actualizada correctamente"
                : "Error actualizando materia");
        ;
    }

    private static void buscarMateria() {
        System.out.println("Introduce el código de materia");
        int codigo = sc.nextInt();
        List<MateriaDTO> materias = MateriaDAO.buscarMateria(codigo);
        if (materias.size() == 0) {
            System.out.println("Materias con ese código");
            for (MateriaDTO materiaDTO : materias) {
                System.out.println(materiaDTO.toString());
            }
        } else {
            System.out.println("No existen materias con ese código");
        }
    }

    private static void listarMaterias() {
        List<MateriaDTO> lista = MateriaDAO.listarMaterias();

        for (MateriaDTO materiaDTO : lista) {
            System.out.println(materiaDTO.toString());
        }
    }

    private static void insertarMateria() {
        System.out.println("Introduce el nombre de la materia");
        String nombre = sc.nextLine();
        System.out.println("Introduce las siglas de la materia");
        String siglas = sc.nextLine();
        System.out.println(MateriaDAO.insertarMateria(new MateriaDTO(nombre, siglas)) ? "Materia insertada con éxito"
                : "Error de inserción de materia");

    }

    private static boolean crearTabla() {
        Connection conexion = Conexion.getConection();

        try (Statement ejecutor = conexion.createStatement()) {
            String sql = """
                        create table if not exists materias(
                        codigoMateria int primary key auto_increment,
                        nombre varchar(150),
                        siglas varchar(15)
                    )
                    """;
            return ejecutor.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void llamadaErronea() {
        System.out.println("Valor introducido no válido");
    }

}
