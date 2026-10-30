package adat.ud2.bd.trabajoDiario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {
    public static boolean executeUpdate(String fichero, Connection conexion) {
        boolean insercionExitosa = false;
        try {
            conexion.setAutoCommit(false);

            BufferedReader in = new BufferedReader(new FileReader(fichero));
            String consulta = in.readAllAsString();
            consulta.split(";");

            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(fichero);
            conexion.commit();
            insercionExitosa = true;
        } catch (SQLException e) {
            System.out.println("Se ha producido un error accediedo a la base de datos " + e.getMessage());
            try {
                conexion.rollback();
            } catch (SQLException eRL) {
                System.out.println("Se ha producido un error al tratar de deshacer la transacción " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero que se está pasando no es accesible por el programa " + e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conexion.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Se ha producido un error al iniciar el auto commit " + e.getMessage());
            }
        }

        return insercionExitosa;
    }
}
