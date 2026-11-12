package adat.ud2.bd.prueba.coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOimp implements CocheDAO {
    Connection con;

    public CocheDAOimp(Connection con) {
        this.con = con;
    }

    @Override
    public List<CocheDTO> listarCoches() {
        List<CocheDTO> lista = null;

        String sql = """
                select * from coches
                """;

        try (Statement sentencia = con.createStatement()) {

            ResultSet rs = sentencia.executeQuery(sql);

            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new CocheDTO(rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("codigo_propietario")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean agregarCoche(CocheDTO coche) {
        boolean cocheAgregado = false;
        String sql = """
                insert into coches
                values (?,?,?,?)
                """;
        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setString(1, coche.getMatricula());
            sentencia.setString(2, coche.getMarca());
            sentencia.setString(3, coche.getModelo());
            sentencia.setInt(4, coche.getCodigo_propietario());

            cocheAgregado = sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cocheAgregado;
    }

    @Override
    public CocheDTO buscarCoche(String matricula) {
        CocheDTO coche = null;
        String sql = """
                select * from coches
                where matricula = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {

            sentencia.setString(1, matricula);

            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                coche = new CocheDTO(rs.getString("matricula"), rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("codigo_propietario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return coche;
    }

    @Override
    public boolean actualizarCoche(CocheDTO coche) {
        boolean cocheActualizado = false;

        String sql = """
                update coches
                set marca = ?,
                modelo = ?,
                codigo_propietario = ?
                where matricula = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            sentencia.setString(1, coche.getMarca());
            sentencia.setString(2, coche.getModelo());
            sentencia.setInt(3, coche.getCodigo_propietario());
            sentencia.setString(4, coche.getMatricula());

            cocheActualizado = sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cocheActualizado;
    }

    @Override
    public boolean eliminarCoche(String matricula) {
        boolean cocheEliminado = false;
        String sql = """
                delete from coches
                where matricula = ?
                """;

        try (PreparedStatement sentencia = con.prepareStatement(sql)) {
            sentencia.setString(1, matricula);

            cocheEliminado = sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cocheEliminado;
    }

}
