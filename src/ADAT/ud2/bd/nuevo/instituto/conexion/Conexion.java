package adat.ud2.bd.nuevo.instituto.conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {

    private static final String CONFIG_FILE = "src\\adat\\ud2\\bd\\nuevo\\instituto\\conexion\\configSQLite.properties";

    public static Connection getConection() {
        Properties propiedades = new Properties();

        try (FileInputStream fichero = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(fichero);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(propiedades.getProperty("db.url"),
                    propiedades.getProperty("db.user"), propiedades.getProperty("db.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conexion;
    }
}