package pser.ud1.hackers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public synchronized String obtenerHash(String clave) {
        String hash = null;
        String sql = """
                select hash from tablaRainbow
                where clave = ?
                """;

        try (PreparedStatement sentencia = getConection().prepareStatement(sql)) {
            sentencia.setString(1, clave);

            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                hash = rs.getString("hash");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hash;

    }

    public synchronized void agregarHash(String clave, String hash) {
        String sql = """
                insert into tablaRainbow
                (clave,hash,usos)
                values (?,?,1)
                """;// TODO cambiar X por un select de usos o en su defecto ponerlo a 1

        try (PreparedStatement sentecia = getConection().prepareStatement(sql)) {
            sentecia.setString(1, clave);
            sentecia.setString(2, hash);
            sentecia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}