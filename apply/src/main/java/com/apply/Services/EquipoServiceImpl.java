package com.apply.Services;

import java.util.List;

import com.apply.Models.Equipo;
import com.apply.Models.Dao.IEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoServiceImpl implements IEquipoService{
    

     
    @Autowired
    private IEquipo equipoDao;

    @Override
    public List<Equipo> findAll() {
        
        return (List<Equipo>) equipoDao.findAll();
    }

    @Override
    public Number count() {
        return null;
    }

    @Override
    public void save(Equipo equipo) {
        equipoDao.save(equipo);        

    }

    @Override
    public Equipo findOne(Long id) {
        return equipoDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }


    

}
