package com.example.demo.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import com.example.demo.entity.Curso;
import com.example.demo.service.CursoService;

@Controller
public class CursoController {

	   
	@Autowired
	private CursoService cursoService;


	@GetMapping(value = "/index")
	    public String listar(Model model){
	    model.addAttribute("titulo", "Titulo de prueba");
	    model.addAttribute("cursos", cursoService.findAll());
	    return "index";
	    }


	@GetMapping(value= "form")
	    public String crear(Map<String, Object> model){
	    
	    Curso curso = new Curso();

	    model.put("curso", curso);
	    model.put("titulo", "Curso de formulario");
	    return "form";
	    }


	@GetMapping(value = "/form/{id}")
	    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model){
	    
	    Curso curso = null;
	    
	    if (id > 0) {
	        curso = cursoService.findOne(id);        
	        
	    }else{

	        return "redirect:/index";
	    }

	    model.put("titulo", "Editar Curso");
	    model.put("curso", curso);
	    return "form";

	    }


	@PostMapping(value = "/form")
	public String guardar (@Valid Curso curso, BindingResult result, Model model, SessionStatus status){

	    System.out.println(curso);

	    if (result.hasErrors()) {
	        
	        model.addAttribute("titulo", "Formulario");
	        return "form";
	    }

	    cursoService.save(curso);
	    status.setComplete();
	    return "redirect:/index";
	}

	@GetMapping(value = "/eliminar/{id}")
	public String eliminar (@PathVariable(value = "id") Long id){

	    if (id > 0) {
	        cursoService.eliminar(id);
	    }
	    return "redirect:/index";
	    }
	
	
}
