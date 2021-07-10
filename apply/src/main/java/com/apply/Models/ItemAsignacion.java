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

    private Integer cantidad;

    private Categoria categoria;

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
