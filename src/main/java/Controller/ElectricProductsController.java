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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ElectricProducts;
import model.Product;
import resource.ConexionBD;

/**
 *
 * @author Juan Zuluaga
 */
public class ElectricProductsController implements ICRUD {

    private Connection connection;
    ConexionBD conn = new ConexionBD();

    public ElectricProductsController() {
        connection = conn.connectMYSQL();
    }

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = false;
        ElectricProducts productoE = (ElectricProducts) obj;

        String consulta = "INSERT INTO electricproducts (nombre, numeroSerial, descripcion, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento, carga, calibre, imagenBLOB) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Reemplaza con el nombre real de tu tabla y las columnas correspondientes
        try (PreparedStatement statement = connection.prepareStatement(consulta)) {
            statement.setString(1, productoE.getNombre());
            statement.setInt(2, productoE.getNumeroSerial());
            statement.setString(3, productoE.getDescripcion());
            statement.setInt(4, productoE.getIdBodega());
            statement.setString(5, productoE.getColor());
            statement.setString(6, productoE.getImagen());
            statement.setString(7, productoE.getMarca());
            statement.setString(8, productoE.getMaterial());
            statement.setString(9, productoE.getDemanda());
            statement.setFloat(10, productoE.getCostoProduccion());
            statement.setFloat(11, productoE.getCostoVenta());
            statement.setFloat(12, productoE.getCostoAlmacenamiento());
            statement.setString(13, productoE.getCarga());
            statement.setString(14, productoE.getCalibre());
            // Lee el archivo y conviértelo en un arreglo de bytes
            try (InputStream archivoFoto = new FileInputStream(productoE.getImagen())) {
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

    public void mostrarProductoElectricos(JTable tableModelElectric) {
        ConexionBD conn = new ConexionBD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<TableModel>(modelo);

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
        modelo.addColumn("carga");
        modelo.addColumn("calibre");
        modelo.addColumn("imagenBLOB");

        tableModelElectric.setModel(modelo);

        consultaSQL = "SELECT * FROM electricproducts";

        String[] datosModel = new String[15];
        Statement st;

        try {
            st = conn.connectMYSQL().createStatement();
            ResultSet rs = st.executeQuery(consultaSQL);

            while (rs.next()) {
                datosModel[0] = rs.getString(1);
                datosModel[1] = rs.getString(2);
                datosModel[2] = rs.getString(3);
                datosModel[3] = rs.getString(4);
                datosModel[4] = rs.getString(5);
                datosModel[5] = rs.getString(6);
                datosModel[6] = rs.getString(7);
                datosModel[7] = rs.getString(8);
                datosModel[8] = rs.getString(9);
                datosModel[9] = rs.getString(10);
                datosModel[10] = rs.getString(11);
                datosModel[11] = rs.getString(12);
                datosModel[12] = rs.getString(13);
                datosModel[13] = rs.getString(14);
                datosModel[14] = rs.getString(15);

                modelo.addRow(datosModel);
            }

            tableModelElectric.setModel(modelo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean updateProductElectric(ElectricProducts productoElectrico) {
        String consultaSQL = "UPDATE electricproducts SET nombre = ?, descripcion = ?, idBodega = ?, color = ?, imagen = ?, marca = ?, material = ?, demanda = ?, costoProduccion = ?, costoVenta = ?, costoAlmacenamiento = ? , carga = ?, calibre = ? WHERE numeroSerial = ?";

        try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
            statement.setString(1, productoElectrico.getNombre());
            statement.setString(2, productoElectrico.getDescripcion());
            statement.setInt(3, productoElectrico.getIdBodega());
            statement.setString(4, productoElectrico.getColor());
            statement.setString(5, productoElectrico.getImagen());
            statement.setString(6, productoElectrico.getMarca());
            statement.setString(7, productoElectrico.getMaterial());
            statement.setString(8, productoElectrico.getDemanda());
            statement.setFloat(9, productoElectrico.getCostoProduccion());
            statement.setFloat(10, productoElectrico.getCostoVenta());
            statement.setFloat(11, productoElectrico.getCostoAlmacenamiento());
            statement.setString(12, productoElectrico.getCarga());
            statement.setString(13, productoElectrico.getCalibre());
            statement.setInt(14, productoElectrico.getNumeroSerial());

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ElectricProducts searchByNumeroSerial(int numeroSerial) {
        ElectricProducts productoE = null;
        ConexionBD conn = new ConexionBD();

        try (Connection connection = conn.connectMYSQL()) {
            String consultaSQL = "SELECT * FROM electricproducts WHERE numeroSerial = ?";

            try (PreparedStatement statement = connection.prepareStatement(consultaSQL)) {
                statement.setInt(1, numeroSerial);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        productoE = new ElectricProducts();
                        productoE.setNumeroSerial(resultSet.getInt("numeroSerial"));
                        productoE.setNombre(resultSet.getString("nombre"));
                        productoE.setDescripcion(resultSet.getString("descripcion"));
                        productoE.setIdBodega(resultSet.getInt("idBodega"));
                        productoE.setColor(resultSet.getString("color"));
                        productoE.setImagen(resultSet.getString("imagen"));
                        productoE.setMarca(resultSet.getString("marca"));
                        productoE.setMaterial(resultSet.getString("material"));
                        productoE.setDemanda(resultSet.getString("demanda"));
                        productoE.setCostoProduccion(resultSet.getFloat("costoProduccion"));
                        productoE.setCostoVenta(resultSet.getFloat("costoVenta"));
                        productoE.setCostoAlmacenamiento(resultSet.getFloat("costoAlmacenamiento"));
                        productoE.setCarga(resultSet.getString("carga"));
                        productoE.setCalibre(resultSet.getString("calibre"));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricProductsController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

        return productoE;
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
    public boolean borrar(Object obj) {
        if (obj instanceof ElectricProducts) {
            ElectricProducts productoE = (ElectricProducts) obj;
            String consulta = "DELETE FROM electricproducts WHERE numeroSerial = ?";

            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                statement.setInt(1, productoE.getNumeroSerial());

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

//    public static ArrayList<ElectricProducts> arregloProductosElectricos = new ArrayList<ElectricProducts>();
}
