package adat.ud2.bd.prueba.proyecto;

import java.util.List;

public interface ProyectoDAO {

    public List<ProyectoDTO> listarProyectos();

    public ProyectoDTO buscarProyecto(int codigoProyecto);

    public boolean agregarProyecto(ProyectoDTO proyecto);

    public boolean actualizarProyecto(ProyectoDTO proyecto);

    public boolean eliminarProyecto(int codigoProyecto);
}
