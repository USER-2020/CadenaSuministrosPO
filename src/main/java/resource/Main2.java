/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan Zuluaga
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD conexionBD = new ConexionBD();
        Connection conn = conexionBD.connectMYSQL();

        if (conn != null) {
            System.out.println("Conexión exitosa a la base de datos MySQL.");

            try {
                // Consulta SQL para recuperar todos los productos
                String consulta = "SELECT * FROM Product";
                PreparedStatement statement = conn.prepareStatement(consulta);
                ResultSet result = statement.executeQuery();

                // Recorrer los resultados y mostrarlos en la consola
                while (result.next()) {
                    int numeroSerial = result.getInt("numeroSerial");
                    String descripcion = result.getString("descripcion");
                    String nombre = result.getString("nombre");
                    // Obtener otros campos aquí

                    System.out.println("Número de Serie: " + numeroSerial);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("Nombre: " + nombre);
                    // Mostrar otros campos aquí
                }
            } catch (SQLException e) {
                System.err.println("Error al realizar la consulta: " + e.getMessage());
            } finally {
                conexionBD.cerrarConexion(conn);
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }

}
