/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author Juan Zuluaga
 */
public class UsuarioDTO implements Comparable<UsuarioDTO> {

    private int id;
    private String tipoUSer;
    private String nombre;
    private String apellido;
    private String direccion;
    private String cellphone;
    private String email;
    private String fecha_ingreso;
    private float sueldo;

    public UsuarioDTO(int id, String tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email, String fecha_ingreso, float sueldo) {
        this.id = id;
        this.tipoUSer = tipoUSer;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.cellphone = cellphone;
        this.email = email;
        this.fecha_ingreso = fecha_ingreso;
        this.sueldo = sueldo;
    }

    public UsuarioDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoUSer() {
        return tipoUSer;
    }

    public void setTipoUSer(String tipoUSer) {
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

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final UsuarioDTO other = (UsuarioDTO) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", tipoUSer=" + tipoUSer + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", cellphone=" + cellphone + ", email=" + email + ", fecha_ingreso=" + fecha_ingreso + ", sueldo=" + sueldo + '}';
    }

    @Override
    public int compareTo(UsuarioDTO otroUser) {
        return Integer.compare(this.id, otroUser.id);
    }

}
