package com.apply.Models.Dao;

import java.util.Optional;

import com.apply.Models.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoReporsitory  extends JpaRepository<Empleado, Long>{
    
    Optional< Empleado > findByCorreo(String correo);
}
