/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Administrador;

/**
 *
 * @author Juan Zuluaga
 */
public class AdministradorController implements ICRUD{
    
    public static ArrayList<Administrador> arregloAdministradores = new ArrayList<Administrador>();

    @Override
    public boolean insertar(Object obj) {
         boolean insertar = true;
        Administrador admin = new Administrador();
        admin = (Administrador) obj;
        if(arregloAdministradores.isEmpty())
        {
            arregloAdministradores.add(admin);
        }
      return insertar; 
    }

    @Override
    public Object consultar(int idAdministrador) {
        for (Administrador admin: arregloAdministradores){
           if(admin.getId() == idAdministrador){
               return admin;
           }
       }
        return null;
    }

    @Override
    public void consultar() {
        for (Administrador admin : arregloAdministradores){
            System.out.println("Administradores" + admin.toString());
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
        Administrador admin = (Administrador)obj;
            int pos=Collections.binarySearch(arregloAdministradores, admin);
            if(pos>0)
                return arregloAdministradores.get(pos);
            else
                return null;
    }
}
