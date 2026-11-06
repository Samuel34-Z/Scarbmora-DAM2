package adat.ud2.bd.prueba;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOimp implements PersonaDAO {

    @Override
    public List<PersonaDTO> listarPersonas() {
        List<PersonaDTO> lista = null;
        String sql = """
                select * from persona
                """;

        try {
            ResultSet rs = Conexion.getConection().createStatement().executeQuery(sql);
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new PersonaDTO(rs.getInt("codigo_persona"), rs.getString("nif"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public PersonaDTO buscarPersona(int codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPersona'");
    }

    @Override
    public boolean agregarPersona(PersonaDTO persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarPersona'");
    }

    @Override
    public boolean eliminarPersona(int codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPersona'");
    }

    @Override
    public boolean actualizarPersona(PersonaDTO persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPersona'");
    }

}
