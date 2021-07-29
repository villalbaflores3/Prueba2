package com.apply.Services;

import com.apply.Models.Empleado;
import com.apply.Models.Dao.IEmpleado;
import com.apply.Models.Dao.IRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmpleadoService {
    private IEmpleado empladoRepository;
    private IRole roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public EmpleadoService(IEmpleado empleadoRepository,
                       IRole roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.empladoRepository = empleadoRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Empleado findUserByEmail(String email) {
        return empladoRepository.findByCorreo(email);
    }

    public Empleado findUserByNEmpleado(String nombre) {
        return empladoRepository.findByNombre(nombre);
    }

    
}
