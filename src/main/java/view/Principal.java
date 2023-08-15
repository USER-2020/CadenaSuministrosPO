/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.Product;
import model.Product;

/**
 *
 * @author Liliana Aguirre
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Si el objeto no tiene constructor por defecto es VACIO
        Product objProd1 = new Product( "Machete", 123 ,  "Blue", "imagen.png", "Ramo", "Madera-LaminaAcro", 2000, 20000, 1500);
        Product objProd2 = new Product("Bisagra", 234, "Green", "iamgenHerraje.png", "Herragro", "Oro", 3500, 150000, 300);
        
        System.out.println("Nombre Producto 1: " + objProd1.toString());
        System.out.println("Nombre Producto 2: " + objProd2.toString());
    }
    
}
