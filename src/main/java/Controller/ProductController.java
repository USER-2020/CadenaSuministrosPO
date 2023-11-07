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
        String consulta = "INSERT INTO product (nombre, numeroSerial, descripcion, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Reemplaza con el nombre real de tu tabla y las columnas correspondientes

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

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                insertar = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        paramTablaTotalProductos.setModel(modelo);

        consultaSQL = "SELECT * FROM product";

        String[] datos = new String[12];
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
    public Product actualizar(int idProducto) {

        Product producto = null;
        return producto;
    }

    @Override
    public boolean borrar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
