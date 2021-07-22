package com.apply.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/proveedores", method = RequestMethod.GET)
public class ProveedorController {
    

    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String pageProveedores(Model model) {
        model.addAttribute("titulo", "Factura para proveedores");
        return "admin/proveedores";
    }

}
