/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Bodeguero;
import model.Usuario;
import resource.ConexionBD;

/**
 *
 * @author Juan Zuluaga
 */
public class UserController implements ICRUD {

//    public static ArrayList<Usuario> arregloUsuarios = new ArrayList<Bodeguero>();
    private Connection connection;
    ConexionBD conn = new ConexionBD();

    public UserController() {
        connection = conn.connectMYSQL();
    }

    private List<Usuario> usuarios;

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = false;
        Usuario user = (Usuario) obj;
        String consultaSQL = "INSERT INTO usuario (id, tipoUsuario, nombre, apellido, direccion, cellphone, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getTipoUSer());
            statement.setString(3, user.getNombre());
            statement.setString(4, user.getApellido());
            statement.setString(5, user.getDireccion());
            statement.setString(6, user.getCellphone());
            statement.setString(7, user.getEmail());

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                insertar = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return insertar;
    }

    public void mostrarUsuarios(JTable paramTablaTotalUsers) {
        ConexionBD conn = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalUsers.setRowSorter(ordenarTabla);

        String consultaSQL = "";

        modelo.addColumn("id");
        modelo.addColumn("tipoUsuario");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("direccion");
        modelo.addColumn("cellphone");
        modelo.addColumn("email");

        paramTablaTotalUsers.setModel(modelo);

        consultaSQL = "SELECT * FROM usuario";

        String[] datos = new String[7];
        Statement st;

        try {
            st = conn.connectMYSQL().createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);

                modelo.addRow(datos);
            }

            paramTablaTotalUsers.setModel(modelo);
        } catch (Exception ex) {
            System.out.println("No se pueden mostrar los usuarios de la base de datos" + ex.toString());
        }

    }

    public boolean updateUser(Usuario usuario) {
        String consultaSQL = "UPDATE usuario SET tipoUsuario = ?, nombre = ?, apellido = ?, direccion = ?, cellphone = ?, email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
            statement.setString(1, usuario.getTipoUSer().toString());  // Convertir el enum a String
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getApellido());
            statement.setString(4, usuario.getDireccion());
            statement.setString(5, usuario.getCellphone());
            statement.setString(6, usuario.getEmail());
            statement.setInt(7, usuario.getId());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Usuario searchByIdUsuario(int idUsuario) {
        Usuario user = null;
        ConexionBD conn = new ConexionBD();

        try (Connection connection = conn.connectMYSQL()) {
            String consultaSQL = "SELECT * FROM usuario WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setInt(1, idUsuario);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new Usuario();
                        user.setId(resultSet.getInt("id"));
                        user.setTipoUSer(resultSet.getString("tipoUsuario"));
                        user.setNombre(resultSet.getString("nombre"));
                        user.setApellido(resultSet.getString("apellido"));
                        user.setDireccion(resultSet.getString("direccion"));
                        user.setCellphone(resultSet.getString("cellphone"));
                        user.setEmail(resultSet.getString("cellphone"));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return user;
    }

//    @Override
//    public Object consultar(int idBodeguero) {
//        for (Bodeguero bodeguero : arregloBodegueros) {
//            if (bodeguero.getId() == idBodeguero) {
//                return bodeguero;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void consultar() {
//        for (Bodeguero bodeguero : arregloBodegueros) {
//            System.out.println("Productos" + bodeguero.toString());
//        }
//    }
//
//    @Override
//    public Object actualizar(int idBodeguero) {
//        for (Bodeguero bod : arregloBodegueros) {
//            if (bod.getId() == idBodeguero) {
//                bod.setNombre(bod.getNombre());
//                bod.setApellido(bod.getApellido());
//                bod.setTipoUSer(Bodeguero.TipoUsuario.Bodeguero);
//                bod.setDireccion(bod.getDireccion());
//                bod.setEmail(bod.getEmail());
//                bod.setCellphone(bod.getCellphone());
//
//                return bod;
//            }
//        }
//
//        return null;
//    }
//
//    @Override
//    public boolean borrar(Object obj) {
//        if (obj instanceof Bodeguero) {
//            Bodeguero bodABorrar = (Bodeguero) obj;
//            boolean eliminado = arregloBodegueros.remove(bodABorrar);
//            return eliminado;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean ordenar() {
//        if (!arregloBodegueros.isEmpty()) {
//            Collections.sort(arregloBodegueros);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Object consultar(Object obj) {
//        Bodeguero bd = (Bodeguero) obj;
//        int pos = Collections.binarySearch(arregloBodegueros, bd);
//        if (pos > 0) {
//            return arregloBodegueros.get(pos);
//        } else {
//            return null;
//        }
//    }
    @Override
    public Object consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object actualizar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean borrar(Object obj) {
        if (obj instanceof Usuario) {
            Usuario user = (Usuario) obj;
            String consulta = "DELETE FROM usuario WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setInt(1, user.getId());

                int filasAfectadas = statement.executeUpdate();
                return filasAfectadas > 0;

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object consultar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
