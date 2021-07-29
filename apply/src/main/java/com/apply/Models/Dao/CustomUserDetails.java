package com.apply.Models.Dao;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.apply.Models.Empleado;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Empleado implements UserDetails{


    public CustomUserDetails(final Empleado empleado){

        super(empleado);


    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
       
       List<SimpleGrantedAuthority> list =  getRoles().
        stream()
        .map(role ->  new SimpleGrantedAuthority("ROLE_" + role.getRole()))
        .collect(Collectors.toList());
        
        return list;
    }

    @Override
    public String getPassword() {

        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    
}