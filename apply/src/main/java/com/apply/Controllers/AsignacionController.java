package com.apply.Controllers;

import java.util.Map;

import javax.transaction.Transactional;

import com.apply.Models.Asignacion;
import com.apply.Models.Empleado;
import com.apply.Models.Equipo;
import com.apply.Models.Dao.IAsignacion;
import com.apply.Models.Dao.IEmpleado;
import com.apply.Models.Dao.IEquipo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;





@SessionAttributes("asignacion")
@RequestMapping( value = "/asignacion")
@Controller
public class AsignacionController {
    
    
    @Autowired
    private IEmpleado empleadoDao;

    @Autowired
    private IEquipo equipoDao;

    @Autowired
    private IAsignacion asignacion;
    @Autowired
    private IAsignacion asignacion2 ;
            



    private final Logger log  = LoggerFactory.getLogger(getClass());
    


    
    @Transactional
    @GetMapping("/{empleadoId}")
    public String crear(@PathVariable(value = "empleadoId") Long id, Map<String, Object> model, RedirectAttributes flash){

        Empleado  empleado = empleadoDao.findOne(id);
        
        if (empleado  == null) {
            flash.addFlashAttribute("error", "Empleado no existe");
            return "empleados/show";    
        }

        Asignacion asignacion = new Asignacion(); 
        asignacion.setEmpleado(empleado);
        model.put("equipos", equipoDao.findAllByEquipado());
        model.put("asignacion", asignacion);
        model.put("titulo", "Nueva asignación");
        return "admin/user-asignacion";

    }






    @PostMapping(value="/save")
    public String guardar(Empleado empleado, Equipo equipo,
        @RequestParam(name = "equipoId", required = false)int equipoId,
        @RequestParam(name = "idEmpleado", required = false)int idEmpleado,
        @RequestParam(name = "descripcion", required = false)String descripcion,
        RedirectAttributes flash,  SessionStatus status) {        

        
        asignacion2.crearNuevo(descripcion, idEmpleado, equipoId);
        asignacion2.ocuparEmpleado(idEmpleado);
        asignacion2.ocuparEquipo(idEmpleado);
        asignacion2.asignarEquipo(idEmpleado, equipoId);



        return "redirect:/admin";
    }

    


}
