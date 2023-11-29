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
public class Administrador extends Usuario {

    private Date fechaIngresoAdministrador;
    private float sueldoAdministrador;

    public Administrador(Date fechaIngresoAdministrador, float sueldoAdministrador, int id, String tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email) {
        super(id, tipoUSer, nombre, apellido, direccion, cellphone, email);
        this.fechaIngresoAdministrador = fechaIngresoAdministrador;
        this.sueldoAdministrador = sueldoAdministrador;
    }

    public Administrador() {
    }

    public Date getFechaIngresoAdministrador() {
        return fechaIngresoAdministrador;
    }

    public void setFechaIngresoAdministrador(Date fechaIngresoAdministrador) {
        this.fechaIngresoAdministrador = fechaIngresoAdministrador;
    }

    public float getSueldoAdministrador() {
        return sueldoAdministrador;
    }

    public void setSueldoAdministrador(float sueldoAdministrador) {
        this.sueldoAdministrador = sueldoAdministrador;
    }

    @Override
    public String toString() {
        return super.toString() + "Administrador{" + "fechaIngresoAdministrador=" + fechaIngresoAdministrador + ", sueldoAdministrador=" + sueldoAdministrador + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.fechaIngresoAdministrador);
        hash = 23 * hash + Float.floatToIntBits(this.sueldoAdministrador);
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
        final Administrador other = (Administrador) obj;
        if (Float.floatToIntBits(this.sueldoAdministrador) != Float.floatToIntBits(other.sueldoAdministrador)) {
            return false;
        }
        return Objects.equals(this.fechaIngresoAdministrador, other.fechaIngresoAdministrador);
    }

}
