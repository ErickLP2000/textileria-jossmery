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

import com.proyecto2.demo.entidad.Proveedores;
import com.proyecto2.demo.service.IProveedoresService;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private IProveedoresService proveedoresService;

    @RequestMapping("/")
    public String inicio(Model model){
        Proveedores proveedores = new Proveedores();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("listaProveedores", proveedoresService.cargarProveedores());
        return "proveedores/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Proveedores proveedores, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaProveedores", proveedoresService.cargarProveedores());
            return "proveedores/inicio";
        }
        String rpta = proveedoresService.guardarProveedores(proveedores);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/proveedores/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = proveedoresService.eliminarProveedores(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/proveedores/";
    }
    
}
