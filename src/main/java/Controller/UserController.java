/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.Date;
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
import model.Administrador;
import model.Bodeguero;
import model.Usuario;
import resource.ConexionBD;

/**
 *
 * @author Juan Zuluaga
 */
public class UserController implements ICRUD {

//    public static ArrayList<Usuario> arregloUsuarios = new ArrayList<Bodeguero>();
    public DefaultTableModel modelo;
    private Connection connection;
    ConexionBD conn = new ConexionBD();
    public ArrayList<Usuario> usuariosList;
    public ArrayList<UsuarioDTO> usuariosList2;

    public UserController() {
        connection = conn.connectMYSQL();
        modelo = new DefaultTableModel();
        usuariosList = new ArrayList<>();
        usuariosList2 = new ArrayList<>();
    }

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = false;
        UsuarioDTO user = (UsuarioDTO) obj;

        //Verificar si el usuario ya existe en el ArrayList
        if (!usuariosList2.contains(user)) {
            usuariosList2.add(user);
            System.out.println("Contenido del ArrayList de usuarios: ");
            for (UsuarioDTO u : usuariosList2) {
                System.out.println(u);
            }
            String consultaSQL = "INSERT INTO usuario (id, tipoUsuario, nombre, apellido, direccion, cellphone, email, fecha_ingreso, sueldo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setInt(1, user.getId());
                statement.setString(2, user.getTipoUSer());
                statement.setString(3, user.getNombre());
                statement.setString(4, user.getApellido());
                statement.setString(5, user.getDireccion());
                statement.setString(6, user.getCellphone());
                statement.setString(7, user.getEmail());
                statement.setString(8, user.getFecha_ingreso());
                statement.setFloat(9, user.getSueldo());

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    user.setId(user.getId());
                    insertar = true;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
        modelo.addColumn("fecha_ingreso");
        modelo.addColumn("sueldo");

        paramTablaTotalUsers.setModel(modelo);

        consultaSQL = "SELECT * FROM usuario";

        String[] datos = new String[9];
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
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);

                modelo.addRow(datos);

                //Crear el objeto Usuario y agregarlo al ArrayList
                UsuarioDTO user = new UsuarioDTO();
                user.setId(Integer.parseInt(datos[0]));
                user.setTipoUSer(datos[1]);
                user.setNombre(datos[2]);
                user.setApellido(datos[3]);
                user.setDireccion(datos[4]);
                user.setCellphone(datos[5]);
                user.setEmail(datos[6]);
                user.setFecha_ingreso(datos[7]);
                user.setSueldo(Float.parseFloat(datos[8]));

