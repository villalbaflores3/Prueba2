package com.apply.Services;

import java.util.List;


import com.apply.Models.Asignacion;
import com.apply.Models.Empleado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItem  extends CrudRepository<Asignacion, Long>{


    public List<Empleado> findEmpleadoById(Long id);
    

}
