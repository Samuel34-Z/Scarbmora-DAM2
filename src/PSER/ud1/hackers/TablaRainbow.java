package pser.ud1.hackers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablaRainbow {
    private static String url = "jdbc:sqlite:mem:hackersdb;DB_CLOSE_DELAY=-1";
    private static String user = "sa";
    private static String password = "";

    private static TablaRainbow INSTANCE = null;

    private TablaRainbow() {
        crearTabla();
    }

    private synchronized static void crearTablaRainbow() {
        if (INSTANCE == null) {
            INSTANCE = new TablaRainbow();
        }
    }

    public static TablaRainbow getTablaRainbow() {
        if (INSTANCE == null) {
            crearTablaRainbow();
        }
        return INSTANCE;
    }

    private static Connection getConection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    private void crearTabla() {
        String sql = """
                Create table if not exists tablaRainbow(
                    clave text primary key,
                    hash text,
                    usos int
                )
                """;

        try (Statement sentencia = getConection().createStatement()) {
            sentencia.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String obtenerHash(String cadena) {
        String hash = "";

        return hash;

    }
}