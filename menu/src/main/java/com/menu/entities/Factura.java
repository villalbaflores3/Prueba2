package com.menu.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;



public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotEmpty
	private String descripcion;

	private String observacion;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_factura")
	private List<ItemFactura> items;

    
    public Factura() {
		this.items = new ArrayList<ItemFactura>();
	}



}