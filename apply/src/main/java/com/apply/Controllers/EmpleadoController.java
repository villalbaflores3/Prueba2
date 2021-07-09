package com.apply.Controllers;

import java.util.Map;

import javax.validation.Valid;

import com.apply.Models.Empleado;
import com.apply.Models.Dao.IEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;



@Controller
@SessionAttributes("empleado")
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
        model.put("empleado", empleado);
        model.put("titulo", "Nuevo empleado");
        return "admin/form";
    }

    @RequestMapping(value = "/form/{id}")


    public String edit(@PathVariable(value = "id") Long id, Map <String, Object> model) {
        
        Empleado empleado = null;
        
        if (id > 0) {
            
            empleado = empleadoDao.findOne(id);
                        
        }else{

            return "redirect:/show";
        }

        model.put("empleado", empleado);
        model.put("titulo", "Editar Empleado");
        return "admin/form";
    }





    @PostMapping(value = "/form/save")   
    public String save(@Valid Empleado empleado, BindingResult result, Model model, SessionStatus status) {
        
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario");
            return "admin/form";
        }
        
        empleadoDao.save(empleado);
        status.setComplete();
        return  "redirect:/empleado/show";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable (value = "id") Long id){

        if (id > 0 ) {
            
            empleadoDao.delete(id);
        }

        return "redirect:/empleado/show";

    }

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
