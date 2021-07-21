package com.apply.Services;

import java.util.List;

import com.apply.Models.OrdenCompra;
import com.apply.Models.Dao.IOrdenCompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdeCompraService {
    
@Autowired
IOrdenCompra ordenCompra;


@Transactional(readOnly = true)
public List<OrdenCompra> findAll(){

    return (List<OrdenCompra>) ordenCompra.findAll();
}


@Transactional
public void save(OrdenCompra orden){
    ordenCompra.save(orden);
}


@Transactional
public OrdenCompra findOne(Long id){

    return ordenCompra.findById(id).orElse(null);
}





}
