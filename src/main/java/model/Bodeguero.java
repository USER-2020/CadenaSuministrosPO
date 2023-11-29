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
public class Bodeguero extends Usuario {

    private Date fechaIngresoBodeguero;
    private float sueldoBodeguero;

    public Bodeguero(Date fechaIngresoBodeguero, float sueldoBodeguero, int id, String tipoUSer, String nombre, String apellido, String direccion, String cellphone, String email) {
        super(id, tipoUSer, nombre, apellido, direccion, cellphone, email);
        this.fechaIngresoBodeguero = fechaIngresoBodeguero;
        this.sueldoBodeguero = sueldoBodeguero;
    }

    public Bodeguero() {
    }

    public Date getFechaIngresoBodeguero() {
        return fechaIngresoBodeguero;
    }

    public void setFechaIngresoBodeguero(Date fechaIngresoBodeguero) {
        this.fechaIngresoBodeguero = fechaIngresoBodeguero;
    }

    public float getSueldoBodeguero() {
        return sueldoBodeguero;
    }

    public void setSueldoBodeguero(float sueldoBodeguero) {
        this.sueldoBodeguero = sueldoBodeguero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.fechaIngresoBodeguero);
        hash = 41 * hash + Float.floatToIntBits(this.sueldoBodeguero);
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
        final Bodeguero other = (Bodeguero) obj;
        if (Float.floatToIntBits(this.sueldoBodeguero) != Float.floatToIntBits(other.sueldoBodeguero)) {
            return false;
        }
        return Objects.equals(this.fechaIngresoBodeguero, other.fechaIngresoBodeguero);
    }

    @Override
    public String toString() {
        return super.toString() + "Bodeguero{" + "fechaIngresoBodeguero=" + fechaIngresoBodeguero + ", sueldoBodeguero=" + sueldoBodeguero + '}';
    }

}
