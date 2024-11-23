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

import com.proyecto2.demo.entidad.Catproducto;
import com.proyecto2.demo.service.ICatproductoService;

@Controller
@RequestMapping("catproducto")
public class CatproductoController {

    @Autowired
    private ICatproductoService catproductoService;

    @RequestMapping("/")
    public String inicio(Model model){
        Catproducto catproducto = new Catproducto();
        model.addAttribute("catproducto", catproducto);
        model.addAttribute("listaCatproducto", catproductoService.cargarCatproducto());
        return "catproducto/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Catproducto catproducto, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", catproductoService.cargarCatproducto());
            return "catproducto/inicio";
        }
        String rpta = catproductoService.guardarCatproducto(catproducto);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catproducto/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = catproductoService.eliminarCatproducto(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catproducto/";
    }
    
}
