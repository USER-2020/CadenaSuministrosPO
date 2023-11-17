package view;

import Controller.ProductController;
import java.sql.Blob;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Juan Zuluaga
 */
public class ViewGUIProductsHerrajes extends javax.swing.JFrame {

    private ProductController controllerProduct;

    /**
     * Creates new form ViewGUIUser
     */
    public ViewGUIProductsHerrajes() {
        initComponents();
        ProductController controllerProduct = new ProductController();
//        controllerProduct.MostrarProductos(jTableProducts);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTNumeroSerialProducto = new javax.swing.JTextField();
        jTDescripcionProducto = new javax.swing.JTextField();
        jTColorProducto = new javax.swing.JTextField();
        jTMaterialProducto = new javax.swing.JTextField();
        jTMarcaProducto = new javax.swing.JTextField();
        jTDemandaProducto = new javax.swing.JTextField();
        jBtnUpdate = new javax.swing.JButton();
        jBtnCrear = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBOrdenar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTCostoProduccionProducto = new javax.swing.JTextField();
        jTCostoVentaProducto = new javax.swing.JTextField();
        jTCostoAlmacenamientoProducto = new javax.swing.JTextField();
        jTNombreProduct = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTIdBodega = new javax.swing.JTextField();
        jBVolverAlMenu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos producto"));

        jLabel1.setText("NRO SERIAL");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("DESCRIPCION");

        jLabel4.setText("COLOR");

        jLabel5.setText("MATERIAL");

        jLabel6.setText("MARCA");

        jLabel7.setText("DEMANDA");

        jTNumeroSerialProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNumeroSerialProductoActionPerformed(evt);
            }
        });

        jBtnUpdate.setText("ACTUALIZAR");
        jBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateActionPerformed(evt);
            }
        });

        jBtnCrear.setText("CREAR");
        jBtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCrearActionPerformed(evt);
            }
        });

        jBtnDelete.setText("BORRAR");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBOrdenar.setText("ORDENAR");
        jBOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOrdenarActionPerformed(evt);
            }
        });

        jLabel8.setText("$-PRODUCCCION");

        jLabel9.setText("IMAGEN");

        jLabel10.setText("$-VENTA");

        jLabel11.setText("$-ALMACENAMIENTO");

        jTCostoProduccionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCostoProduccionProductoActionPerformed(evt);
            }
        });

        jLabel12.setText("ID_BODEGA");

        jTIdBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdBodegaActionPerformed(evt);
            }
        });

        jBVolverAlMenu.setText("VOLVER AL MENU");
        jBVolverAlMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverAlMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTDemandaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTDescripcionProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTColorProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTNumeroSerialProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jTMarcaProducto)
                            .addComponent(jTMaterialProducto)
                            .addComponent(jTNombreProduct))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBtnCrear)
                                    .addGap(18, 18, 18)
                                    .addComponent(jBtnUpdate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBtnDelete))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTCostoProduccionProducto)
                                        .addComponent(jTCostoAlmacenamientoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                        .addComponent(jTCostoVentaProducto))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBVolverAlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTIdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTNumeroSerialProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTCostoProduccionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jTCostoVentaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNombreProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTCostoAlmacenamientoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTColorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTMaterialProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTMarcaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnDelete)
                            .addComponent(jBtnUpdate)
                            .addComponent(jBtnCrear))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBOrdenar)
                            .addComponent(jBVolverAlMenu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTDemandaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTIdBodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de productos"));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNumeroSerialProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNumeroSerialProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNumeroSerialProductoActionPerformed

    private void resetearCampos() {
        jTNumeroSerialProducto.setText("");
        jTNombreProduct.setText("");
        jTDescripcionProducto.setText("");
        jTIdBodega.setText("");
        jTColorProducto.setText("");
        jTMaterialProducto.setText("");
        jTMarcaProducto.setText("");
        jTDemandaProducto.setText("");
        jTCostoProduccionProducto.setText("");
        jTCostoVentaProducto.setText("");
        jTCostoAlmacenamientoProducto.setText("");
    }

    private void jBtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCrearActionPerformed
        //Obtener todos los datos de los inputs y enviarlos al controlador y despues a la base de datos
        int numeroSerial = Integer.parseInt(jTNumeroSerialProducto.getText());
        String nombre = jTNombreProduct.getText();
        String descripcion = jTDescripcionProducto.getText();
        int idBodega = Integer.parseInt(jTIdBodega.getText());
        String color = jTColorProducto.getText();
        String imagen = null;
        String marca = jTMarcaProducto.getText();
        String material = jTMaterialProducto.getText();
        String demanda = jTDemandaProducto.getText();
        float costoProduccion = Float.parseFloat(jTCostoProduccionProducto.getText());
        float costoVenta = Float.parseFloat(jTCostoVentaProducto.getText());
        float costoAlmacenamiento = Float.parseFloat(jTCostoAlmacenamientoProducto.getText());
        Blob imagenBLOB = null;

        Product producto = new Product(descripcion, nombre, numeroSerial, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento, imagenBLOB);

        ProductController controllerProduct = new ProductController();
        boolean exito = controllerProduct.insertar(producto);

        if (exito) {
            resetearCampos();
            JOptionPane.showMessageDialog(this, "Producto agregado con exito");
//            controllerProduct.MostrarProductos(jTableProducts);
        } else {
            JOptionPane.showMessageDialog(this, "Error al crear el producto");
        }
    }//GEN-LAST:event_jBtnCrearActionPerformed

    private void jTIdBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdBodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdBodegaActionPerformed

    private void jBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUpdateActionPerformed
        // TODO add your handling code here:
        int numeroSerial = Integer.parseInt(jTNumeroSerialProducto.getText());
        String nombre = jTNombreProduct.getText();
        String descripcion = jTDescripcionProducto.getText();
        int idBodega = Integer.parseInt(jTIdBodega.getText());
        String color = jTColorProducto.getText();
        String imagen = null;
        String marca = jTMarcaProducto.getText();
        String material = jTMaterialProducto.getText();
        String demanda = jTDemandaProducto.getText();
        float costoProduccion = Float.parseFloat(jTCostoProduccionProducto.getText());
        float costoVenta = Float.parseFloat(jTCostoVentaProducto.getText());
        float costoAlmacenamiento = Float.parseFloat(jTCostoAlmacenamientoProducto.getText());
        Blob imagenBLOB = null;

        Product producto = new Product(descripcion, nombre, numeroSerial, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento, imagenBLOB);

        ProductController productoController = new ProductController();
        boolean updateSuccess = productoController.updateProduct(producto);

        if (updateSuccess) {
            resetearCampos();
            jTNumeroSerialProducto.setEnabled(true);
//            productoController.MostrarProductos(jTableProducts);
            JOptionPane.showMessageDialog(this, "Producto actualizado con exito");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el producto");
        }
    }//GEN-LAST:event_jBtnUpdateActionPerformed

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        // TODO add your handling code here:
        int selectedRow = jTableProducts.getSelectedRow();
        if (selectedRow >= 0) {
            // Obten el valor de la celda en la columna de número de serie (ajusta el índice de columna según tu tabla)
            Object numeroSerial = jTableProducts.getValueAt(selectedRow, jTableProducts.getColumn("numeroSerial").getModelIndex());
            if (numeroSerial != null) {
                int numeroSerialProducto = Integer.parseInt(numeroSerial.toString());

                //Intancia del controlador de productos
                ProductController controllerProduct = new ProductController();

                Product updateProduct = controllerProduct.searchByNumeroSerial(numeroSerialProducto);

                if (updateProduct != null) {
                    jTNumeroSerialProducto.setText(String.valueOf(updateProduct.getNumeroSerial()));
                    jTNombreProduct.setText(updateProduct.getNombre());
                    jTDescripcionProducto.setText(updateProduct.getDescripcion());
                    jTColorProducto.setText(updateProduct.getColor());
                    jTMaterialProducto.setText(updateProduct.getMaterial());
                    jTMarcaProducto.setText(updateProduct.getMarca());
                    jTDemandaProducto.setText(updateProduct.getDemanda());
                    jTIdBodega.setText(String.valueOf(updateProduct.getIdBodega()));
                    jTCostoProduccionProducto.setText(String.valueOf(updateProduct.getCostoProduccion()));
                    jTCostoVentaProducto.setText(String.valueOf(updateProduct.getCostoVenta()));
                    jTCostoAlmacenamientoProducto.setText(String.valueOf(updateProduct.getCostoAlmacenamiento()));
                    jTNumeroSerialProducto.setEnabled(false); //inhabil;itar el campo de numero de serial par ano poderlo modificar
                } else {
                    jTNumeroSerialProducto.setEnabled(false); //habilitar de nuevo el campo por default
                }

                // Llama al método para actualizar con el número de serie seleccionado
//                ProductController controllerProduct = new ProductController();
//                controllerProduct.actualizar(numeroSerialProducto);
//                System.out.println("IDProducto: " + numeroSerialProducto);
            }
        }
    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jBOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOrdenarActionPerformed
        // TODO add your handling code here:
        ProductController controllerProduct = new ProductController();
        resetearCampos();
        jTNumeroSerialProducto.setEnabled(true);
