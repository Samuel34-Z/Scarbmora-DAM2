package adat.ud2.bd.instituto.materiaCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearMateriaProfesor {

    public static void main(String[] args) {
        Connection conexion = Conexion.getConection();
        try (Statement ejecutor = conexion.createStatement()) {

            String sql = """
                        create  table if not exists materiaProfesor (
                        int codigoMateria,
                        int codigoProfesor,
                        Primary key (codigoMateria, codigoProfesor)
                        )
                    """;

            ejecutor.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
