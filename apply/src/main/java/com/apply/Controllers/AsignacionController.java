package com.apply.Controllers;

import java.util.Map;

import com.apply.Models.Empleado;
import com.apply.Models.Equipo;
import com.apply.Models.Dao.IEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("asignacion")
@RequestMapping( value = "/asignacion")
@Controller
public class AsignacionController {
    
    
    @Autowired
    private IEmpleado empleadoDao;

    
    @GetMapping("/{empleadoId}")
    public String crear(@PathVariable(value = "empleadoId") Long empleadoId, Map<String, Object> model, RedirectAttributes flash){

        Empleado  empleado = empleadoDao.findOne(empleadoId);
        
        if (empleado  == null) {
            flash.addFlashAttribute("error", "Empleado no existe");
            return "empleados/show";    
        }

        Equipo equipo =  new Equipo();
        equipo.setEmpleado(empleado);
        model.put("equipo", equipo);
        model.put("titulo", "Nueva asignación");

        return "admin/user-asignacion";

    }
}
