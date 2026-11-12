package adat.ud2.bd.prueba.persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOimp implements PersonaDAO {
    Connection conexion;

    public PersonaDAOimp(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<PersonaDTO> listarPersonas() {
        List<PersonaDTO> lista = null;
        String sql = """
                select * from persona
                """;

        try {
            ResultSet rs = conexion.createStatement().executeQuery(sql);
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new PersonaDTO(rs.getInt("codigo_persona"), rs.getString("nif"), rs.getString("nombre")));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public PersonaDTO buscarPersona(int codigo) {
        PersonaDTO persona = null;

        String sql = """
                select * from persona where codigo_persona = ?
                """;

        try {
            PreparedStatement sentenciaParametrizada = conexion.prepareStatement(sql);
            sentenciaParametrizada.setInt(1, codigo);

            ResultSet rs = sentenciaParametrizada.executeQuery();

            if (rs.next()) {
                persona = new PersonaDTO(rs.getInt("codigo_persona"), rs.getString("nif"), rs.getString("nombre"));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persona;

    }

    @Override
    public boolean agregarPersona(PersonaDTO persona) {
        boolean personaAgregada = false;
        String sql = """
                insert into persona values (null,?,?)
                """;

        try {
            PreparedStatement sentenciaParametrizada = conexion.prepareStatement(sql);

            sentenciaParametrizada.setString(1, persona.getNif());
            sentenciaParametrizada.setString(2, persona.getNombre());

            personaAgregada = sentenciaParametrizada.executeUpdate() > 0;

            sentenciaParametrizada.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personaAgregada;

    }

    @Override
    public boolean eliminarPersona(int codigo) {
        boolean personaEliminada = false;

        String sql = """
                delete from persona where codigo_persona = ?
                """;

        try {
            PreparedStatement sentenciaParametrizada = conexion.prepareStatement(sql);

            sentenciaParametrizada.setInt(1, codigo);

            personaEliminada = sentenciaParametrizada.executeUpdate() > 0;

            sentenciaParametrizada.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personaEliminada;

    }

    @Override
    public boolean actualizarPersona(PersonaDTO persona) {
        boolean personaActualizada = false;

        String sql = """
                update persona
                set nif = ?,
                nombre = ?
                where codigo_persona = ?
                """;

        try {
            PreparedStatement sentenciaParametrizada = conexion.prepareStatement(sql);

            sentenciaParametrizada.setString(1, persona.getNif());
            sentenciaParametrizada.setString(2, persona.getNombre());
            sentenciaParametrizada.setInt(3, persona.getCodigo_persona());

            personaActualizada = sentenciaParametrizada.executeUpdate() > 0;

            sentenciaParametrizada.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personaActualizada;
    }

}
