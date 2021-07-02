package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CursoDao;
import com.example.demo.entity.Curso;


@Service
public class CursoServiceImpl  implements CursoService{

		@Autowired
		CursoDao cursoDao;
	
	 	@Override
	    @Transactional(readOnly = true)
	    public List<Curso> findAll() {
	        return (List<Curso>) cursoDao.findAll();
	    }

	    @Override
	    public void save(Curso curso) {
	        
	        cursoDao.save(curso);
	    }

	    @Override
	    @Transactional(readOnly = true)
	    public Curso findOne(Long id) {

	        return cursoDao.findById(id).orElse(null);
	    }

	    @Override
	    public void eliminar(Long id) {
	                
	    	cursoDao.deleteById(id);
	    }

	
}
