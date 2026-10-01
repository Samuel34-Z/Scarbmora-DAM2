package adat.ud1.practicas;

import java.io.FileInputStream;
import java.io.IOException;
/**
 * @author Eusebio Moreira Dominguez
 */
public class FirmasHexadecimalesRetocado {
     public static void main(String[] args) {
        

        System.out.println("El archivo archivo.pdf ¿es válido? " + verificarFirma("archivo.pdf"));
        System.out.println("El UD1.Sistema de Ficheiros e Directorios.pdf archivo ¿es válido? " + verificarFirma("UD1.Sistema de Ficheiros e Directorios.pdf"));
        System.out.println("El archivo imagen.png ¿es válido? " + verificarFirma("imagen.png"));
        System.out.println("El archivo foto.jpg ¿es válido? " + verificarFirma("foto.jpg"));
        System.out.println("El archivo foto ¿es válido? " + verificarFirma("foto"));
    }

    public static boolean verificarFirma(String ruta) {
        try (FileInputStream bf = new FileInputStream(ruta)) {
            int str[] = null;

            if (ruta.contains(".pdf")) {
                str = new int[] { 0x25, 0x50, 0x44, 0x46 };
            } else if (ruta.contains(".png")) {
                str = new int[] { 0x89, 0x50, 0x4E, 0x47 };
            } else if (ruta.contains(".jpg")) {
                str = new int[] { 0xFF, 0xD8, 0xFF };
            } else {
                System.out.println("El archivo no contiene ninguna extension valida");
                return false;
            }

            boolean coincide = true;

            for (int i = 0; i < str.length; i++) {
                if (str[i] != bf.read()) {
                    coincide = false;
                    break;
                }
            }

            return coincide;

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
