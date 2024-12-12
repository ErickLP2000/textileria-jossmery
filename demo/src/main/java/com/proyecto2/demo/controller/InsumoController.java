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
import com.proyecto2.demo.dto.InsumoDTO;
import com.proyecto2.demo.dto.MarcainsuDTO;
import com.proyecto2.demo.dto.ProveedoresDTO;
import com.proyecto2.demo.entidad.Insumo;
import com.proyecto2.demo.serviceImp.CategoriainsuServiceImp;
import com.proyecto2.demo.serviceImp.InsumoServiceImp;
import com.proyecto2.demo.serviceImp.MarcainsuServiceImp;
import com.proyecto2.demo.serviceImp.ProveedoresServiceImp;

@Controller
@RequestMapping("/insumo")
public class InsumoController {

    @Autowired
    private CategoriainsuServiceImp categoriainsuService;

    @Autowired
    private ProveedoresServiceImp proveedoresService;

    @Autowired
    private MarcainsuServiceImp marcainsuService;

    @Autowired
    private InsumoServiceImp insumoService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        InsumoDTO insumoDTO = new InsumoDTO();
        model.addAttribute("insumo", insumoDTO);
        model.addAttribute("listaCategoriainsu", categoriainsuService.listar().stream().map(categoriainsu -> modelMapper.map(categoriainsu, CategoriainsuDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaProveedores", proveedoresService.listar().stream().map(proveedores -> modelMapper.map(proveedores, ProveedoresDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaMarcainsu", marcainsuService.listar().stream().map(marcainsu -> modelMapper.map(marcainsu, MarcainsuDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaInsumo", insumoService.listar().stream().map(insumo -> modelMapper.map(insumo, InsumoDTO.class)).collect(Collectors.toList()));
        return "insumo/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid InsumoDTO insumoDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaCategoriainsu", categoriainsuService.listar().stream().map(categoriainsu -> modelMapper.map(categoriainsu, CategoriainsuDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaProveedores", proveedoresService.listar().stream().map(proveedores -> modelMapper.map(proveedores, ProveedoresDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaMarcainsu", marcainsuService.listar().stream().map(marcainsu -> modelMapper.map(marcainsu, MarcainsuDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaInsumo", insumoService.listar().stream().map(insumo -> modelMapper.map(insumo, InsumoDTO.class)).collect(Collectors.toList()));
            return "insumo/inicio";
        }
        Insumo insumo = modelMapper.map(insumoDTO, Insumo.class);
        String rpta = insumoService.registrar(insumo);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/insumo/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = insumoService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/insumo/";
    }
    
}
