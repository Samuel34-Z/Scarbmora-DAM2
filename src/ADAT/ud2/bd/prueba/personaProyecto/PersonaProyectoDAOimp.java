package adat.ud2.bd.prueba.personaProyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaProyectoDAOimp implements PersonaProyectoDAO {

    Connection con;

    public PersonaProyectoDAOimp(Connection con) {
        this.con = con;
    }

    @Override
    public List<PersonaProyectoDTO> listarTodos() {
        List<PersonaProyectoDTO> lista = null;
        String sql = """
                select * from persona_proyecto
                """;

        try (Statement sentencia = con.createStatement()) {

            try (ResultSet rs = sentencia.executeQuery(sql);) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(new PersonaProyectoDTO(rs.getInt("codigo_persona"), rs.getInt("codigo_proyecto"),
                            rs.getInt("horas_asignadas")));
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Se ha producido un error en la base de datos " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public List<PersonaProyectoDTO> listarProyectosConPersona(int codigoPersona) {
        List<PersonaProyectoDTO> lista = null;

        String sql = """
                select * from persona_proyecto
                where codigo_persona = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setInt(1, codigoPersona);

            try (ResultSet rs = sentencia.executeQuery()) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(new PersonaProyectoDTO(rs.getInt("codigo_persona"), rs.getInt("codigo_proyecto"),
                            rs.getInt("horas_asignadas")));
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Se ha producido un error en la base de datos " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public List<PersonaProyectoDTO> listarPersonasConProyecto(int codigoProyecto) {
        List<PersonaProyectoDTO> lista = null;

        String sql = """
                select * from persona_proyecto
                where codigo_proyecto = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setInt(1, codigoProyecto);

            try (ResultSet rs = sentencia.executeQuery()) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(new PersonaProyectoDTO(rs.getInt("codigo_persona"), rs.getInt("codigo_proyecto"),
                            rs.getInt("horas_asignadas")));
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Se ha producido un error en la base de datos " + e.getMessage(), e);
        }

        return lista;
    }

    @Override
    public boolean agregarProyectoAPersona(int codigoProyecto, int codigoPersona, int horasAsignadas) {
        boolean proyectoAgregado = false;

        String sql = """
                insert into persona_proyecto
                (codigo_persona,codigo_proyecto,horas_asignadas)
                values(?,?,?)
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setInt(1, codigoPersona);
            sentencia.setInt(2, codigoProyecto);
            sentencia.setInt(3, horasAsignadas);

            proyectoAgregado = sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Se ha producido un error en la base de datos " + e.getMessage(), e);
        }

        return proyectoAgregado;
    }

    @Override
    public boolean quitarProyectoAPersona(int codigoProyecto, int codigoPersona) {
        boolean proyectoQuitado = false;

        String sql = """
                delete from persona_proyecto
                where codigo_persona = ? and codigo_proyecto = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setInt(1, codigoPersona);
            sentencia.setInt(2, codigoProyecto);

            proyectoQuitado = sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new ExceptionDAO("Se ha producido un error en la base de datos " + e.getMessage(), e);
        }

        return proyectoQuitado;
    }

}
