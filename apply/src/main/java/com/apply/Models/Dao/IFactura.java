package com.apply.Models.Dao;

import java.util.List;

import com.apply.Models.Factura;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactura extends CrudRepository<Factura, Long> {

    List<Factura> findByFolio(String folio);
    List<Factura> findByOrdenCompra(String orden);
    
}
