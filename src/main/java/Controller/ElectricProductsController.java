/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.ElectricProducts;

/**
 *
 * @author Juan Zuluaga
 */
public class ElectricProductsController implements ICRUD{
    
    public static ArrayList<ElectricProducts> arregloProductosElectricos = new ArrayList<ElectricProducts>();

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = true;
        ElectricProducts prodE = new ElectricProducts();
        prodE = (ElectricProducts) obj;
        if(arregloProductosElectricos.isEmpty())
        {
            arregloProductosElectricos.add(prodE);
        }
      return insertar; 
    }

    @Override
    public Object consultar(int idElectricProduct) {
        for (ElectricProducts productE: arregloProductosElectricos){
           if(productE.getNumeroSerial() == idElectricProduct){
               return productE;
           }
       }
        return null;
    }

    @Override
    public void consultar() {
        for (ElectricProducts productE : arregloProductosElectricos){
            System.out.println("Productos" + productE.toString());
        }
    }

    @Override
    public Object actualizar(int idElectricProduct) {
        for(ElectricProducts EProducts : arregloProductosElectricos){
            if(EProducts.getNumeroSerial() == idElectricProduct){
                
                EProducts.setNombre(EProducts.getNombre());
                EProducts.setDescripcion(EProducts.getNombre());
                EProducts.setIdBodega(EProducts.getIdBodega());
                EProducts.setColor(EProducts.getColor());
                EProducts.setMarca(EProducts.getMarca());
                EProducts.setMaterial(EProducts.getMaterial());
                EProducts.setDemanda(EProducts.getDemanda());
                EProducts.setCostoProduccion(EProducts.getCostoProduccion());
                EProducts.setCostoVenta(EProducts.getCostoVenta());
                EProducts.setCostoAlmacenamiento(EProducts.getCostoAlmacenamiento());
                EProducts.setCarga(EProducts.getCarga());
                EProducts.setCalibre(EProducts.getCalibre());
                
                return EProducts;
            }
        }
        return null ;
    }

    @Override
    public boolean borrar(Object obj) {
        if( obj instanceof ElectricProducts){
            ElectricProducts eProductABorrar = (ElectricProducts) obj;
            boolean eliminado = arregloProductosElectricos.remove(eProductABorrar);
            return true;
        }
        return false;
    }

    @Override
    public boolean ordenar() {
        if(!arregloProductosElectricos.isEmpty()){
            Collections.sort(arregloProductosElectricos);
            return true;
        }
        return false;
    }

    @Override
    public Object consultar(Object obj) {
        ElectricProducts pe = (ElectricProducts)obj;
            int pos=Collections.binarySearch(arregloProductosElectricos, pe);
            if(pos>0)
                return arregloProductosElectricos.get(pos);
            else
                return null;
    }
    
}
