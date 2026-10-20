package adat.ud2.bd.descatalogado;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class EjemploEvitarInyeccion {
    public static void main(String[] args) {
         insertar(6, "Carlos", "Marno", LocalDate.of(2000, 10, 7), "Bach", 9.2);

        String url = "jdbc:h2:file:./BDs/Instituto/instituto;";
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement()) {

            ResultSet set = st.executeQuery("select * from alumnos");

            while (set.next()) {
                System.out.println("Id " + set.getInt("id") + " Nombre " +
                        set.getString("nombre") + " apellidos "
                        + set.getString("apellidos"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static boolean insertar(int id, String nombre, String apellido, LocalDate fechaNacimiento, String curso,
            Double notaMedia) {

        String url = "jdbc:h2:file:./BDs/Instituto/instituto;";
        String user = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String sql = """
                    Insert into alumnos
                    values(?, ?, ?, ?, ?, ?)
                    """;

            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setDate(4, Date.valueOf(fechaNacimiento));
            sentencia.setString(5, curso);
            sentencia.setDouble(6, notaMedia);

            sentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
