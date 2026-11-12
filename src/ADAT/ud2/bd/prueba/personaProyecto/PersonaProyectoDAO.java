package adat.ud2.bd.prueba.personaProyecto;

import java.util.List;

public interface PersonaProyectoDAO {

    public List<PersonaProyectoDTO> listarTodos();

    public List<PersonaProyectoDTO> listarProyectosConPersona(int codigoPersona);

    public List<PersonaProyectoDTO> listarPersonasConProyecto(int codigoProyecto);

    public boolean quitarProyectoAPersona(int codigoProyecto, int codigoPersona);

    boolean agregarProyectoAPersona(int codigoProyecto, int codigoPersona, int horasAsignadas);

}
