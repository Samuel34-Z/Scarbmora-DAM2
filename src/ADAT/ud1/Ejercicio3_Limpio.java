package ADAT.ud1;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author Samuel
 */

public class Ejercicio3_Limpio {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = opcionMenu();

        while (opcion >= 1 && opcion <= 4) {
            switch (opcion) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:

                    File directorio = fileChooser(false, true);
                    int posicion = 0;
                    listar(directorio, posicion);

                    break;
                case 3:
                    directorio = fileChooser(false, false);

                    eliminar(directorio);

                    break;
                case 4:

                    File origen = fileChooser(false, false);

                    File destino = fileChooser(true, false);

                    System.out.println(origen.renameTo(destino) ? "Archivo guardado con exito"
                            : "El archivo no se ha podido guardar");

                    break;
                default:
                    break;
            }
            opcion = opcionMenu();
        }
        sc.close();
    }

    private static File fileChooser(boolean guardar, boolean onlyDirectories) {
        JFileChooser chooser = new JFileChooser();

        if (guardar) {
            chooser.showSaveDialog(null);
        } else {
            chooser.setFileSelectionMode(
                    onlyDirectories ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_AND_DIRECTORIES);
            int selector = chooser.showOpenDialog(null);
            if (selector != JFileChooser.APPROVE_OPTION) {
                throw new IllegalArgumentException("No se cumple el filtro de selección");
            }
        }
        File ruta = chooser.getSelectedFile();

        if (ruta != null) {
            return ruta;
        }

        throw new IllegalAccessError("La ruta no es accesible");

    }

    private static void crearDirectorio() {
        File ruta = fileChooser(true, false);

        ruta = new File(ruta.getAbsolutePath());

        try {
            ruta.mkdir();
        } catch (Exception e) {
            System.out.println("Error creando el directorio " + e.getMessage());
        }

    }

    private static void eliminar(File directorio) {

        if (directorio.isDirectory()) {
            for (File archivo : directorio.listFiles()) {
                eliminar(archivo);
            }
        }
        directorio.delete();
    }

    private static void listar(File directorio, int posicion) {

        for (File archivo : directorio.listFiles()) {
            for (int i = 0; i < posicion; i++) {
                System.out.print("  ");
            }
            if (archivo.isDirectory()) {
                System.out.println(archivo.getName());
                posicion++;
                listar(archivo, posicion);
                posicion--;
            } else {
                System.out.println("-" + archivo.getName());
            }
        }
    }

    private static int opcionMenu() {

        System.out.println("-----Gestor de archivos y directorios-----");
        System.out.println("1- Crear un nuevo directorio");
        System.out.println("2- Listar directorios y archivos");
        System.out.println("3- Eliminar archivo o directorio");
        System.out.println("4- Mover o renombrar archivos o directorios");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        System.out.println("------------------------------------------");
        return opcion;
    }
}
