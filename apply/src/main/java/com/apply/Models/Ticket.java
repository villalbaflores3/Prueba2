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
@Table(name = "tickets")
public class Ticket implements Serializable {
    

private static final long serialVersionUID= 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotEmpty
private String asunto;

@NotEmpty
private String descripcion;

@Column(name = "status_ticket")
private boolean statusTicket;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "fecha_inicio")
private Date fechaInicio;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "fecha_final")
private Date fechaFinal;

@ManyToOne(fetch = FetchType.LAZY)
private Empleado empleado;


@Column(name = "tiempo_resuelto")
private Date tiempoTotal;










public Ticket() {
}












public Ticket(@NotEmpty String asunto, @NotEmpty String descripcion, boolean statusTicket, Date fechaInicio,
        Date fechaFinal, Date tiempoTotal) {
    this.asunto = asunto;
    this.descripcion = descripcion;
    this.statusTicket = statusTicket;
    this.fechaInicio = fechaInicio;
    this.fechaFinal = fechaFinal;
    this.tiempoTotal = tiempoTotal;
}



public static long getSerialversionuid() {
    return serialVersionUID;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getAsunto() {
    return asunto;
}

public void setAsunto(String asunto) {
    this.asunto = asunto;
}

public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public boolean isStatusTicket() {
    return statusTicket;
}

public void setStatusTicket(boolean statusTicket) {
    this.statusTicket = statusTicket;
}

public Date getFechaInicio() {
    return fechaInicio;
}

public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
}

public Date getFechaFinal() {
    return fechaFinal;
}

public void setFechaFinal(Date fechaFinal) {
    this.fechaFinal = fechaFinal;
}

public Date getTiempoTotal() {
    return tiempoTotal;
}

public void setTiempoTotal(Date tiempoTotal) {
    this.tiempoTotal = tiempoTotal;
}













}
