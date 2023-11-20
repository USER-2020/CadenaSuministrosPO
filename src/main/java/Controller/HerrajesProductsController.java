/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import model.HerrajesProducts;

/**
 *
 * @author Juan Zuluaga
 */
public class HerrajesProductsController implements ICRUD {

    public static ArrayList<HerrajesProducts> arregloProductosHerrajes = new ArrayList<HerrajesProducts>();

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = true;
        HerrajesProducts prodH = new HerrajesProducts();
        prodH = (HerrajesProducts) obj;
        if (arregloProductosHerrajes.isEmpty()) {
            arregloProductosHerrajes.add(prodH);
        }
        return insertar;
    }

    @Override
    public Object consultar(int idProductoHerrajes) {
        for (HerrajesProducts productH : arregloProductosHerrajes) {
            if (productH.getNumeroSerial() == idProductoHerrajes) {
                return productH;
            }
        }
        return null;
    }

    @Override
    public void consultar() {
        for (HerrajesProducts productH : arregloProductosHerrajes) {
            System.out.println("Productos" + productH.toString());
        }
    }

    @Override
    public Object actualizar(int idProductoHerraje) {
        for (HerrajesProducts hProduct : arregloProductosHerrajes) {
            if (hProduct.getNumeroSerial() == idProductoHerraje) {

                hProduct.setNombre(hProduct.getNombre());
                hProduct.setDescripcion(hProduct.getDescripcion());
                hProduct.setIdBodega(hProduct.getIdBodega());
                hProduct.setColor(hProduct.getColor());
                hProduct.setMarca(hProduct.getMarca());
                hProduct.setMaterial(hProduct.getMaterial());
                hProduct.setDemanda(hProduct.getDemanda());
                hProduct.setCostoProduccion(hProduct.getCostoProduccion());
                hProduct.setCostoVenta(hProduct.getCostoVenta());
                hProduct.setCostoAlmacenamiento(hProduct.getCostoAlmacenamiento());
                hProduct.setCostoVenta(hProduct.getCostoVenta());
                hProduct.setTipoElemento(hProduct.getTipoElemento());

                return hProduct;

            }
        }
        return null;
    }

    @Override
    public boolean borrar(Object obj) {
        if (obj instanceof HerrajesProducts) {
            HerrajesProducts hProductABorrar = (HerrajesProducts) obj;
            boolean eliminado = arregloProductosHerrajes.remove(hProductABorrar);
            return true;
        }
        return false;
    }

   

    @Override
    public Object consultar(Object obj) {
        HerrajesProducts ph = (HerrajesProducts) obj;
        int pos = Collections.binarySearch(arregloProductosHerrajes, ph);
        if (pos > 0) {
            return arregloProductosHerrajes.get(pos);
        } else {
            return null;
        }
    }    

    @Override
    public void ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenar(int i, int j, ArrayList array, JTable paramTablaTotalProductos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenar(int i, int j, JTable paramTablaTotalProductos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ordenarBurbuja(JTable paramTablaTotalProductos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
