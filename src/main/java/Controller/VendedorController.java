/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import model.Usuario;
import model.Vendedor;

/**
 *
 * @author Juan Zuluaga
 */
public class VendedorController implements ICRUD{
    public static ArrayList<Vendedor> arregloVendedores = new ArrayList<Vendedor>();

    @Override
    public boolean insertar(Object obj) {
        boolean insertar = true;
        Vendedor seller = new Vendedor();
        seller = (Vendedor) obj;
        if(arregloVendedores.isEmpty()){
            arregloVendedores.add(seller);
        }else{
            arregloVendedores.add(seller);
        }
        return insertar;
    }

    @Override
    public Object consultar(int idVendedor) {
        for(Vendedor seller: arregloVendedores){
            if(seller.getId() == idVendedor){
                return seller;
            }            
        }
        return null; 
    }

    @Override
    public void consultar() {
        for(Vendedor seller: arregloVendedores){
            System.out.println("Vendedores" + seller.toString());
        }
    }

    @Override
    public Object actualizar(int idVendedor) {
        for (Vendedor vendedor : arregloVendedores) {
        if (vendedor.getId() == idVendedor) {                       
            // Realiza la lógica de actualización aquí, por ejemplo, cambiar propiedades del vendedor.
            // Después de actualizar, puedes devolver el objeto actualizado o un indicador de éxito.
            vendedor.setNombre(vendedor.getNombre());
            vendedor.setApellido(vendedor.getApellido());
            vendedor.setTipoUSer("Vendedor");
            vendedor.setDireccion(vendedor.getDireccion());
            vendedor.setEmail(vendedor.getEmail());
            vendedor.setCellphone(vendedor.getCellphone());
            
            return vendedor; // Devuelve el objeto actualizado
        }
    }
    // Si el vendedor con el ID dado no se encontró, puedes devolver null o lanzar una excepción, según tu preferencia.
    return null;
    }

    @Override
    public boolean borrar(Object obj) {
    if (obj instanceof Vendedor) {
        Vendedor vendedorABorrar = (Vendedor) obj;
        boolean eliminado = arregloVendedores.remove(vendedorABorrar);
        return eliminado;
    }
    return false;
    }

  

    @Override
    public Object consultar(Object obj) {
         Vendedor seller = (Vendedor) obj;
        int pos = Collections.binarySearch(arregloVendedores, seller);
        if(pos > 0 )
            return arregloVendedores.get(pos);
        else
            return null;
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
