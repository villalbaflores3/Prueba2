package com.apply.Services;

import java.util.List;

import com.apply.Models.Factura;
import com.apply.Models.Dao.IFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.implementation.bind.annotation.Super;

public class FacturaImpl {
    
    @Autowired
    IFactura facturaDao;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return (List<Factura>) facturaDao.findAll();
    }


    @SuppressWarnings("unchecked")
    @Transactional
    public void save(Factura factura) {
        facturaDao.save(factura);        

    }


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public Factura findOne(Long id) {
        return (Factura) facturaDao.findById(id).orElse(null);
    }



    
    @SuppressWarnings("unchecked")
    @Transactional
    public void delete(Long id) {
        facturaDao.deleteById(id);

    }


}
