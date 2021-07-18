package com.apply.Models.Dao;

import javax.transaction.Transactional;

import com.apply.Models.Asignacion;
import com.apply.Models.Empleado;
import com.apply.Models.Equipo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAsignacion  extends CrudRepository<Asignacion, Long>{
    
    @Transactional
    @Modifying
    @Query(value = "insert into asignaciones (descripcion, empleado_id, equipo_id) values (:descripcion, :empleado, :equipo)",
    nativeQuery = true)
    public void crearNuevo(@Param("descripcion") String descripcion, @Param("empleado") int idEmpleado, @Param("equipo") int idEquipo );

    @Transactional
    @Modifying
    @Query(value = "update equipos SET equipo_asignado = 1 WHERE id = :idEquipo" ,
    nativeQuery = true)
    public void ocuparEquipo (int idEquipo);

    @Transactional
    @Modifying
    @Query(value = "update empleados SET equipado = true WHERE id = :idEmpleado" ,
    nativeQuery = true)
    public void ocuparEmpleado (int idEmpleado);

    @Transactional
    @Modifying
    @Query(value = "update equipos SET  empleado_id = :idEmpleado WHERE id = :idEquipo" ,
    nativeQuery = true)
    public void asignarEquipo(int idEmpleado, int idEquipo);

    
}
