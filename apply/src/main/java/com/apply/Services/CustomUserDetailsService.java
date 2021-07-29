package com.apply.Services;

import java.util.Optional;

import com.apply.Models.Empleado;
import com.apply.Models.Dao.CustomUserDetails;
import com.apply.Models.Dao.EmpleadoReporsitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService  implements UserDetailsService{

    @Autowired
    private EmpleadoReporsitory empleadoReporsitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional< Empleado > optionalEmpleado = empleadoReporsitory.findByCorreo(username);
        

        optionalEmpleado
        .orElseThrow(()-> new UsernameNotFoundException("no encontrado"));
        return optionalEmpleado.map(CustomUserDetails::new).get();
    }

    
}