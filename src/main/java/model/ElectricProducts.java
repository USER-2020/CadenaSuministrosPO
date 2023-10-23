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

    public ElectricProducts() {
    }
    
    
    public ElectricProducts(String carga, String calibre, String descripcion, String nombre, int numeroSerial, int idBodega, String color, String imagen, String marca, String material, String demanda, float costoProduccion, float costoVenta, float costoAlmacenamiento) {
        super(descripcion, nombre, numeroSerial, idBodega, color, imagen, marca, material, demanda, costoProduccion, costoVenta, costoAlmacenamiento);
        this.carga = carga;
        this.calibre = calibre;
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
        return super.toString() + "ElectricProducts{" + "carga=" + carga + ", calibre=" + calibre + '}';
    }

      
    
    @Override
    public int compareTo(Product otroProducto) {
        // Implementa la lógica de comparación específica para ElectricProducts
        // Puedes usar el número de serie u otra propiedad relevante
        // Asegúrate de hacer un casting adecuado si es necesario
        if (otroProducto instanceof ElectricProducts) {
            ElectricProducts otroElectrico = (ElectricProducts) otroProducto;
            return Integer.compare(this.numeroSerial, otroElectrico.numeroSerial);
        }
        // Implementa la comparación si el otro objeto no es de tipo ElectricProducts
        return super.compareTo(otroProducto);
    }
    
}
