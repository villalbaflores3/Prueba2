package com.apply.Services;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.apply.Models.Equipo;
import com.apply.Models.Dao.IEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipoServiceImpl implements IEquipoService{
    

    @PersistenceContext
    private EntityManager em;

     
    @Autowired
    private IEquipo equipoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll() {
        
        return (List<Equipo>) equipoDao.findAll();
    }

    @Override
    public Long count() {


        Long cResults;
        try {
            Query query = (Query) em.createQuery("SELECT COUNT(*) FROM Empleado");
            cResults=(Long) ((javax.persistence.Query) query).getSingleResult();
            return cResults;
            
        } catch (Exception e) {
            return null;
        }
 
    }

    @Override
    @Transactional
    public void save(Equipo equipo) {
        equipoDao.save(equipo);        

    }

    @Override
    @Transactional(readOnly = true)
    public Equipo findOne(Long id) {
        return equipoDao.findById(id).orElse(null   );
    }

    @Override
    @Transactional
    public void delete(Long id) {
        equipoDao.deleteById(id);
        
    }


    

}
