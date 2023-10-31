/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 * Juan Fernando Zuluaga
 *
 *
 */
public class Usuario implements Comparable<Usuario> {

    public enum TipoUsuario {
        Administrador,
        Bodeguero,
        Vendedor
    }

    private int id;
    private TipoUsuario tipoUSer;
    private String nombre;
    private String apellido;
    private String direccion;
    private String cellphone;
    private String email;

    public Usuario(int id, TipoUsuario tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email) {
        this.id = id;
        this.tipoUSer = tipoUSer;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cellphone = cellphone;
        this.email = email;
        
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoUsuario getTipoUSer() {
        return tipoUSer;
    }

    public void setTipoUSer(TipoUsuario tipoUSer) {
        this.tipoUSer = tipoUSer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int compareTo(Usuario otroUsuario) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return Integer.compare(this.id, otroUsuario.id);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipoUSer=" + tipoUSer + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", cellphone=" + cellphone + ", email=" + email + '}';
    }
    
    

}
