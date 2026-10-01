package adat.ud1.flujosBinarios;

import java.io.FileInputStream;

/**
 * @author Samuel
 */

public class FirmasHexadecimales {
    public static void main(String[] args) {

        String origen = "F:\\scarbmora\\DAM2\\ADAT\\apuntes\\Excepciones.pdf";

        try (FileInputStream in = new FileInputStream(origen);) {

            String extension = origen.substring(origen.lastIndexOf(".") + 1);

            switch (extension) {
                case "pdf":

                    byte[] numerosMagicos = in.readNBytes(4);
                    int[] firma = { 0x25, 0x50, 0x44, 0x46 };
                    verificarExtension(numerosMagicos, firma, extension);

                    break;
                case "png":
                    numerosMagicos = in.readNBytes(4);
                    firma = new int[] { 0x89, 0x50, 0x4E, 0x47 };
                    verificarExtension(numerosMagicos, firma, extension);
                    break;

                case "jpg":
                    numerosMagicos = in.readNBytes(2);
                    firma = new int[] { 0xFF, 0xD8 };
                    verificarExtension(numerosMagicos, firma, extension);
                    break;
                default:
                    System.out.println("Extensión no soportada");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error" + e.getMessage());
        }
    }

    private static void verificarExtension(byte[] numerosMagicos, int[] firma, String extension) {
        boolean continuar = true;

        for (int i = 0; i < numerosMagicos.length && continuar; i++) {
            if (firma[i] != ((byte) numerosMagicos[i])) {
                continuar = false;
            }
        }
        System.out.println(
                continuar ? "El archivo se trata de un " + extension : "El archivo no se trata de un " + extension);
    }
}
