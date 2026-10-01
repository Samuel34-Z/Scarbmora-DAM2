package adat.ud1.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel
 */
public class SerializandoColecciones {
    public static void main(String[] args) {
        File archivo = new File("coleccionPersonas.dat");
        ColeccionPersonas coleccion = new ColeccionPersonas();

        if (archivo.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
                coleccion = (ColeccionPersonas) in.readObject();

            } catch (Exception e) {
                System.out.println("Se ha producido un error " + e.getMessage());
            }
        }

        coleccion.add(new Persona2("Pepe", 40));
        coleccion.add(new Persona2("Carlos", 18));
        coleccion.add(new Persona2("Marta", 35));

        System.out.println(coleccion.toString());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(coleccion);
        } catch (Exception e) {
            System.out.println("Se ha producido un error " + e.getMessage());
        }

    }
}

class ColeccionPersonas implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Persona2> lista;

    public ColeccionPersonas() {
        lista = new ArrayList<>();
    }

    public void add(Persona2 persona) {
        lista.add(persona);
    }

    @Override
    public String toString() {
        String caneda = "";
        for (Persona2 persona : lista) {
            caneda += persona.toString() + "\n";
        }
        return caneda;
    }

}