/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Juan Fernando Zuluaga Aguirre
 */
public interface ICRUD {
    public boolean insertar(Object obj); //Create
    public Object consultar(int idProducto);
    public void consultar();
    public Object actualizar(int idProducto); //Update
    public boolean borrar(Object obj); //Delete
    public boolean ordenar();
    public Object consultar(Object obj);
    
}
