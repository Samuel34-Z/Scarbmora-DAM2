package ADAT.ud1;

import java.io.File;
import java.io.FileInputStream;
import java.util.HexFormat;

/**
 * @author Samuel
 */

public class FirmasHexadecimales {
    public static void main(String[] args) {
        File origen = new File("DATOS\\UD1.Sistema de ficheiros e directorios.pdf");
        try (FileInputStream in = new FileInputStream(origen);) {
            int primerosBytes = in.read();
            int segundosBytes = in.read();
           // HexFormat test = HexFormat.of();
            String cadenaEnteros = (primerosBytes + "" + Integer.toString(segundosBytes).substring(0, 1));
            int entero = Integer.valueOf(cadenaEnteros);
            System.out.println(entero);
            //System.out.println(Integer.toHexString(entero));
            
            Integer.toHexString(entero);

            //System.out.println(test.toHexDigits(hexadecimal));
        } catch (Exception e) {
            System.out.println("Se ha producido un error" + e.getMessage());
        }
    }
}
