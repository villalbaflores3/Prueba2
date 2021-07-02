package com.cjava.developer.model.daos;

import org.springframework.data.repository.CrudRepository;

import com.cjava.developer.model.entities.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}