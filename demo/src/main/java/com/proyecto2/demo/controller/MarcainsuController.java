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

import com.proyecto2.demo.entidad.Marcainsu;
import com.proyecto2.demo.service.IMarcainsuService;

@Controller
@RequestMapping("/marca")
public class MarcainsuController {
    
    @Autowired
    private IMarcainsuService marcainsuService;

    @RequestMapping("/")
    public String inicio(Model model){
        Marcainsu marcainsu = new Marcainsu();
        model.addAttribute("marcainsu", marcainsu);
        model.addAttribute("listaMarcainsu", marcainsuService.cargarMarcainsu());
        return "marca/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Marcainsu marcainsu, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaMarcainsu", marcainsuService.cargarMarcainsu());
            return "marca/inicio";
        }
        String rpta = marcainsuService.guardarMarcainsu(marcainsu);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/marca/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = marcainsuService.eliminarMarcainsu(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/marca/";
    }
}
