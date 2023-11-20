/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Juan Fernando Zuluaga Aguirre
 */
public interface ICRUD {
    public boolean insertar(Object obj); //Create
    public Object consultar(int id);
    public void consultar();
    public Object actualizar(int id); //Update
    public boolean borrar(Object obj); //Delete
    public void ordenar();
    public void ordenarBurbuja(JTable paramTablaTotalProductos);
    public void ordenar(int i, int j, JTable paramTablaTotalProductos);
    public void ordenar(int i, int j, ArrayList array, JTable paramTablaTotalProductos);
    public Object consultar(Object obj);
    
}
