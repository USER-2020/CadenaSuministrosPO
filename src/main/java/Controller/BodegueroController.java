/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Bodeguero;

/**
 *
 * @author Juan Zuluaga
 */
public class BodegueroController implements ICRUD{
    
    public static ArrayList<Bodeguero> arregloBodegueros = new ArrayList<Bodeguero>();

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = true;
        Bodeguero bodeguero = new Bodeguero();
        bodeguero = (Bodeguero) obj;
        if(arregloBodegueros.isEmpty())
        {
            arregloBodegueros.add(bodeguero);
        }
      return insertar; 
    }

    @Override
    public Object consultar(int idBodeguero) {
        for (Bodeguero bodeguero: arregloBodegueros){
           if(bodeguero.getId() == idBodeguero){
               return bodeguero;
           }
       }
        return null;
    }

    @Override
    public void consultar() {
        for (Bodeguero bodeguero : arregloBodegueros){
            System.out.println("Productos" + bodeguero.toString());
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
         Bodeguero bd = (Bodeguero)obj;
            int pos=Collections.binarySearch(arregloBodegueros, bd);
            if(pos>0)
                return arregloBodegueros.get(pos);
            else
                return null;
    }
    
}
