package com.apply.Models.Dao;

import java.util.List;

import com.apply.Models.Asignacion;
import com.apply.Models.Empleado;
import com.apply.Models.Equipo;

import org.springframework.data.jpa.repository.Query;

public interface IEmpleado  {
    
    public List<Empleado> findAll();
    public Number count();
    public void save(Empleado empleado);
    public Empleado findOne(Long id);
    public void delete(Long id);

    @Query("Update Empleado e SET e.equipos = :idEquipo WHERE e.id = :id")
    public void saveEquipo(Long idEquipo, Long id);
    public void saveAsignacion(Asignacion asignacion);
    public Equipo findEquipoById(Long id);


}
