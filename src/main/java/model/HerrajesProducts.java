/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juan Fernando Zuluaga
 */
public class HerrajesProducts extends Product{
    
    private String tipoElemento;

    public HerrajesProducts(String tipoElemento, String descripcion, String nombre, int numeroSerial, String color, String imagen, String marca, String material, float costoProduccion, float costoVenta, float costoAlmacenamiento) {
        super(descripcion, nombre, numeroSerial, color, imagen, marca, material, costoProduccion, costoVenta, costoAlmacenamiento);
        this.tipoElemento = tipoElemento;
    }

    public HerrajesProducts() {
    }

    public HerrajesProducts(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }
    
    

    @Override
    public String toString() {
        return super.toString()+"HerrajesProducts{" + "tipoElemento=" + tipoElemento + '}';
    }
    
    
    
}
