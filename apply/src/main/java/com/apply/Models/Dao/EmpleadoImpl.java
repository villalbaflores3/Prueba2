package com.apply.Models.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.apply.Models.Empleado;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class EmpleadoImpl implements IEmpleado {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Empleado> findAll() {

        return em.createQuery("from Empleado").getResultList();
    }
    


    @Override
    public Long count() {

        Long cResults;
        try {

            Query query = em.createQuery("SELECT COUNT(*) FROM Empleado");
            cResults=(Long) query.getSingleResult();

            return cResults;
            
        } catch (Exception e) {

            return null;
        }

        
    }
    


}

