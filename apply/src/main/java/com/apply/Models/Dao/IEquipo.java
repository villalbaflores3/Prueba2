package com.apply.Models.Dao;

import java.util.List;

import com.apply.Models.Equipo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Primary
public interface IEquipo extends CrudRepository<Equipo, Long>{
    public long count();

    @Query("select e from Equipo  e  where e.equipoAsignado = false ")
    public List<Equipo> findAllByEquipado();
}
