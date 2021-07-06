package com.apply.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {



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
        return "admin/dashboard";
    }


}