                if (!usuariosList2.contains(user)) {
                    usuariosList2.add(user);
                }
            }

            paramTablaTotalUsers.setModel(modelo);
            System.out.println("Contenido del ArrayList productos:");
            for (UsuarioDTO p : usuariosList2) {
                System.out.println(p);
            }
        } catch (Exception ex) {
            System.out.println("No se pueden mostrar los usuarios de la base de datos" + ex.toString());
        }

    }

    public boolean updateUser(UsuarioDTO usuario) {

        if (usuariosList2.contains(usuario)) {
            int index = usuariosList2.indexOf(usuario);
            usuariosList2.set(index, usuario);
            System.out.println("Conteinido actual del ArrayList despues de actualizar: " + usuariosList2);

            String consultaSQL = "UPDATE usuario SET tipoUsuario = ?, nombre = ?, apellido = ?, direccion = ?, cellphone = ?, email = ? , fecha_ingreso = ?, sueldo = ? WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setString(1, usuario.getTipoUSer());  // Convertir el enum a String
                statement.setString(2, usuario.getNombre());
                statement.setString(3, usuario.getApellido());
                statement.setString(4, usuario.getDireccion());
                statement.setString(5, usuario.getCellphone());
                statement.setString(6, usuario.getEmail());
                statement.setString(7, usuario.getFecha_ingreso());
                statement.setFloat(8, usuario.getSueldo());
                statement.setInt(9, usuario.getId());

                int filasAfectadas = statement.executeUpdate();
//                return filasAfectadas > 0;
                if (filasAfectadas > 0) {
                    System.out.println("Usuario actualizado en la base de datos: " + usuario);
                    return true;
                } else {
                    System.out.println("Usuario no encontrado en la base de datos: " + usuario);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Usuario no encontrado en el ArrayList: " + usuario);
        }
        return false;

    }

    public UsuarioDTO searchByIdUsuario(int idUsuario) {
        UsuarioDTO user = null;
        ConexionBD conn = new ConexionBD();

        try (Connection connection = conn.connectMYSQL()) {
            String consultaSQL = "SELECT * FROM usuario WHERE id = ?";

            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setInt(1, idUsuario);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        user = new UsuarioDTO();
                        user.setId(resultSet.getInt("id"));
                        user.setTipoUSer(resultSet.getString("tipoUsuario"));
                        user.setNombre(resultSet.getString("nombre"));
                        user.setApellido(resultSet.getString("apellido"));
                        user.setDireccion(resultSet.getString("direccion"));
                        user.setCellphone(resultSet.getString("cellphone"));
                        user.setEmail(resultSet.getString("email"));
                        user.setFecha_ingreso(resultSet.getString("fecha_ingreso"));
                        user.setSueldo(resultSet.getFloat("sueldo"));

                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class
                    .getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return user;
    }

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
    public synchronized boolean borrar(Object obj) {
        if (obj instanceof UsuarioDTO) {
            UsuarioDTO user = (UsuarioDTO) obj;

            //Verificar usuario en el ArrayList
            if (usuariosList2.contains(user)) {
                usuariosList2.remove(user);
                System.out.println("Usuario eliminado, Arraylit despues de eliminar: " + usuariosList2);

                String consulta = "DELETE FROM usuario WHERE id = ?";

                try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                    statement.setInt(1, user.getId());

                    int filasAfectadas = statement.executeUpdate();
//                return filasAfectadas > 0;
                    if (filasAfectadas > 0) {
                        System.out.println("Usuario eliminado de la base de datos: " + user);
                        return true;
                    } else {
//                        usuariosList2.add(user);
                        System.out.println("Usuario no encontrado en la base de datos: " + user);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return true;
            } else {
                System.out.println("Usuario no encontrado en el ArrayList: " + user);
            }
        }
        return false;
    }

    @Override
    public Object consultar(Object obj
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenar() {
        Collections.sort(usuariosList);
    }

    @Override
    public void ordenar(int i, int j, ArrayList array,
            JTable paramTablaTotalProductos
    ) {
        DefaultTableModel modelo = new DefaultTableModel();
        if (i < j) {
            int pivote = partition(array, i, j);

            ordenar(i, pivote - 1, array, paramTablaTotalProductos);
            ordenar(pivote + 1, j, array, paramTablaTotalProductos);
            System.out.println("Productos ordenados metodo quictSort");
            for (UsuarioDTO p : usuariosList2) {
                System.out.println(p);
            }
        }
        modelo.setRowCount(0);
        modelo.addColumn("id");
        modelo.addColumn("tipoUsuario");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("direccion");
        modelo.addColumn("cellphone");
        modelo.addColumn("email");
        modelo.addColumn("fecha_ingreso");
        modelo.addColumn("sueldo");

        for (UsuarioDTO user : usuariosList2) {
            Object[] row = {
                user.getId(),
                user.getTipoUSer(),
                user.getNombre(),
                user.getApellido(),
                user.getDireccion(),
                user.getCellphone(),
                user.getEmail(),
                user.getFecha_ingreso(),
                user.getSueldo()
            };

            modelo.addRow(row);
        }

        // Actualizar el JTable con el modelo modificado
        paramTablaTotalProductos.setModel(modelo);
    }

    @Override
    public void ordenar(int i, int j, JTable paramTablaTotalProductos
    ) {
        //Merdge sort
        DefaultTableModel modelo = new DefaultTableModel();
        if (i < j) {
            int medio = (i + j) / 2;

            // Ordena la mitad izquierda y derecha del arreglo
            ordenar(i, medio, paramTablaTotalProductos);
            ordenar(medio + 1, j, paramTablaTotalProductos);

            // Combina las mitades ordenadas
            merge(i, medio, j);
        }
        modelo.setRowCount(0);
        modelo.addColumn("id");
        modelo.addColumn("tipoUsuario");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("direccion");
        modelo.addColumn("cellphone");
        modelo.addColumn("email");
        modelo.addColumn("fecha_ingreso");
        modelo.addColumn("sueldo");

        for (UsuarioDTO user : usuariosList2) {
            Object[] row = {
                user.getId(),
                user.getTipoUSer(),
                user.getNombre(),
                user.getApellido(),
                user.getDireccion(),
                user.getCellphone(),
                user.getEmail(),
                user.getFecha_ingreso(),
                user.getSueldo()
            };

            modelo.addRow(row);
        }

        // Actualizar el JTable con el modelo modificado
        paramTablaTotalProductos.setModel(modelo);

    }

    private void merge(int i, int medio, int j) {
        int n1 = medio - i + 1;
        int n2 = j - medio;

        // Crear arreglos temporales
        UsuarioDTO[] izquierda = new UsuarioDTO[n1];
        UsuarioDTO[] derecha = new UsuarioDTO[n2];

        // Copiar datos a los arreglos temporales
        for (int x = 0; x < n1; ++x) {
            izquierda[x] = usuariosList2.get(i + x);
        }
        for (int y = 0; y < n2; ++y) {
            derecha[y] = usuariosList2.get(medio + 1 + y);
        }

        // Índices iniciales de los arreglos temporales
        int x = 0, y = 0;

        // Índice inicial del arreglo combinado
        int k = i;

        // Combina los arreglos temporales
        while (x < n1 && y < n2) {
            if (izquierda[x].compareTo(derecha[y]) <= 0) {
                usuariosList2.set(k, izquierda[x]);
                x++;
            } else {
                usuariosList2.set(k, derecha[y]);
                y++;
            }
            k++;
        }

        // Copia los elementos restantes de izquierda[], si los hay
        while (x < n1) {
            usuariosList2.set(k, izquierda[x]);
            x++;
            k++;
        }

        // Copia los elementos restantes de derecha[], si los hay
        while (y < n2) {
            usuariosList2.set(k, derecha[y]);
            y++;
            k++;
        }
    }

    private int partition(ArrayList array, int low, int high) {
        // Elige el pivote
        String pivote = ((UsuarioDTO) array.get(high)).getApellido();

        // Índice del menor elemento
        int i = low - 1;

        // Recorre los elementos del array
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote (ignorando mayúsculas y minúsculas)
            if (((UsuarioDTO) array.get(j)).getApellido().compareToIgnoreCase(pivote) <= 0) {
                i++;

                // Intercambia array[i] y array[j]
                UsuarioDTO temp = (UsuarioDTO) array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }

        // Intercambia array[i+1] y array[high] (o el pivote)
        UsuarioDTO temp = (UsuarioDTO) array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);

        // Devuelve el índice donde se colocó el pivote
        return i + 1;
    }

    @Override
    public void ordenarBurbuja(JTable paramTablaTotalProductos
    ) {
        DefaultTableModel modelo = new DefaultTableModel();
        UsuarioDTO uptemp;
        for (int i = 0; i < usuariosList2.size(); i++) {
            for (int j = 0; j < usuariosList2.size(); j++) {
                if (usuariosList2.get(i).getTipoUSer().compareToIgnoreCase(usuariosList2.get(j).getTipoUSer()) < 0) {//Ordenamiento de usuario por tipo de usuario
                    uptemp = usuariosList2.get(i);
                    usuariosList2.set(i, usuariosList2.get(j));
                    usuariosList2.set(j, uptemp);
                    System.out.println("Usuarios ordenados metodo burbuja");
                    for (UsuarioDTO u : usuariosList2) {
                        System.out.println(u);
                    }
                }
            }

        }
        modelo.setRowCount(0);
        modelo.addColumn("id");
        modelo.addColumn("tipoUsuario");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("direccion");
        modelo.addColumn("cellphone");
        modelo.addColumn("email");
        modelo.addColumn("fecha_ingreso");
        modelo.addColumn("sueldo");

        for (UsuarioDTO user : usuariosList2) {
            Object[] row = {
                user.getId(),
                user.getTipoUSer(),
                user.getNombre(),
                user.getApellido(),
                user.getDireccion(),
                user.getCellphone(),
                user.getEmail(),
                user.getFecha_ingreso(),
                user.getSueldo()
            };

            modelo.addRow(row);
        }

        // Actualizar el JTable con el modelo modificado
        paramTablaTotalProductos.setModel(modelo);
    }

}
