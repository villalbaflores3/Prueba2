package com.apply.Models.Dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.apply.Models.Equipo;

import org.springframework.stereotype.Repository;

@Repository
public class Equipoimpl implements IEquipo{

    @PersistenceContext
    private EntityManager em;
    




    @Override
    public <S extends Equipo> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Equipo> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Equipo> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Equipo> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Equipo entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Equipo> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }
    


}
