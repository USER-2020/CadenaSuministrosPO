/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juan Fernando Zuluaga
 */
public class ElectricProducts extends Product{
    
    private String carga;
    private String calibre;

    public ElectricProducts(String carga, String calibre, String descripcion, String nombre, int numeroSerial, String color, String imagen, String marca, String material, float costoProduccion, float costoVenta, float costoAlmacenamiento) {
        super(descripcion, nombre, numeroSerial, color, imagen, marca, material, costoProduccion, costoVenta, costoAlmacenamiento);
        this.carga = carga;
        this.calibre = calibre;
    }

    
    public ElectricProducts(String descripcion, String nombre, int numeroSerial, String color, String imagen, String marca, String material, float costoProduccion, float costoVenta, float costoAlmacenamiento) {
        super(descripcion, nombre, numeroSerial, color, imagen, marca, material, costoProduccion, costoVenta, costoAlmacenamiento);
    }

    public ElectricProducts() {
    }

    public ElectricProducts(String carga, String calibre) {
        this.carga = carga;
        this.calibre = calibre;
    }

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    @Override
    public String toString() {
        return super.toString()+"ElectricProducts{" + "carga=" + carga + ", calibre=" + calibre + '}';
    }
    
    
    
}
