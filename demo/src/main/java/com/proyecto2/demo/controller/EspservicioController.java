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

import com.proyecto2.demo.entidad.Espservicio;
import com.proyecto2.demo.service.IEspservicioService;

@Controller
@RequestMapping("espservicio")
public class EspservicioController {

    @Autowired
    private IEspservicioService espservicioService;

    @RequestMapping("/")
    public String inicio(Model model){
        Espservicio espservicio = new Espservicio();
        model.addAttribute("espservicio", espservicio);
        model.addAttribute("listaEspservicio", espservicioService.cargarEspservicio());
        return "espservicio/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Espservicio espservicio, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaEspservicio", espservicioService.cargarEspservicio());
            return "espservicio/inicio";
        }
        String rpta = espservicioService.guardarEspservicio(espservicio);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/espservicio/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = espservicioService.eliminarEspservicio(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/espservicio/";
    }
    
}
