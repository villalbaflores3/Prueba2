package com.apply.Models;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
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
    private String  descripcion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;



    public Empleado getEmpleado() {
        return empleado;
    }



    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }







    public Equipo getEquipo() {
        return equipo;
    }



    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }



    @PrePersist
    public void prePersist(){
        fecha = new Date();
    }
    


     public Asignacion(Long id, String descripcion, Date fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        
    }
    



    public Asignacion() {
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
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



}
