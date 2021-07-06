package com.apply.Models.Dao;

import java.util.List;

import com.apply.Models.Empleado;

public interface IEmpleado  {
    
    public List<Empleado> findAll();
    public Number count();
    public void save(Empleado empleado);
    public Empleado findOne(Long id);

    

}
