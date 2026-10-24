package adat.ud2.bd.instituto.materiaCRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConection() {
        String url = "jdbc:h2:file:./BDs/Instituto/instituto";
        String user = "sa";
        String password = "";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexion;
    }
}
