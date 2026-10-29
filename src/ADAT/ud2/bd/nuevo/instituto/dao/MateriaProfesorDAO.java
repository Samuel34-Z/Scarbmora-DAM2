package adat.ud2.bd.nuevo.instituto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import adat.ud2.bd.nuevo.instituto.conexion.Conexion;
import adat.ud2.bd.nuevo.instituto.dto.MateriaDTO;
import adat.ud2.bd.nuevo.instituto.dto.ProfesorDTO;

public class MateriaProfesorDAO {

    public List<MateriaDTO> materiasImparte(int codigoProfesor) {
        List<MateriaDTO> lista = null;
        Connection conexion = Conexion.getConection();
        String sql = """
                select * from materias m
                join materiaProfesor mp on mp.codigo_Materia = m.codigo_Materia
                where codigo_Profesor = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.setInt(1, codigoProfesor);

            ResultSet rs = sentencia.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new MateriaDTO(rs.getInt("codigo_Materia"), rs.getString("nombre"), rs.getString("siglas")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;

    }

    public List<ProfesorDTO> profesoresDan(int codigoMateria) {

        List<ProfesorDTO> lista = null;

        Connection conexion = Conexion.getConection();

        String sql = """
                select * from profesores p
                join materiaProfesor mp on mp.codigo_Profesor = p.codigo_Profesor
                where codigo_Materia = ?
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, codigoMateria);

            ResultSet rs = sentencia.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(new ProfesorDTO(rs.getInt("codigo_Profesor"), rs.getString("nombre"),
                        rs.getString("apellidos"), Date.valueOf(rs.getString("fecha_Nacimiento")).toLocalDate(),
                        rs.getString("direccion"), rs.getString("telefono")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Boolean agregarProfesor(int codigoMateria, int codigoProfesor) {

        Connection conexion = Conexion.getConection();

        if (ProfesorDAO.buscarProfesor(codigoProfesor) == null || MateriaDAO.buscarMateria(codigoMateria) == null) {
            return false;
        }

        String sql = """
                insert into materiaProfesor (codigo_Materia,codigo_Profesor)
                values (?,?)
                """;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, codigoMateria);
            sentencia.setInt(2, codigoProfesor);

            return sentencia.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
