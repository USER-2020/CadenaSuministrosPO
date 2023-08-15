/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juan Fernando Zuluaga
 */
public class Product {
    //Componente  de una clase concreta
    //Atributos tienen modificadores que definen la visibilidad
    /**
     * public
     * private
     * protected
     * within
     **/
    private String nombre;
    private int numeroSerial;
    private String color;
    private String imagen;
    private String marca;
    private String material;
    private float costoProduccion;
    private float costoVenta;
    private float costoAlmacenamiento;
    
    //Contructores
    public Product(String nombre, int numeroSerial, String color, String imagen, String marca, String material, float costoProduccion, float costoVenta, float costoAlmacenamiento) {    
        this.numeroSerial = numeroSerial;
        this.nombre = nombre;
        this.color = color;
        this.imagen = imagen;
        this.marca = marca;
        this.material = material;
        this.costoProduccion = costoProduccion;
        this.costoVenta = costoVenta;
        this.costoAlmacenamiento = costoAlmacenamiento;
    }

    public Product() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Métodos
    //Getter
    public String getNombre() {
        return nombre;
    }

    public int getNumeroSerial() {
        return numeroSerial;
    }

    public String getColor() {
        return color;
    }

    public String getImagen() {
        return imagen;
    }

    public String getMarca() {
        return marca;
    }

    public String getMaterial() {
        return material;
    }

    public float getCostoProduccion() {
        return costoProduccion;
    }

    public float getCostoVenta() {
        return costoVenta;
    }

    public float getCostoAlmacenamiento() {
        return costoAlmacenamiento;
    }
    
    //Setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroSerial(int numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setCostoProduccion(float costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public void setCostoVenta(float costoVenta) {
        this.costoVenta = costoVenta;
    }

    public void setCostoAlmacenamiento(float costoAlmacenamiento) {
        this.costoAlmacenamiento = costoAlmacenamiento;
    }

    @Override
    public String toString() {
        return "Product{" + "nombre=" + nombre + ", numeroSerial=" + numeroSerial + ", color=" + color + ", imagen=" + imagen + ", marca=" + marca + ", material=" + material + ", costoProduccion=" + costoProduccion + ", costoVenta=" + costoVenta + ", costoAlmacenamiento=" + costoAlmacenamiento + '}';
    }
    
    
    
    
    
}
