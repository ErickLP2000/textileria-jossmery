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

import com.proyecto2.demo.dto.ProveedoresDTO;
import com.proyecto2.demo.entidad.Proveedores;
import com.proyecto2.demo.serviceImp.ProveedoresServiceImp;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresServiceImp proveedoresService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        ProveedoresDTO proveedoresDTO = new ProveedoresDTO();
        model.addAttribute("proveedores", proveedoresDTO);
        model.addAttribute("listaProveedores", proveedoresService.listar().stream().map(proveedores -> modelMapper.map(proveedores, ProveedoresDTO.class)).collect(Collectors.toList()));
        return "proveedores/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid ProveedoresDTO proveedoresDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaProveedores", proveedoresService.listar().stream().map(proveedores -> modelMapper.map(proveedores, ProveedoresDTO.class)).collect(Collectors.toList()));
            return "proveedores/inicio";
        }
        Proveedores proveedores = modelMapper.map(proveedoresDTO, Proveedores.class);
        String rpta = proveedoresService.registrar(proveedores);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/proveedores/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = proveedoresService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/proveedores/";
    }
    
}
