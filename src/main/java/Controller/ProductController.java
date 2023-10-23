/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.Product;

/**
 *
 * @author Juan Fernando Zuluaga Aguirre
 */
public class ProductController implements ICRUD{
    
    public static ArrayList<Product> arregloProductos = new  ArrayList<Product>();

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = true;
        Product prod1 = new Product();
        prod1 = (Product) obj;
        if(arregloProductos.isEmpty())
        {
            arregloProductos.add(prod1);
        }
      return insertar; 
    }

    @Override
    public Object consultar(int idProducto) {
       for (Product product: arregloProductos){
           if(product.getNumeroSerial() == idProducto){
               return product;
           }
       }
        return null;
    }

    @Override
    public void consultar() {
        
        for (Product product : arregloProductos){
            System.out.println("Productos" + product.toString());
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
            Product pp = (Product)obj;
            int pos=Collections.binarySearch(arregloProductos, pp);
            if(pos>0)
                return arregloProductos.get(pos);
            else
                return null;
    }
    
}
