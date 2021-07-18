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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.apply.Models.Dao.EmpleadoImpl;


@Entity
@Table(name = "asignacion_item")
public class ItemAsignacion implements Serializable{
    
    private static final long serialVersionUID= 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Equipo getEquipo() {
        return equipo;
    }


    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }


    public Dispositivo getDispositivo() {
        return dispositivo;
    }


    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }


    public Empleado getEmpleado() {
        return empleado;
    }


    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }


    public Date getCreadoEn() {
        return CreadoEn;
    }


    public void setCreadoEn(Date creadoEn) {
        CreadoEn = creadoEn;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispositivo_id")
    private Dispositivo dispositivo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date CreadoEn;



    

@PrePersist
public void prePersist(){
    CreadoEn = new Date();
}

    
    public ItemAsignacion() {


    }





}
