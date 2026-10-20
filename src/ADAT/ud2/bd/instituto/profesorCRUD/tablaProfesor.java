package adat.ud2.bd.instituto.profesorCRUD;

import java.time.LocalDate;
import java.util.List;

public class tablaProfesor {

        public static void main(String[] args) {//TODO trabajar con los nuevos valores
                /*
                 * String url = "jdbc:h2:file:./BDs/Instituto/instituto;";
                 * String user = "sa";
                 * String password = "";
                 * 
                 * try (Connection conexion = DriverManager.getConnection(url, user, password);
                 * Statement ejecutor = conexion.createStatement()) {
                 * 
                 * String crearTablasProfesores = """
                 * Create table profesores(
                 * id int primary key auto_increment,
                 * nombre VARCHAR (50),
                 * apellidos VARCHAR (100),
                 * fecha_nacimiento DATE
                 * )
                 * """;
                 * System.out.println(ejecutor.executeUpdate(crearTablasProfesores));
                 */

                /*
                 * String sql =
                 * "INSERT INTO profesores VALUES (0, 'Pepe', 'García', '2000-12-12')";
                 * ejecutor.executeUpdate(sql);
                 * sql = "INSERT INTO profesores VALUES (1, 'Marta', 'Castro', '2001-2-12')";
                 * ejecutor.executeUpdate(sql);
                 * sql = "INSERT INTO profesores VALUES (2, 'Lolo', 'Martínez', '2002-1-12')";
                 * ejecutor.executeUpdate(sql);
                 * sql = "INSERT INTO profesores VALUES (3, 'Lola', 'López', '2003-4-20')";
                 * ejecutor.executeUpdate(sql);
                 * sql = "INSERT INTO profesores VALUES (4, 'Juan', 'Vázquez', '2004-5-10')";
                 * ejecutor.executeUpdate(sql);
                 * 
                 * 
                 * 
                 * 
                 * } catch (Exception e) {
                 * e.printStackTrace();
                 * }
                 */

                ProfesorDAO dao = new ProfesorDAO();
                // Create
                System.out.println("CREATE");
                System.out.println("======");
                ProfesorDTO profesor = new ProfesorDTO(5, "Manuel", "López",
                                LocalDate.of(2000, 1, 1));

                String isInserted = dao.insertarProfesor(profesor) ? "Profesor insertado correctamente"
                                : "Error de inserción de profesor";
                System.out.println(isInserted);

                // Read
                System.out.println("READ");
                System.out.println("====");

                System.out.println("\n-Listado");
                List<ProfesorDTO> lista = dao.listarProfesores();

                for (ProfesorDTO profesorDTO : lista) {
                        System.out.println(profesorDTO.toString());
                }

                System.out.println("\n-Busqueda(id)");
                System.out.println(dao.buscarProfesor(5).toString()); // Manuel

                System.out.println("\n-Busqueda(objeto)");
                System.out.println(dao.buscarProfesor(profesor).toString()); // Manuel

                // Update
                System.out.println("UPDATE");
                System.out.println("======");
                profesor = new ProfesorDTO(5, "Juan", "Perez", LocalDate.of(2010, 1, 1));
                System.out.println(dao.actualizarProfesor(profesor) ? "Profesor actualizado correctamente"
                                : "Error actualizando el profesor");
                System.out.println(dao.buscarProfesor(profesor));

                // Delete
                System.out.println("DELETE");
                System.out.println("=====");

                System.out.println("\n-Borrado(id)");
                System.out.println(
                                dao.borrarProfesor(5) ? "Profesor borrado correctamente"
                                                : "Error borrando el profesor");
                lista = dao.listarProfesores();

                for (ProfesorDTO profesorDTO : lista) {
                        System.out.println(profesorDTO.toString());
                }

                System.out.println("\n-Borrado(objeto)");
                profesor = new ProfesorDTO(5, "Manuel", "López",
                                LocalDate.of(2000, 1, 1));

                dao.insertarProfesor(profesor);

                System.out.println(
                                dao.borrarProfesor(profesor) ? "Profesor borrado correctamente"
                                                : "Error borrando el profesor");

                lista = dao.listarProfesores();

                for (ProfesorDTO profesorDTO : lista) {
                        System.out.println(profesorDTO.toString());
                }

        }
}
