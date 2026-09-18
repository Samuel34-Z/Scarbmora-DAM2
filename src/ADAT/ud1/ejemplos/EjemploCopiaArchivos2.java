package ADAT.ud1.ejemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class EjemploCopiaArchivos2 {

    public static void main(String[] args) throws IOException {
        File origen = null;
        File destino = null;

        JFileChooser chooser = new JFileChooser(".");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            origen = chooser.getSelectedFile();
        }

        chooser = new JFileChooser(".");
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            destino = chooser.getSelectedFile();
        }

        try (var in = new BufferedInputStream(new FileInputStream(origen));
                var out = new BufferedOutputStream(new FileOutputStream(destino));) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");

        } catch (IOException e) {
            System.out.println("Error E/S");
        }
    }
}
