package com.apply.Controllers;

import com.apply.Models.Empleado;
import com.apply.Models.Dao.IEmpleado;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    


    @RequestMapping(value = "/proveedores", method = RequestMethod.GET)
    public String pageProveedores(Model model) {
        model.addAttribute("titulo", "Factura para proveedores");
        return "proveedores";
    }


    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String pageHomeUser(Model model) {
        model.addAttribute("titulo", "Home");
        return "user-dashboard";
    }




    

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String pageHomeAdmin(Model model) {

        model.addAttribute("titulo", "Admin");
        return "admin/dashboard";
    }


}