package com.apply.Controllers;

import com.apply.Models.Factura;
import com.apply.Models.Dao.IFactura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/admin/proveedores", method = RequestMethod.GET)
public class ProveedorController {

    @Autowired
    IFactura facturaDao;



    @RequestMapping(value = "/inicio", method = RequestMethod.GET)
    public String pageProveedores(Model model) {
        
        Factura factura = new Factura(); 
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Factura para proveedores");
        return "admin/proveedor";
    }


    @RequestMapping(value = "/listado", method = RequestMethod.GET)
    public String listar(Model model) {

        model.addAttribute("facturas",facturaDao.findAll());
        model.addAttribute("titulo", "Listado");
        return "admin/proveedor-list";
    }


    @RequestMapping(value = "/inicio/save", method = RequestMethod.POST)
    public String guardar(Factura factura,  RedirectAttributes flash){
        

        String orden = factura.getOrdenCompra();
        int cantidad = factura.getCantidad();
        float precio = factura.getPrecio();
        float total = cantidad * precio;
        factura.setTotal(total);
        factura.setStatus(false);
        flash.addFlashAttribute("error", "Orden de compra: " + orden);
        facturaDao.save(factura);
        return "redirect:/admin/proveedores/inicio";

    }



    @RequestMapping(value = "/proveedor", method = RequestMethod.GET )
    public String busqueda(String oCompra){
      return "proveedor";  
    }



}
