package com.apply.Services;

import java.util.List;

import com.apply.Models.Equipo;

public interface IEquipoService {
     
    public List<Equipo> findAll();
    public Number count();
    public void save(Equipo equipo);
    public Equipo findOne(Long id);
    public void delete(Long id);
}
