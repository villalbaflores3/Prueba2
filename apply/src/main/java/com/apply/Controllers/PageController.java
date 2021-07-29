package com.apply.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.apply.Models.Empleado;
import com.apply.Models.Factura;
import com.apply.Models.Dao.IEmpleado;
import com.apply.Models.Dao.IFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {

    @Autowired
    IFactura facturaDao;

    @RequestMapping(value = "/proveedores", method = RequestMethod.GET)
    public String pageProveedores(Model model) {
        
        Factura factura = new Factura();
        model.addAttribute("titulo", "Factura para proveedores");
        model.addAttribute("factura", factura);
        return "proveedores";
    }



    @RequestMapping(value = "/proveedores/folio", method = RequestMethod.GET)
    public String buscarProveedor(@RequestParam String folio,  Model model, @ModelAttribute("factura") Factura factura) {
        model.addAttribute("titulo", "Resultado de busqueda");
        model.addAttribute("facturas", facturaDao.findByFolio(folio));
        return "proveedores";
    }

        




    @RequestMapping(value = "/proveedores/folio/save/{folio}", method = RequestMethod.POST)
    public String saveFactura(Factura factura, Model model,  
    @RequestParam("file") MultipartFile xml,
    @PathVariable(value = "folio") String folio,
    RedirectAttributes flash) {
        
        if (!xml.isEmpty()) {
             

            String rootPath = "C://Temp//upload";
            
            try {                

                byte[] bytes = xml.getBytes();
                Path rutaCompleta = Paths.get( rootPath + "//"+ xml.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                
                facturaDao.CerrarFactura(xml.getOriginalFilename(), true, folio);

                model.addAttribute("titulo", "Cargar archivo");
                flash.addFlashAttribute("info", "Cargado exitosamente");
        
                return "redirect:/proveedores";
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        
        
        return "redirect:/proveedores";
    }









    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("permitAll()")
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