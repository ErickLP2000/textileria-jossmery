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

import com.proyecto2.demo.entidad.Insumo;
import com.proyecto2.demo.service.ICategoriainsuService;
import com.proyecto2.demo.service.IInsumoService;
import com.proyecto2.demo.service.IMarcainsuService;
import com.proyecto2.demo.service.IProveedoresService;

@Controller
@RequestMapping("/insumo")
public class InsumoController {

    @Autowired
    private ICategoriainsuService categoriainsuService;

    @Autowired
    private IProveedoresService proveedoresService;

    @Autowired
    private IMarcainsuService marcainsuService;

    @Autowired
    private IInsumoService insumoService;

    @RequestMapping("/")
    public String inicio(Model model){
        Insumo insumo = new Insumo();
        model.addAttribute("insumo", insumo);
        model.addAttribute("listaCategoriainsu", categoriainsuService.cargarCategoriainsu());
        model.addAttribute("listaProveedores", proveedoresService.cargarProveedores());
        model.addAttribute("listaMarcainsu", marcainsuService.cargarMarcainsu());
        model.addAttribute("listaInsumo", insumoService.cargarInsumo());
        return "insumo/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Insumo insumo, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", categoriainsuService.cargarCategoriainsu());
            model.addAttribute("listaProveedores", proveedoresService.cargarProveedores());
            model.addAttribute("listaMarcainsu", marcainsuService.cargarMarcainsu());
            model.addAttribute("listaInsumo", insumoService.cargarInsumo());
            return "insumo/inicio";
        }
        String rpta = insumoService.guardarInsumo(insumo);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/insumo/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = insumoService.eliminarInsumo(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/insumo/";
    }
    
}
