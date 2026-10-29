package pser.ud1.llegaElJefe;

import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private List<Object> personas = new ArrayList<>();
    private boolean estaElJefe = false;

    public Oficina() {
    }

    public void entrar(Jefe jefe) {
        estaElJefe = true;
        personas.add(jefe);
    }

    public void entrar(Empleado empleado) {
        personas.add(empleado);

    }

    public boolean getEstaElJefe() {
        return estaElJefe;
    }

}
