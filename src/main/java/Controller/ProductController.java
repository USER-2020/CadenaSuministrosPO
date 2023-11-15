/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Product;
import resource.ConexionBD;

/**
 *
 * @author Juan Fernando Zuluaga Aguirre
 */
public class ProductController implements ICRUD {

//    public static ArrayList<Product> arregloProductos = new  ArrayList<Product>();
    private Connection connection;
    ConexionBD conn = new ConexionBD();

    public ProductController() {
        connection = conn.connectMYSQL();
    }

    private List<Product> productos;

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = false;
        Product producto = (Product) obj;
        String consulta = "INSERT INTO product (nombre, numeroSerial, descripcion, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento, imagenBLOB) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Reemplaza con el nombre real de tu tabla y las columnas correspondientes

        try (PreparedStatement statement = connection.prepareStatement(consulta)) {
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getNumeroSerial());
            statement.setString(3, producto.getDescripcion());
            statement.setInt(4, producto.getIdBodega());
            statement.setString(5, producto.getColor());
            statement.setString(6, producto.getImagen());
            statement.setString(7, producto.getMarca());
            statement.setString(8, producto.getMaterial());
            statement.setString(9, producto.getDemanda());
            statement.setFloat(10, producto.getCostoProduccion());
            statement.setFloat(11, producto.getCostoVenta());
            statement.setFloat(12, producto.getCostoAlmacenamiento());

            // Lee el archivo y conviértelo en un arreglo de bytes
            try (InputStream archivoFoto = new FileInputStream(producto.getImagen())) {
                statement.setBlob(15, archivoFoto);

                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    insertar = true;
                }
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }

        return insertar;
    }

    @Override
    public Object consultar(int idProducto) {
//       for (Product product: arregloProductos){
//           if(product.getNumeroSerial() == idProducto){
//               return product;
//           }
//       }  

//        return null;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    public void MostrarProductos(JTable paramTablaTotalProductos) {

        ConexionBD conn = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modelo);
        paramTablaTotalProductos.setRowSorter(ordenarTabla);

        String consultaSQL = "";

        modelo.addColumn("numeroSerial");
        modelo.addColumn("descripcion");
        modelo.addColumn("nombre");
        modelo.addColumn("idBodega");
        modelo.addColumn("color");
        modelo.addColumn("imagen");
        modelo.addColumn("marca");
        modelo.addColumn("material");
        modelo.addColumn("demanda");
        modelo.addColumn("costoProduccion");
        modelo.addColumn("costoVenta");
        modelo.addColumn("costoAlmacenamiento");
        modelo.addColumn("imagenBLOB");

        paramTablaTotalProductos.setModel(modelo);

        consultaSQL = "SELECT * FROM product";

        String[] datos = new String[13];
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
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);

                modelo.addRow(datos);

            }

            paramTablaTotalProductos.setModel(modelo);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pueden mostrar los resgitros de los productos, error: " + ex.toString());
        }

    }

    @Override
    public void consultar() {

        productos = new ArrayList<>();
        String consulta = "SELECT * FROM product";

        try (PreparedStatement statement = connection.prepareStatement(consulta); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product producto = new Product();
                producto.setNombre(resultSet.getString("nombre"));
                producto.setNumeroSerial(resultSet.getInt("numeroSerial"));
                producto.setDescripcion(resultSet.getString("descripcion"));

                productos.add(producto);
            }

        } catch (SQLException ex) {

            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public Product actualizar(int idProduct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean updateProduct(Product producto) {
        String consulta = "UPDATE product SET nombre = ?, descripcion = ?, idBodega = ?, color = ?, imagen = ?, marca = ?, material = ?, demanda = ?, costoProduccion = ?, costoVenta = ?, costoAlmacenamiento = ? WHERE numeroSerial = ?";

        try (PreparedStatement statement = connection.prepareStatement(consulta)) {
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getIdBodega());
            statement.setString(4, producto.getColor());
            statement.setString(5, producto.getImagen());
            statement.setString(6, producto.getMarca());
            statement.setString(7, producto.getMaterial());
            statement.setString(8, producto.getDemanda());
            statement.setFloat(9, producto.getCostoProduccion());
            statement.setFloat(10, producto.getCostoVenta());
            statement.setFloat(11, producto.getCostoAlmacenamiento());
            statement.setInt(12, producto.getNumeroSerial());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Product searchByNumeroSerial(int idProducto) {
        Product producto = null;
        ConexionBD conn = new ConexionBD();

        try (Connection connection = conn.connectMYSQL()) {
            String consultaSQL = "SELECT * FROM product WHERE numeroSerial = ?";

            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setInt(1, idProducto);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        producto = new Product();
                        producto.setNumeroSerial(resultSet.getInt("numeroSerial"));
                        producto.setNombre(resultSet.getString("nombre"));
                        producto.setDescripcion(resultSet.getString("descripcion"));
                        producto.setIdBodega(resultSet.getInt("idBodega"));
                        producto.setColor(resultSet.getString("color"));
                        producto.setImagen(resultSet.getString("imagen"));
                        producto.setMarca(resultSet.getString("marca"));
                        producto.setMaterial(resultSet.getString("material"));
                        producto.setDemanda(resultSet.getString("demanda"));
                        producto.setCostoProduccion(resultSet.getFloat("costoProduccion"));
                        producto.setCostoVenta(resultSet.getFloat("costoVenta"));
                        producto.setCostoAlmacenamiento(resultSet.getFloat("costoAlmacenamiento"));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return producto;
    }

    @Override
    public boolean borrar(Object obj) {
        if (obj instanceof Product) {
            Product producto = (Product) obj;
            String consulta = "DELETE FROM product WHERE numeroSerial = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setInt(1, producto.getNumeroSerial());

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
//        Product pp = (Product) obj;
//        int pos = Collections.binarySearch(arregloProductos, pp);
//        if (pos > 0) {
//            return arregloProductos.get(pos);
//        } else {
//            return null;
//        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
