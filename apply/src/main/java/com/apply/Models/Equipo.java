package com.apply.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "equipos")
public class Equipo  implements Serializable{

private static final long serialVersionUID= 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String marca;

@NotEmpty
private String modelo;

@Column(name = "dd_gb")
private int ddRam;

@NotNull
private long ram;

@NotNull
private String procesador;


@NotEmpty
@Column(name = "velocidad_procesador")
private String velocidadProcesador;

@Column(name = "equipo_asignado")
private boolean equipoAsignado = false;


@OneToOne()
@JoinColumn(name = "equipo")
Categoria categoria;

@OneToOne(fetch = FetchType.LAZY)

Asignacion asignacion;









public Asignacion getAsignacion() {
    return asignacion;
}







public void setAsignacion(Asignacion asignacion) {
    this.asignacion = asignacion;
}







public String getSerie() {
    return serie;
}







public void setSerie(String serie) {
    this.serie = serie;
}





private String serie;



@Temporal(TemporalType.TIMESTAMP)
private Date fechaAlta;


@ManyToOne(fetch = FetchType.LAZY)
private Empleado empleado;



public Empleado getEmpleado() {
    return empleado;
}







public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
}







@PrePersist
void preInsert() {
    fechaAlta = new Date();
}







public static long getSerialversionuid() {
    return serialVersionUID;
}





public Equipo() {
}







public Equipo(Long id, @NotEmpty String marca, @NotEmpty String modelo, int ddRam, @NotEmpty int ram,
        @NotEmpty String procesador, @NotNull String velocidadProcesador, boolean equipoAsignado, Date fechaAlta) {
    this.id = id;
    this.marca = marca;
    this.modelo = modelo;
    this.ddRam = ddRam;
    this.ram = ram;
    this.procesador = procesador;
    this.velocidadProcesador = velocidadProcesador;
    this.equipoAsignado = equipoAsignado;
    this.fechaAlta = fechaAlta;
}







public Long getId() {
    return id;
}





public void setId(Long id) {
    this.id = id;
}





public String getMarca() {
    return marca;
}





public void setMarca(String marca) {
    this.marca = marca;
}





public String getModelo() {
    return modelo;
}





public void setModelo(String modelo) {
    this.modelo = modelo;
}





public int getDdRam() {
    return ddRam;
}





public void setDdRam(int ddRam) {
    this.ddRam = ddRam;
}





public long getRam() {
    return ram;
}





public void setRam(long ram) {
    this.ram = ram;
}





public String getProcesador() {
    return procesador;
}





public void setProcesador(String procesador) {
    this.procesador = procesador;
}





public String getVelocidadProcesador() {
    return velocidadProcesador;
}





public void setVelocidadProcesador(String velocidadProcesador) {
    this.velocidadProcesador = velocidadProcesador;
}





public boolean isEquipoAsignado() {
    return equipoAsignado;
}





public void setEquipoAsignado(boolean equipoAsignado) {
    this.equipoAsignado = equipoAsignado;
}





public Date getFechaAlta() {
    return fechaAlta;
}





public void setFechaAlta(Date fechaAlta) {
    this.fechaAlta = fechaAlta;
}





}


