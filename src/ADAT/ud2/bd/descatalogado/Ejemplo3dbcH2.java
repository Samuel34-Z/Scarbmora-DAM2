package adat.ud2.bd.descatalogado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo3dbcH2 {
    public static void main(String[] args) {
        // URL de conexión para H2 en memoria
        // DB_CLOSE_DELAY=-1 mantiene la BD activa mientras la JVM esté viva

        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "";

        // Conexión con try-resources. Se cierra automáticamente
        // si no sería conn.close() y stmt.close()
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {
            // Crear una tabla de ejemplo
            stmt.execute("CREATE TABLE users(id INT PRIMARY KEY, name VARCHAR(50))");
            System.out.println("✅ Tabla creada con éxito.");
            // Insertar datos
            stmt.executeUpdate("INSERT INTO users VALUES(1, 'Pepe')");
            ResultSet set = stmt.executeQuery("select * from users");

            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                System.out.println("Usuario " + id + " Nombre " + name);
            }

            System.out.println("✅ Datos insertados.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
