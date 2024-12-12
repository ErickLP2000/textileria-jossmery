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

import com.proyecto2.demo.dto.CategoriainsuDTO;
import com.proyecto2.demo.entidad.Categoriainsu;
import com.proyecto2.demo.serviceImp.CategoriainsuServiceImp;

@Controller
@RequestMapping("/catinsumo")
public class CategoriainsuController {

    @Autowired
    private CategoriainsuServiceImp categoriainsuService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        CategoriainsuDTO categoriainsuDTO = new CategoriainsuDTO();
        model.addAttribute("categoriainsu", categoriainsuDTO);
        model.addAttribute("listaCategoriainsu", categoriainsuService.listar().stream() .map(categoriainsu -> modelMapper.map(categoriainsu, CategoriainsuDTO.class)) .collect(Collectors.toList()));
        return "catinsumo/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid CategoriainsuDTO categoriainsuDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", categoriainsuService.listar().stream() .map(categoriainsu -> modelMapper.map(categoriainsu, CategoriainsuDTO.class)) .collect(Collectors.toList()));
            return "catinsumo/inicio";
        }
        Categoriainsu categoriainsu = modelMapper.map(categoriainsuDTO, Categoriainsu.class);
        String rpta = categoriainsuService.registrar(categoriainsu); flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catinsumo/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = categoriainsuService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catinsumo/";
    }
    
}
