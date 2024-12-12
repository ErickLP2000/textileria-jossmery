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

import com.proyecto2.demo.dto.MarcainsuDTO;
import com.proyecto2.demo.entidad.Marcainsu;
import com.proyecto2.demo.serviceImp.MarcainsuServiceImp;

@Controller
@RequestMapping("/marca")
public class MarcainsuController {
    
    @Autowired
    private MarcainsuServiceImp marcainsuService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        MarcainsuDTO marcainsuDTO = new MarcainsuDTO();
        model.addAttribute("marcainsu", marcainsuDTO);
        model.addAttribute("listaMarcainsu", marcainsuService.listar().stream().map(marcainsu -> modelMapper.map(marcainsu, MarcainsuDTO.class)).collect(Collectors.toList()));
        return "marca/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid MarcainsuDTO marcainsuDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaMarcainsu", marcainsuService.listar().stream().map(marcainsu -> modelMapper.map(marcainsu, MarcainsuDTO.class)).collect(Collectors.toList()));
            return "marca/inicio";
        }
        Marcainsu marcainsu = modelMapper.map(marcainsuDTO, Marcainsu.class);
        String rpta = marcainsuService.registrar(marcainsu);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/marca/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = marcainsuService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/marca/";
    }
}
