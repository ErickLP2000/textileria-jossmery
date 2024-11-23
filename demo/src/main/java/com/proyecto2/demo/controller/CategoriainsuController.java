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

import com.proyecto2.demo.entidad.Categoriainsu;
import com.proyecto2.demo.service.ICategoriainsuService;

@Controller
@RequestMapping("/catinsumo")
public class CategoriainsuController {

    @Autowired
    private ICategoriainsuService categoriainsuService;

    @RequestMapping("/")
    public String inicio(Model model){
        Categoriainsu categoriainsu = new Categoriainsu();
        model.addAttribute("categoriainsu", categoriainsu);
        model.addAttribute("listaCategoriainsu", categoriainsuService.cargarCategoriainsu());
        return "catinsumo/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Categoriainsu categoriainsu, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", categoriainsuService.cargarCategoriainsu());
            return "catinsumo/inicio";
        }
        String rpta = categoriainsuService.guardarCategoriainsu(categoriainsu);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catinsumo/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = categoriainsuService.eliminarCategoriainsu(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catinsumo/";
    }
    
}
