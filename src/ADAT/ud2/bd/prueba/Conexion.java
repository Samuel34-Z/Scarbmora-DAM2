package adat.ud2.bd.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String url = "jdbc:sqlite:file:./BDs/prueba/prueba.sqlite";
    private static String user = "sa";
    private static String password = "";

    public static Connection getConection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
