package com.apply.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name = "ordenes_compra")
public class OrdenCompra implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    
    
    @NotEmpty   
    private String  descripcion;
    

    @NotNull
    private Long cantidad;
    

    @NotNull
    private Long precio;
    

    @OneToOne
    private Proveedor proveedor;



    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;


    
@PrePersist
public void prePersist(){

    this.fechaAlta = new Date();
    
}

}
