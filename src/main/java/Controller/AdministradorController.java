/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Administrador;
import model.Usuario;

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
    public Object actualizar(int idAdmin) {
        for(Administrador admin : arregloAdministradores){
            if( admin.getId() == idAdmin){
                admin.setNombre(admin.getNombre());
                admin.setApellido(admin.getApellido());
                admin.setTipoUSer("Administrador");
                admin.setDireccion(admin.getDireccion());
                admin.setEmail(admin.getEmail());
                admin.setCellphone(admin.getCellphone());
                
                return admin;
            }
        }
        return null;
    }

    @Override
    public boolean borrar(Object obj) {
        if(obj instanceof Administrador) {
            Administrador adminABorrar = (Administrador) obj;
            boolean eliminado = arregloAdministradores.remove(adminABorrar);
            return eliminado;
        }
        return false;
    }

    @Override
    public boolean ordenar() {
        if(!arregloAdministradores.isEmpty()){
            Collections.sort(arregloAdministradores);
            return true;
        }
        return false;
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
