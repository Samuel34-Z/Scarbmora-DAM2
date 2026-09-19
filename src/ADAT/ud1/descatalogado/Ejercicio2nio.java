package ADAT.ud1.descatalogado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

public class Ejercicio2nio {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int selector = chooser.showOpenDialog(null);

        try {
            if (selector == JFileChooser.APPROVE_OPTION) {
                Path path = chooser.getSelectedFile().toPath();

                try (Stream<Path> stream = Files.list(path)) {

                    stream.forEach(System.out::println);// imprime todos los path del stream

                }
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

    }
}
