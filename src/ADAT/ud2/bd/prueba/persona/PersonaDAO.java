package adat.ud2.bd.prueba.persona;

import java.util.List;

public interface PersonaDAO {
    public List<PersonaDTO> listarPersonas();

    public PersonaDTO buscarPersona(int codigo);

    public boolean agregarPersona(PersonaDTO persona);

    public boolean eliminarPersona(int codigo);

    public boolean actualizarPersona(PersonaDTO persona);
}
