package com.apply.Controllers;

import com.apply.Models.Dao.IEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {


    @Autowired
    private IEmpleado empleado;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String pageIndex(Model model) {
        model.addAttribute("titulo", "Inicio de sesion");
        return "index-user";
    }

    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String pageHomeUser(Model model) {
        model.addAttribute("titulo", "Home");
        return "user-dashboard";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String pageHomeAdmin(Model model) {
        model.addAttribute("titulo", "Admin");
        return "admin-dashboard";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String pageUsersAdmin(Model model) {        
        model.addAttribute("titulo", "Gestor de usuarios");
        model.addAttribute("contador", empleado.count());
        model.addAttribute("empleados", empleado.findAll());
        return "admin-user-list";
    }
}