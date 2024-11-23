package com.proyecto2.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto2.demo.entidad.Servicios;
import com.proyecto2.demo.service.IClientesService;
import com.proyecto2.demo.service.IEspservicioService;
import com.proyecto2.demo.service.IServiciosService;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private IClientesService clientesService;

    @Autowired
    private IEspservicioService espservicioService;

    @Autowired
    private IServiciosService serviciosService;

    @RequestMapping("/")
    public String inicio(Model model){
        Servicios servicios = new Servicios();
        model.addAttribute("servicios", servicios);
        model.addAttribute("listaClientes", clientesService.cargarCliente());
        model.addAttribute("listaEspservicio", espservicioService.cargarEspservicio());
        model.addAttribute("listaServicios", serviciosService.cargarServicios());
        return "servicios/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Servicios servicios, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaClientes", clientesService.cargarCliente());
            model.addAttribute("listaEspservicio", espservicioService.cargarEspservicio());
            model.addAttribute("listaServicios", serviciosService.cargarServicios());
            return "servicios/inicio";
        }
        String rpta = serviciosService.guardarServicios(servicios);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/servicios/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = serviciosService.eliminarServicios(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/servicios/";
    }
    
}
