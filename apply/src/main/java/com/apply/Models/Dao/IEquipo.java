package com.apply.Models.Dao;

import com.apply.Models.Equipo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;


@Primary
public interface IEquipo extends CrudRepository<Equipo, Long>{
    
}
