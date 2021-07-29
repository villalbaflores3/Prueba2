package com.apply.Models.Dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.apply.Models.Asignacion;
import com.apply.Models.Empleado;
import com.apply.Models.Equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class EmpleadoImpl implements IEmpleado {

    @Autowired
    IAsignacion asignacionDao;
    
    @Autowired
    IEquipo equipoDao;


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



    @Override
    @Transactional()
    public void save(Empleado empleado) {

        if (empleado.getId() != null  && empleado.getId() > 0) {
                em.merge(empleado);
        }else{

            em.persist(empleado);
        
        }


    }

    @Override
    public Empleado findOne(Long id) {
    
    return    em.find(Empleado.class, id);
        
    }



    @Override
    @Transactional
    public void delete(Long id) {
      Empleado empleado = findOne(id);
      em.remove(empleado); 
    }



  

    
    @Override
    @Transactional
    public void saveAsignacion(Asignacion asignacion) {
    
        asignacionDao.save(asignacion);
    }



    @Override
    @Transactional (readOnly = true)
    public Equipo findEquipoById(Long id) {
    
        return equipoDao.findById(id).orElse(null);
    }



    @Override
    public void saveEquipo(Long idEquipo, Long id) {

    }



    @Override
    public Empleado findByCorreo(String correo) {
    
        Query query = em.createQuery("SELECT e from Empleado e WHERE c.correo = ?1", Empleado.class);
        String email = correo;
        Empleado empl = (Empleado) query.setParameter(1, email).getSingleResult();
        return empl;

    }



    @Override
    
    public Empleado findByNombre(String nombre) {
        Query query = em.createQuery("SELECT e from Empleado e WHERE c.nombre = ?1", Empleado.class);
        String name = nombre;
        Empleado empl = (Empleado) query.setParameter(1, name).getSingleResult();
        return empl;
    }











}

