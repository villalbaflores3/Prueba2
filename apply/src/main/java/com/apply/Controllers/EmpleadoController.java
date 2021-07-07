package com.apply.Controllers;

import java.util.Map;

import com.apply.Models.Empleado;
import com.apply.Models.Dao.IEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/empleado", method = RequestMethod.GET)
public class EmpleadoController {
    
    @Autowired
    private IEmpleado empleadoDao;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String pageUsersAdmin(Model model) {        
        model.addAttribute("titulo", "Gestor de usuarios");
        model.addAttribute("contador", empleadoDao.count());
        model.addAttribute("empleados", empleadoDao.findAll());
        return "admin/user-list";
    }



    @RequestMapping(value = "/form")
    public String crearEmpleado(Map<String, Object> model) {
        Empleado empleado = new Empleado();
        model.put("titulo", "Nuevo empleado");
        model.put("empleado", empleado);
            return "admin/form";
    }

  /*  

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    
    public String guardar(Empleado empleado) {
        empleadoDao.save(empleado);
        return  "redirect:/show";
    }
*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String verEmpleado(@PathVariable(value = "id") Long id, Model model) {
        Empleado empleado = null;
        if (id > 0 ) {
            empleado = empleadoDao.findOne(id);
        }else{
            return "redirect:/";
        }

        model.addAttribute("empleado", empleado);
        model.addAttribute("titulo", "Detalles del  empleado");
        return "admin/user";
    
    }
    



}
