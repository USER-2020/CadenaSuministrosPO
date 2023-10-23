/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Collections;
import model.Usuario;

/**
 *
 * @author Juan Zuluaga
 */
public class UsuarioController implements ICRUD{
    
    public static ArrayList<Usuario> arregloUsuarios = new ArrayList<Usuario>();

    @Override
    public boolean insertar(Object obj) {
       boolean insertar = true;
       Usuario user = new Usuario();
       user = (Usuario) obj;
       if(arregloUsuarios.isEmpty())
       {
           arregloUsuarios.add(user);
       }
       
       return insertar;
    }

    @Override
    public Object consultar(int idUsuario) {
        for (Usuario user: arregloUsuarios){
            if(user.getId() == idUsuario){
                return user;
            }
        }
        return null;
    }

    @Override
    public void consultar() {
       for(Usuario user : arregloUsuarios){
           System.out.println("Usuarios" + user.toString());
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
        Usuario user = (Usuario) obj;
        int pos = Collections.binarySearch(arregloUsuarios, user);
        if(pos > 0 )
            return arregloUsuarios.get(pos);
        else
            return null;
    }
}
