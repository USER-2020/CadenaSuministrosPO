/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.HerrajesProducts;

/**
 *
 * @author Juan Zuluaga
 */
public class HerrajesProductsController implements ICRUD{
    
    public static ArrayList<HerrajesProducts> arregloProductosHerrajes = new ArrayList<HerrajesProducts>();

    @Override
    public boolean insertar(Object obj) {
         boolean insertar = true;
        HerrajesProducts prodH = new HerrajesProducts();
        prodH = (HerrajesProducts) obj;
        if(arregloProductosHerrajes.isEmpty())
        {
            arregloProductosHerrajes.add(prodH);
        }
      return insertar; 
    }

    @Override
    public Object consultar(int idProductoHerrajes) {
        for (HerrajesProducts productH: arregloProductosHerrajes){
           if(productH.getNumeroSerial() == idProductoHerrajes){
               return productH;
           }
       }
        return null;
    }

    @Override
    public void consultar() {
        for (HerrajesProducts productH : arregloProductosHerrajes){
            System.out.println("Productos" + productH.toString());
        }
    }

    @Override
    public Object actualizar(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
       HerrajesProducts ph = (HerrajesProducts)obj;
            int pos=Collections.binarySearch(arregloProductosHerrajes, ph);
            if(pos>0)
                return arregloProductosHerrajes.get(pos);
            else
                return null;
    }
}
