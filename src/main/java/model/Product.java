/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;
import java.util.Objects;

/**
 *
 * @author Juan Fernando Zuluaga
 */
public class Product implements Comparable<Product> {

    //Componente  de una clase concreta
    //Atributos tienen modificadores que definen la visibilidad
    /**
     * public private protected within
     *
     */
    private String descripcion;
    private String nombre;
    public int numeroSerial;
    private int idBodega;
    private String color;
    private String imagen;
    private String marca;
    private String material;
    private String demanda;
    private float costoProduccion;
    private float costoVenta;
    private float costoAlmacenamiento;
    private Blob imagenBLOB;

    //Contructores
    public Product(String descripcion, String nombre, int numeroSerial, int idBodega, String color, String imagen, String marca, String material, String demanda, float costoProduccion, float costoVenta, float costoAlmacenamiento, Blob imagenBLOB) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.numeroSerial = numeroSerial;
        this.idBodega = idBodega;
        this.color = color;
        this.imagen = imagen;
        this.marca = marca;
        this.material = material;
        this.demanda = demanda;
        this.costoProduccion = costoProduccion;
        this.costoVenta = costoVenta;
        this.costoAlmacenamiento = costoAlmacenamiento;
        this.imagenBLOB = imagenBLOB;
    }

    public Product() {

    }

    //Métodos
    //Getter
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(int numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDemanda() {
        return demanda;
    }

    public void setDemanda(String demanda) {
        this.demanda = demanda;
    }

    public float getCostoProduccion() {
        return costoProduccion;
    }

    public void setCostoProduccion(float costoProduccion) {
        this.costoProduccion = costoProduccion;
    }

    public float getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(float costoVenta) {
        this.costoVenta = costoVenta;
    }

    public float getCostoAlmacenamiento() {
        return costoAlmacenamiento;
    }

    public void setCostoAlmacenamiento(float costoAlmacenamiento) {
        this.costoAlmacenamiento = costoAlmacenamiento;
    }

    public Blob getImagenBLOB() {
        return imagenBLOB;
    }

    public void setImagenBLOB(Blob imagenBLOB) {
        this.imagenBLOB = imagenBLOB;
    }

    @Override
    public String toString() {
        return "Product{" + "descripcion=" + descripcion + ", nombre=" + nombre + ", numeroSerial=" + numeroSerial + ", idBodega=" + idBodega + ", color=" + color + ", imagen=" + imagen + ", marca=" + marca + ", material=" + material + ", demanda=" + demanda + ", costoProduccion=" + costoProduccion + ", costoVenta=" + costoVenta + ", costoAlmacenamiento=" + costoAlmacenamiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.numeroSerial;
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
        final Product other = (Product) obj;
        if (this.numeroSerial != other.numeroSerial) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int compareTo(Product otroProducto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return Integer.compare(this.numeroSerial, otroProducto.numeroSerial);
    }

}
