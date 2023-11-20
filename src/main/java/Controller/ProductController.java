/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

    public DefaultTableModel modelo;

//    public static ArrayList<Product> arregloProductos = new  ArrayList<Product>();
    private Connection connection;
    ConexionBD conn = new ConexionBD();
    public ArrayList<Product> productos;

    public ProductController() {
        connection = conn.connectMYSQL();
        modelo = new DefaultTableModel();
        productos = new ArrayList<>();
    }

//    private ArrayList<Product> productos;
    @Override
    public boolean insertar(Object obj) {
        boolean insertar = false;
        Product producto = (Product) obj;

        // Verificar si el producto ya existe en el ArrayList
        if (!productos.contains(producto)) {
            // Agregar el producto al ArrayList
            productos.add(producto);
            System.out.println("Contenido del ArrayList productos:");
            for (Product p : productos) {
                System.out.println(p);
            }

            // Continuar con la inserción en la base de datos
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

                // Verificar si la inserción fue exitosa
                if (filasAfectadas > 0) {
                    // Establecer el valor de numeroSerial en el objeto producto
                    producto.setNumeroSerial(producto.getNumeroSerial());

                    insertar = true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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

                modelo.addRow(datos);

                // Crear un objeto Product y agregarlo al ArrayList
                Product producto = new Product();
                producto.setNumeroSerial(Integer.parseInt(datos[0]));
                producto.setDescripcion(datos[1]);
                producto.setNombre(datos[2]);
                producto.setIdBodega(Integer.parseInt(datos[3]));
                producto.setColor(datos[4]);
                producto.setImagen(datos[5]);
                producto.setMarca(datos[6]);
                producto.setMaterial(datos[7]);
                producto.setDemanda(datos[8]);
                producto.setCostoProduccion(Float.parseFloat(datos[9]));
                producto.setCostoVenta(Float.parseFloat(datos[10]));
                producto.setCostoAlmacenamiento(Float.parseFloat(datos[11]));

                if (!productos.contains(producto)) {
                    // El producto no está en la lista, así que lo agregamos
                    productos.add(producto);
//                    modelo.addRow(datos);
                }
            }

            paramTablaTotalProductos.setModel(modelo);

            System.out.println("Contenido del ArrayList productos:");
            for (Product p : productos) {
                System.out.println(p);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pueden mostrar los resgitros de los productos, error: " + ex.toString());
        }

    }

    @Override
    public void consultar() {

//        productos = new ArrayList<>();
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
        // Primero actualiza el ArrayList
        if (productos.contains(producto)) {
            int index = productos.indexOf(producto);
            productos.set(index, producto);
            System.out.println("Contenido actual del ArrayList después de actualizar: " + productos);

            // Ahora intenta actualizar la base de datos
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
                if (filasAfectadas > 0) {
                    System.out.println("Producto actualizado en la base de datos: " + producto);
                    return true; // Indica que la actualización fue exitosa
                } else {
                    System.out.println("Producto no encontrado en la base de datos: " + producto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Producto no encontrado en el ArrayList: " + producto);
        }

        return false; // Indica que la actualización no fue exitosa
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
    public synchronized boolean borrar(Object obj) {
        if (obj instanceof Product) {
            Product producto = (Product) obj;

            // Verifica si el producto está presente en el ArrayList antes de intentar eliminarlo
            if (productos.contains(producto)) {
                productos.remove(producto);
                System.out.println("Contenido actual del ArrayList después de eliminar: " + productos);

                // Ahora intenta eliminarlo de la base de datos
                String consulta = "DELETE FROM product WHERE numeroSerial = ?";

                try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                    statement.setInt(1, producto.getNumeroSerial());

                    int filasAfectadas = statement.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Producto eliminado de la base de datos: " + producto);
                        return true;
                    } else {
                        // Si no se eliminó de la base de datos, podrías considerar agregarlo nuevamente al ArrayList
                        productos.add(producto);
                        System.out.println("Producto no encontrado en la base de datos: " + producto);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return true;
            } else {
                System.out.println("Producto no encontrado en el ArrayList: " + producto);
            }
        }
        return false;
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

    @Override
    public void ordenar() {
        //
        Collections.sort(productos);
    }

    @Override
    public void ordenarBurbuja(JTable paramTablaTotalProductos) {
        //Burbuja
        DefaultTableModel modelo = new DefaultTableModel();
        Product pptemp;
        for (int i = 0; i < productos.size(); i++) {
            for (int j = 0; j < productos.size(); j++) {
                if (productos.get(i).getMarca().compareToIgnoreCase(productos.get(j).getMarca()) < 0) { //Ordenamineto por marca de la A - Z
                    pptemp = productos.get(i);
                    productos.set(i, productos.get(j));
                    productos.set(j, pptemp);
                    System.out.println("Productos ordenados metodo burbuja");
                    for (Product p : productos) {
                        System.out.println(p);
                    }
                }
            }

        }
        modelo.setRowCount(0);
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

        // Agregar los elementos ordenados al modelo
        // Agregar los elementos ordenados al modelo
        // Agregar los elementos ordenados al modelo
        for (Product producto : productos) {
            Object[] row = {
                producto.getNumeroSerial(),
                producto.getDescripcion(),
                producto.getNombre(),
                producto.getIdBodega(),
                producto.getColor(),
                producto.getImagen(),
                producto.getMarca(),
                producto.getMaterial(),
                producto.getDemanda(),
                producto.getCostoProduccion(),
                producto.getCostoVenta(),
                producto.getCostoAlmacenamiento()
            };
            modelo.addRow(row);
        }

        // Actualizar el JTable con el modelo modificado
        paramTablaTotalProductos.setModel(modelo);
    }

    @Override
    public void ordenar(int i, int j, JTable paramTablaTotalProductos) {
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

        // Agregar los elementos ordenados al modelo
        // Agregar los elementos ordenados al modelo
        // Agregar los elementos ordenados al modelo
        for (Product producto : productos) {
            Object[] row = {
                producto.getNumeroSerial(),
                producto.getDescripcion(),
                producto.getNombre(),
                producto.getIdBodega(),
                producto.getColor(),
                producto.getImagen(),
                producto.getMarca(),
                producto.getMaterial(),
                producto.getDemanda(),
                producto.getCostoProduccion(),
                producto.getCostoVenta(),
                producto.getCostoAlmacenamiento()
            };
            modelo.addRow(row);
        }

        // Actualizar el JTable con el modelo modificado
        paramTablaTotalProductos.setModel(modelo);
    }

    @Override
    public void ordenar(int i, int j, ArrayList array, JTable paramTablaTotalProductos) {
        // i = principio del arreglo
        // j = indice mas alto del arreglo, size
        // array ArrayList de productos
        //QuicSort
        DefaultTableModel modelo = new DefaultTableModel();
        if (i < j) {
            int pivote = partition(array, i, j);

            // Ordena recursivamente los elementos antes y después de la partición
            ordenar(i, pivote - 1, array, paramTablaTotalProductos);
            ordenar(pivote + 1, j, array, paramTablaTotalProductos);
            System.out.println("Productos ordenados metodo quictSort");
            for (Product p : productos) {
                System.out.println(p);
            }
        }

        modelo.setRowCount(0);
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

        // Agregar los elementos ordenados al modelo
        // Agregar los elementos ordenados al modelo
        for (Object obj : array) {
            if (obj instanceof Product) {
                Product producto = (Product) obj;
                Object[] row = {
                    producto.getNumeroSerial(),
                    producto.getDescripcion(),
                    producto.getNombre(),
                    producto.getIdBodega(),
                    producto.getColor(),
                    producto.getImagen(),
                    producto.getMarca(),
                    producto.getMaterial(),
                    producto.getDemanda(),
                    producto.getCostoProduccion(),
                    producto.getCostoVenta(),
                    producto.getCostoAlmacenamiento()
                };
                modelo.addRow(row);
            }
        }

        // Actua
        paramTablaTotalProductos.setModel(modelo);

    }

    private void merge(int i, int medio, int j) {
        int n1 = medio - i + 1;
        int n2 = j - medio;

        // Crear arreglos temporales
        Product[] izquierda = new Product[n1];
        Product[] derecha = new Product[n2];

        // Copiar datos a los arreglos temporales
        for (int x = 0; x < n1; ++x) {
            izquierda[x] = productos.get(i + x);
        }
        for (int y = 0; y < n2; ++y) {
            derecha[y] = productos.get(medio + 1 + y);
        }

        // Índices iniciales de los arreglos temporales
        int x = 0, y = 0;

        // Índice inicial del arreglo combinado
        int k = i;

        // Combina los arreglos temporales
        while (x < n1 && y < n2) {
            if (izquierda[x].compareTo(derecha[y]) <= 0) {
                productos.set(k, izquierda[x]);
                x++;
            } else {
                productos.set(k, derecha[y]);
                y++;
            }
            k++;
        }

        // Copia los elementos restantes de izquierda[], si los hay
        while (x < n1) {
            productos.set(k, izquierda[x]);
            x++;
            k++;
        }

        // Copia los elementos restantes de derecha[], si los hay
        while (y < n2) {
            productos.set(k, derecha[y]);
            y++;
            k++;
        }
    }

    private int partition(ArrayList array, int low, int high) {
        // Elige el pivote
        String pivote = ((Product) array.get(high)).getMarca();

        // Índice del menor elemento
        int i = low - 1;

        // Recorre los elementos del array
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote (ignorando mayúsculas y minúsculas)
            if (((Product) array.get(j)).getMarca().compareToIgnoreCase(pivote) <= 0) {
                i++;

                // Intercambia array[i] y array[j]
                Product temp = (Product) array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }

        // Intercambia array[i+1] y array[high] (o el pivote)
        Product temp = (Product) array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);

        // Devuelve el índice donde se colocó el pivote
        return i + 1;
    }

}
