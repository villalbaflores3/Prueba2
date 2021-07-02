package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Curso;


public interface CursoService {

       
    public List<Curso> findAll();

    public void save(Curso curso);

    public  Curso findOne(Long id);

    public void eliminar(Long id);


	
	
}
