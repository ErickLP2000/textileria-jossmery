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

import com.proyecto2.demo.entidad.Productos;
import com.proyecto2.demo.service.ICatproductoService;
import com.proyecto2.demo.service.IProductosService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ICatproductoService catproductoService;

    @Autowired
    private IProductosService productosService;

    @RequestMapping("/")
    public String inicio(Model model){
        Productos productos = new Productos();
        model.addAttribute("productos", productos);
        model.addAttribute("listaCatproducto", catproductoService.cargarCatproducto());
        model.addAttribute("listaProductos", productosService.cargarProductos());
        return "productos/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Productos productos, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", catproductoService.cargarCatproducto());
            model.addAttribute("listaProveedores", productosService.cargarProductos());
            return "productos/inicio";
        }
        String rpta = productosService.guardarProductos(productos);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/productos/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = productosService.eliminarProductos(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/productos/";
    }
    
}
