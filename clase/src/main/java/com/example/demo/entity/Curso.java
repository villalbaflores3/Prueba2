package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Curso  implements Serializable{


private static final long serialVersionUID = 1L;



public Curso() {
}

@Id	
private Long id;

@NotEmpty
private String nombre;

@NotEmpty
private int credito;

@NotEmpty
private String fecha;


public String getFecha() {
	return fecha;
}

public void setFecha(String fecha) {
	this.fecha = fecha;
}





public Long getId() {
	return id;
}





@Override
public String toString() {
	return "Curso [id=" + id + ", nombre=" + nombre + ", credito=" + credito + "]";
}





public Curso(Long id, @NotEmpty String nombre, @NotEmpty int credito) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.credito = credito;
}





public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getCredito() {
	return credito;
}

public void setCredito(int credito) {
	this.credito = credito;
}
	



	
}
