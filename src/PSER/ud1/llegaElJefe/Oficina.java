package pser.ud1.llegaElJefe;

import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private List<Object> personas = new ArrayList<>();
    private boolean estaElJefe = false;

    public Oficina() {
    }

    public synchronized void entrar(Object persona) {
        if (persona instanceof Jefe) {
            System.out.println("EL JEFE HA LLEGADO!");
            Jefe jefe = (Jefe) persona;
            estaElJefe = true;
            notifyAll();
            personas.add(jefe);

        } else {
            Empleado empleado = (Empleado) persona;
            entrarEmpleado(persona);
            personas.add(empleado);
        }

    }

    private void entrarEmpleado(Object empleado) {
        if (getEstaElJefe() == true) {
            System.out.println("Hola jefe!, me pongo a trabajar...");
        } else {
            System.out.println("ZZZZZZ");
            synchronized (this) {
                try {
                    wait();
                    System.out.println("buenos días jefe, aquí estoy trabajando");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean getEstaElJefe() {
        return estaElJefe;
    }

}
