/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Zuluaga
 */
public class ConexionBD {

    public Connection connectMYSQL() {
        Connection conn = null;
        String url = "jdbc:mariadb://localhost:3306/cadenasuministros";
        String usuario = "root";
        String contrasena = "admin";

        try {
            conn = DriverManager.getConnection(url, usuario, contrasena);

            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos MySQL.");
//                conn.close(); 
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }

    public void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}