//        controllerProduct.MostrarProductos(jTableProducts);
    }//GEN-LAST:event_jBOrdenarActionPerformed

    private void jTCostoProduccionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCostoProduccionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCostoProduccionProductoActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
        int numeroSerial = Integer.parseInt(jTNumeroSerialProducto.getText());
        ProductController controllerProduct = new ProductController();
        Product productoAEliminar = new Product();
        productoAEliminar.setNumeroSerial(numeroSerial);
        boolean eliminado = controllerProduct.borrar(productoAEliminar);
        if (eliminado) {
            resetearCampos();
            jTNumeroSerialProducto.setEnabled(true);
//            controllerProduct.MostrarProductos(jTableProducts);
            JOptionPane.showMessageDialog(this, "Prdoucto eliminado");
        } else {
            JOptionPane.showMessageDialog(this, "Problemas con la eliminación del producto");
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBVolverAlMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverAlMenuActionPerformed
        // TODO add your handling code here:
        MenuGUI menu = new MenuGUI();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBVolverAlMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewGUIProductsHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGUIProductsHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGUIProductsHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGUIProductsHerrajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGUIProductsHerrajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBOrdenar;
    private javax.swing.JButton jBVolverAlMenu;
    private javax.swing.JButton jBtnCrear;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTColorProducto;
    private javax.swing.JTextField jTCostoAlmacenamientoProducto;
    private javax.swing.JTextField jTCostoProduccionProducto;
    private javax.swing.JTextField jTCostoVentaProducto;
    private javax.swing.JTextField jTDemandaProducto;
    private javax.swing.JTextField jTDescripcionProducto;
    private javax.swing.JTextField jTIdBodega;
    private javax.swing.JTextField jTMarcaProducto;
    private javax.swing.JTextField jTMaterialProducto;
    private javax.swing.JTextField jTNombreProduct;
    private javax.swing.JTextField jTNumeroSerialProducto;
    private javax.swing.JTable jTableProducts;
    // End of variables declaration//GEN-END:variables
}
