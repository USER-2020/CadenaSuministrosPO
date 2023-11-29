/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Juan Fernando Zuluaga
 */
public class Vendedor extends Usuario {

    private Date fechaIngresoVendedor;
    private float sueldoVendedor;

    public Vendedor() {
    }

    public Vendedor(Date fechaIngresoVendedor, float sueldoVendedor, int id, String tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email) {
        super(id, tipoUSer, nombre, apellido, direccion, cellphone, email);
        this.fechaIngresoVendedor = fechaIngresoVendedor;
        this.sueldoVendedor = sueldoVendedor;
    }

    public Date getFechaIngresoVendedor() {
        return fechaIngresoVendedor;
    }

    public void setFechaIngresoVendedor(Date fechaIngresoVendedor) {
        this.fechaIngresoVendedor = fechaIngresoVendedor;
    }

    public float getSueldoVendedor() {
        return sueldoVendedor;
    }

    public void setSueldoVendedor(float sueldoVendedor) {
        this.sueldoVendedor = sueldoVendedor;
    }

    @Override
    public String toString() {
        return super.toString() + "Vendedor{"
                + "fechaIngresoVendedor=" + fechaIngresoVendedor
                + ", sueldoVendedor=" + sueldoVendedor
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fechaIngresoVendedor);
        hash = 97 * hash + Float.floatToIntBits(this.sueldoVendedor);
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
        final Vendedor other = (Vendedor) obj;
        if (Float.floatToIntBits(this.sueldoVendedor) != Float.floatToIntBits(other.sueldoVendedor)) {
            return false;
        }
        return Objects.equals(this.fechaIngresoVendedor, other.fechaIngresoVendedor);
    }

    
}
