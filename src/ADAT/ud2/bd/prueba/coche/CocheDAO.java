package adat.ud2.bd.prueba.coche;

import java.util.List;

public interface CocheDAO {
    public List<CocheDTO> listarCoches();

    public boolean agregarCoche(CocheDTO coche);

    public CocheDTO buscarCoche(String matricula);

    public boolean actualizarCoche(CocheDTO coche);

    public boolean eliminarCoche(String matricula);
}
