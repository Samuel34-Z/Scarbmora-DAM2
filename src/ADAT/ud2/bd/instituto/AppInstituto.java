package adat.ud2.bd.instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppInstituto {
    public static void main(String[] args) {
        String url = "jdbc:h2:mem:instituto;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {

            String crearTablaSql = """
                    Create table alumnos(
                    id int primary key auto_increment,
                    nombre varchar(50),
                    apellidos varchar(100),
                    fecha_nacimiento date,
                    curso varchar(100),
                    nota_media decimal(4,2))

                    """;

            System.out.println(stmt.executeUpdate(crearTablaSql));
            stmt.executeUpdate("insert into alumnos values( 1,'Pepe','Perez','2000-12-12','1º DAM',4.3)");
            stmt.executeUpdate("insert into alumnos values(2,'Juan','Martinez','2000-12-12','2º DAM',6.1)");
            stmt.executeUpdate("insert into alumnos values(3,'Marcos','Pereira','2000-12-12','2º DAM',5)");
            stmt.executeUpdate("insert into alumnos values(4,'Marta','Martinez','2000-12-12','1º DAM',8)");
            stmt.executeUpdate("insert into alumnos values(5,'Paco','Fernandez','2000-12-12','2º DAM',9)");

            ResultSet set = stmt.executeQuery("select * from alumnos");

            while (set.next()) {
                System.out.println("Id " + set.getInt("id") + " Nombre " +
                        set.getString("nombre") + " apellidos "
                        + set.getString("apellidos"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
