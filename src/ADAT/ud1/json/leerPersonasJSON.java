package adat.ud1.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class leerPersonasJSON {
    public static void main(String[] args) {
        Gson gson = new Gson();
        ObjectMapper jakson = new ObjectMapper();

        try {
            Persona[] personas = gson.fromJson(new FileReader("DATOS/personas.json"), Persona[].class);
            System.out.println(Arrays.toString(personas));
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Persona[] personas2 = jakson.readValue(new FileReader("DATOS/personas.json"), Persona[].class);
            System.out.println(Arrays.toString(personas2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
