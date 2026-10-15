package adat.ud1.examen;

import java.io.BufferedReader;
import java.io.FileReader;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
/**
 * @author Samuel
 * MeteogaliciaTemperaturaConcello
 */
public class MeteogaliciaTemperaturaConcello {

    public static void main(String[] args) {
        String cadena;
        JsonMapper mapper = new JsonMapper();

        

        try (BufferedReader in = new BufferedReader(new FileReader("DATOS\\observacionConcellos.json"))) {

            mapper.readValue(in.readLine(), null);
        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

    

    }

    public static Double temperaturaConcello(String jsonObservacion, String concello) {


        return null;
    }
}
