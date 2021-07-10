package com.apply.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "asignaciones")
public class Asignacion implements Serializable{

private static final long serialVersionUID= 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String descripcion;

@Temporal(TemporalType.TIMESTAMP)
private Date fechaInicio;

@ManyToOne(fetch = FetchType.LAZY)  
private Empleado empleado;

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "asignacion_id")
private List<ItemAsignacion> items;




public void addItems(ItemAsignacion items){

    this.items.add(items);
}



public List<ItemAsignacion> getItems() {
    return items;
}





public void setItems(List<ItemAsignacion> items) {
    this.items = items;
}





@PrePersist
public void prePersist(){
    fechaInicio = new Date();
}



public Asignacion(){
    this.items = new ArrayList<ItemAsignacion>();
}

public Asignacion(Long id, String descripcion, Date fechaInicio, Empleado empleado) {
    this.id = id;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.empleado = empleado;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public Date getFechaInicio() {
    return fechaInicio;
}
public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
}
public Empleado getEmpleado() {
    return empleado;
}
public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
}

    
}
