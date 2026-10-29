package adat.ud2.bd.nuevo.instituto.sql;

import java.io.FileReader;
import java.io.IOException;

public class DevolverConsulta {

    public static String getConsulta(String fichero) {
        try (FileReader in = new FileReader(fichero);) {
            return in.readAllAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
