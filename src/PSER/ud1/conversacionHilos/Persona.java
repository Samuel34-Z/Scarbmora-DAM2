package pser.ud1.conversacionHilos;

import java.io.File;

public class Persona extends Thread {
    Espacio lugar;
    String nombre;
    File archivo;

    public Persona(String nombre, Espacio lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    @Override
    public void run() {
        lugar.hablar(nombre);
    }

}
