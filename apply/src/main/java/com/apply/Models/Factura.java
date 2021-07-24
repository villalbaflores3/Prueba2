package com.apply.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "facturas")
public class Factura  implements Serializable{
    
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotEmpty
    private String folio;

    @Column(name = "razon_social")
    private String razonSocial;


    private String producto;


    private String descripcion;

    private int cantidad;

    private float precio;

    private String proveedor;

    @Column(name = "o_compra",  unique = true)
    private String ordenCompra = "OD" + numeroaletorio();


    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    private float total = multiplicar();

    @Column(columnDefinition = "boolean default false")
    private Boolean  status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    
    @PrePersist
    public void prePersist(){
    this.fechaAlta = new Date();
    }



    public String getProveedor() {
        return proveedor;
    }



    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }




    public String getOrdenCompra() {
        return ordenCompra;
    }



    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }



    public Empleado getEmpleado() {
        return empleado;
    }



    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }



    public Boolean getStatus() {
        return status;
    }



    public void setStatus(Boolean status) {
        this.status = status;
    }



    public Date getFechaAlta() {
        return fechaAlta;
    }



    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }



    public int numeroaletorio(){
        int numero;
        numero = (int) (Math.random() * (120001 - 99)) + 99;
        return numero;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFolio() {
        return folio;
    }


    public void setFolio(String folio) {
        this.folio = folio;
    }


    public String getRazonSocial() {
        return razonSocial;
    }


    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }


    public String getProducto() {
        return producto;
    }


    public void setProducto(String producto) {
        this.producto = producto;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public float getPrecio() {
        return precio;
    }


    public void setPrecio(float precio) {
        this.precio = precio;
    }


    public float getTotal() {
        return total;
    }


    public void setTotal(float total) {
        this.total = total;
    }


    public float multiplicar(){

        float multiplicar;

        multiplicar = this.precio * this.cantidad;
        
        return multiplicar;
    }
    
}
