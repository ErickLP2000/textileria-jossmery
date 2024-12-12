package com.proyecto2.demo.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto2.demo.dto.CatproductoDTO;
import com.proyecto2.demo.dto.ProductosDTO;
import com.proyecto2.demo.entidad.Productos;
import com.proyecto2.demo.serviceImp.CatproductoServiceImp;
import com.proyecto2.demo.serviceImp.ProductosServiceImp;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private CatproductoServiceImp catproductoService;

    @Autowired
    private ProductosServiceImp productosService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        ProductosDTO productosDTO = new ProductosDTO();
        model.addAttribute("productos", productosDTO);
        model.addAttribute("listaCatproducto", catproductoService.listar().stream().map(catproducto -> modelMapper.map(catproducto, CatproductoDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaProductos", productosService.listar().stream().map(productos -> modelMapper.map(productos, ProductosDTO.class)).collect(Collectors.toList()));
        return "productos/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid ProductosDTO productosDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", catproductoService.listar().stream().map(catproducto -> modelMapper.map(catproducto, CatproductoDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaProveedores", productosService.listar().stream().map(productos -> modelMapper.map(productos, ProductosDTO.class)).collect(Collectors.toList()));
            return "productos/inicio";
        }
        Productos productos = modelMapper.map(productosDTO, Productos.class);
        String rpta = productosService.registrar(productos);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/productos/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = productosService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/productos/";
    }
    
}
