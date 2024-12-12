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
import com.proyecto2.demo.entidad.Catproducto;
import com.proyecto2.demo.serviceImp.CatproductoServiceImp;

@Controller
@RequestMapping("catproducto")
public class CatproductoController {

    @Autowired
    private CatproductoServiceImp catproductoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        CatproductoDTO catproductoDTO = new CatproductoDTO();
        model.addAttribute("catproducto", catproductoDTO);
        model.addAttribute("listaCatproducto", catproductoService.listar().stream() .map(catproducto -> modelMapper.map(catproducto, CatproductoDTO.class)) .collect(Collectors.toList()));
        return "catproducto/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid CatproductoDTO catproductoDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaCatproducto", catproductoService.listar().stream() .map(catproducto -> modelMapper.map(catproducto, CatproductoDTO.class)) .collect(Collectors.toList()));
            return "catproducto/inicio";
        }
        Catproducto catproducto = modelMapper.map(catproductoDTO, Catproducto.class);
        String rpta = catproductoService.registrar(catproducto); 
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catproducto/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = catproductoService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/catproducto/";
    }
    
}
