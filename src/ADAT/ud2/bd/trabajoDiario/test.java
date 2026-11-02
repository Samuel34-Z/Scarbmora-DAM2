package adat.ud2.bd.trabajoDiario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new FileReader("src\\adat\\ud2\\bd\\trabajoDiario\\BD\\datosPrueba.sql"));) {

            String consulta = in.readAllAsString();
            String[] consultas = consulta.split(";");

            for (int i = 0; i < consultas.length; i++) {
                String cadena = consultas[i];
                cadena = cadena.substring(0, cadena.length()) +";";
                System.out.println(cadena);
            }

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
