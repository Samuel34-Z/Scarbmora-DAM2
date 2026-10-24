package adat.ud2.bd.instituto.materiaCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    private static Connection conexion = Conexion.getConection();

    public static List<MateriaDTO> listarMaterias() {
        List<MateriaDTO> listaMaterias = new ArrayList<>();

        try {
            Statement ejecutor = conexion.createStatement();

            ResultSet rs = ejecutor.executeQuery("select * from materias");
            while (rs.next()) {
                listaMaterias.add(
                        new MateriaDTO(rs.getInt("codigoMateria"), rs.getString("nombre"), rs.getString("siglas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMaterias;
    }

    public static boolean insertarMateria(MateriaDTO materia) {

        String sql = """
                insert into materias
                values
                (DEFAULT,?,?)
                """;

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, materia.getNombre());
            sentencia.setString(2, materia.getSiglas());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static List<MateriaDTO> buscarMateria(int codigoMateria) {

        List<MateriaDTO> materiaResultante = new ArrayList<>();
        String sql = """
                select * from materias
                where id = ?
                """;

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, codigoMateria);

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                materiaResultante.add(new MateriaDTO(rs.getInt("codigoMateria"), rs.getString("nombre"),
                        rs.getString("siglas")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materiaResultante;

    }

    public static boolean actualizarMateria(MateriaDTO materia) {

        String sql = """
                update materias
                set nombre = ?,
                siglas = ?
                where id = ?
                """;

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setString(1, materia.getNombre());
            sentencia.setString(2, materia.getSiglas());
            sentencia.setInt(3, materia.getCodigoMateria());

            return sentencia.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean borrarMateria(int codigoMateria) {

        String sql = """
                delete from materias
                where id = ?
                """;

        try {
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, codigoMateria);

            return sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
