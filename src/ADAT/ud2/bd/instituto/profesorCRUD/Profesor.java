package adat.ud2.bd.instituto.profesorCRUD;

import java.util.List;

public interface Profesor {
    public List<ProfesorDTO> listarProfesores();

    public boolean insertarProfesor(ProfesorDTO profesor);

    public ProfesorDTO buscarProfesor(ProfesorDTO profesor);

    public ProfesorDTO buscarProfesor(int id);

    public boolean actualizarProfesor(ProfesorDTO profesor);

    public boolean borrarProfesor(ProfesorDTO profesor);

    public boolean borrarProfesor(int id);

}
