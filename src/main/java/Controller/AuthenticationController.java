/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AuthenticationUser;
import model.Usuario;
import resource.ConexionBD;

/**
 *
 * @author Juan Zuluaga
 */
public class AuthenticationController {

    private Connection connection;
    ConexionBD conn = new ConexionBD();

    public AuthenticationController() {
        connection = conn.connectMYSQL();
    }

    public AuthenticationUser searchByTipoUsuarioAndId(String tipoUser, int idUsuario) {
        AuthenticationUser user = null;
        ConexionBD conn = new ConexionBD();

        String consultaSQL = "SELECT * FROM usuario WHERE tipoUsuario = ? AND id= ?";

        try (Connection connection = conn.connectMYSQL(); PreparedStatement statement = connection.prepareStatement(consultaSQL)) {

            // Asigna valores a los parámetros en la consulta
            statement.setString(1, tipoUser);
            statement.setInt(2, idUsuario);

            // Ejecuta la consulta y obtén los resultados
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Construye un objeto Usuario con los resultados
                    user = new AuthenticationUser();
                    user.setId(resultSet.getInt("id"));
                    user.setTipoUSer(resultSet.getString("tipoUsuario"));
                    System.out.println("Datos del usuario: " + user.toString());

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones, por ejemplo, log o notificación de error
        }

        return user;
    }
}
