package com.apply.Models.Dao;

import java.nio.file.Path;
import java.util.List;

import javax.transaction.Transactional;

import com.apply.Models.Factura;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactura extends CrudRepository<Factura, Long> {

    List<Factura> findByFolio(String folio);
    List<Factura> findByOrdenCompra(String orden);
    

    @Transactional
    @Modifying
  //  @Query(value = "UPDATE Factura f SET f.xml = :path, f.status = :status WHERE f.ordenCompra = :ordenCompra")
    @Query(value = "UPDATE facturas SET xml = :path, status = :status WHERE folio = :folio", nativeQuery = true)
    void  CerrarFactura(@Param(value =   "path") String rutaCompleta, @Param(value =  "status") boolean status ,  @Param(value =  "folio") String folio);
    
}
