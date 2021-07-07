package com.apply.Controllers;

import com.apply.Models.Equipo;
import com.apply.Models.Dao.IEquipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("equipo")
public class EquipoController {

    
    @Autowired
    private IEquipo equipoDao;

    @RequestMapping(value = "/{idEquipo}", method = RequestMethod.GET)
    public String verEmpleado(@PathVariable(value = "idEquipo") Long id, Model model) {
        Equipo equipo = null
        ;
        if (id > 0 ) {
          //  equipo = equipoDao.findById(id);
        }else{
            return "redirect:/";
        }

        model.addAttribute("empleado", equipo);
        model.addAttribute("titulo", "Detalles del  empleado");
        return "admin/user";
    
    }



}
