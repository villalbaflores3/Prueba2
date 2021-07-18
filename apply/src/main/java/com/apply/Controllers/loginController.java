package com.apply.Controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class loginController {
    


    @GetMapping(value = {"/login", "/"})
    public String login(@RequestParam(value = "error", required = false) String error, Model model, Principal principal, RedirectAttributes flash){

        
        if (principal != null) {            
            flash.addFlashAttribute("info", "Sesion ya iniciado");
            return "redirect:/user";
        }   
        if (error != null) {
            
            model.addAttribute("error", "Error en el login");
        }
     
        model.addAttribute("titulo", "Login");
        return "index-user";

    }


}
