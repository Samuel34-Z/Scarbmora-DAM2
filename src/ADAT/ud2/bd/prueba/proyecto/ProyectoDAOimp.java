package adat.ud2.bd.prueba.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAOimp implements ProyectoDAO {
    Connection con;

    public ProyectoDAOimp(Connection con) {
        this.con = con;
    }

    @Override
    public List<ProyectoDTO> listarProyectos() {
        List<ProyectoDTO> lista = null;

        String sql = """
                select * from proyecto
                """;

        try (Statement sentencia = con.createStatement()) {

            try (ResultSet rs = sentencia.executeQuery(sql)) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(new ProyectoDTO(rs.getInt("codigo_proyecto"), rs.getString("nombre_proyecto"),
                            rs.getDouble("presupuesto")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ProyectoDTO buscarProyecto(int codigoProyecto) {
        ProyectoDTO proyecto = null;

        String sql = """
                select * from proyecto
                where codigo_proyecto = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            sentencia.setInt(1, codigoProyecto);

            try (ResultSet rs = sentencia.executeQuery();) {

                if (rs.next()) {
                    proyecto = new ProyectoDTO(rs.getInt("codigo_proyecto"), rs.getString("nombre_proyecto"),
                            rs.getDouble("presupuesto"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proyecto;
    }

    @Override
    public boolean agregarProyecto(ProyectoDTO proyecto) {
        boolean proyectoAgregado = false;

        String sql = """
                insert into proyecto
                (nombre_proyecto,presupuesto) values (?,?)
                """;

        try (PreparedStatement semtemcia = con.prepareStatement(sql)) {

            semtemcia.setString(1, proyecto.getNombreProyecto());
            semtemcia.setDouble(2, proyecto.getPresupuesto());

            proyectoAgregado = semtemcia.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proyectoAgregado;
    }

    @Override
    public boolean actualizarProyecto(ProyectoDTO proyecto) {
        boolean proyectoActualizado = false;

        String sql = """
                update proyecto
                set nombre_proyecto = ?,
                presupuesto = ?
                where codigo_proyecto = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setString(1, proyecto.getNombreProyecto());
            sentencia.setDouble(2, proyecto.getPresupuesto());
            sentencia.setInt(3, proyecto.getCodigoProyecto());

            proyectoActualizado = sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proyectoActualizado;
    }

    @Override
    public boolean eliminarProyecto(int codigoProyecto) {
        boolean proyectoEliminado = false;

        String sql = """
                delete from proyecto
                where codigo_proyecto = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setInt(1, codigoProyecto);

            proyectoEliminado = sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proyectoEliminado;
    }

}
