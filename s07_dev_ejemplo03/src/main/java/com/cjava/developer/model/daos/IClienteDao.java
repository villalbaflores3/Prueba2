package com.cjava.developer.model.daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cjava.developer.model.entities.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{


}
