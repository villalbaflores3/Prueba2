package com.menu.daos;

import com.menu.entities.Cliente;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao  extends PagingAndSortingRepository<Cliente, Long>{
    
}
