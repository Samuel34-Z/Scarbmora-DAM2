package adat.ud2.bd.instituto.profesorCRUDog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class crearTabla {
    public static void main(String[] args) {
        String url = "jdbc:h2:file:./BDs/Instituto/instituto;";
        String user = "sa";
        String password = "";

        try (
                Connection conexion = DriverManager.getConnection(url, user, password);
                Statement ejecutor = conexion.createStatement()) {

            String crearTablasProfesores = """
                    Create table profesores(
                    id int primary key auto_increment,
                    nombre VARCHAR (50),
                    apellidos VARCHAR (100),
                    fecha_nacimiento DATE
                    )
                    """;
            System.out.println(ejecutor.executeUpdate(crearTablasProfesores));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
