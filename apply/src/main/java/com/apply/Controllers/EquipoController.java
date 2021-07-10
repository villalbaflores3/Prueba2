package com.apply.Controllers;

import java.util.Map;

import javax.validation.Valid;

import com.apply.Models.Equipo;
import com.apply.Services.EquipoServiceImpl;
import com.apply.Services.IEquipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("equipo")
public class EquipoController {

       
    @Autowired
    private IEquipoService equipoService;



    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String pageUsersAdmin(Model model) {        
        model.addAttribute("titulo", "Gestor de equipos");
        model.addAttribute("contador", equipoService.count());
        model.addAttribute("equipos", equipoService.findAll());
        return "admin/equipo-list";
    }



    @RequestMapping(value = "/form")
    public String crearEquipo(Map<String, Object> model) {
        Equipo equipo= new Equipo();
        model.put("equipo", equipo);
        model.put("titulo", "Nuevo equipo");
        return "admin/formEquipo";
    }

    @RequestMapping(value = "/form/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map <String, Object> model) {
        
        Equipo equipo = null;
        
        if (id > 0) {
            
            equipo = equipoService.findOne(id);
                        
        }else{

            return "redirect:/show";
        }

        model.put("equipo", equipo);
        model.put("titulo", "Editar Equipo");
        return "admin/formEquipo";
    }





    @PostMapping(value = "/form/save")   
    public String save(@Valid Equipo equipo, BindingResult result, Model model, SessionStatus status) {
        
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario");
            return "admin/formEquipo";
        }
        
        equipoService.save(equipo);
        status.setComplete();
        return  "redirect:/equipo/show";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable (value = "id") Long id){

        if (id > 0 ) {
            
            equipoService.delete(id);
        }

        return "redirect:/equipo/show";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String ver(@PathVariable(value = "id") Long id, Model model) {
        Equipo equipo = null;
        if (id > 0 ) {
            equipo = equipoService.findOne(id);
        }else{
            return "redirect:/";
        }

        model.addAttribute("equipo", equipo);
        model.addAttribute("titulo", "Detalles del  equipo");
        return "admin/equipo";
    
    }
    



}
