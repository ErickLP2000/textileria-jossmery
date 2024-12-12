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

import com.proyecto2.demo.dto.EspservicioDTO;
import com.proyecto2.demo.entidad.Espservicio;
import com.proyecto2.demo.serviceImp.EspservicioServiceImp;

@Controller
@RequestMapping("espservicio")
public class EspservicioController {

    @Autowired
    private EspservicioServiceImp espservicioService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        EspservicioDTO espservicioDTO = new EspservicioDTO();
        model.addAttribute("espservicio", espservicioDTO);
        model.addAttribute("listaEspservicio", espservicioService.listar().stream().map(espservicio -> modelMapper.map(espservicio, EspservicioDTO.class)).collect(Collectors.toList()));
        return "espservicio/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid EspservicioDTO espservicioDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaEspservicio", espservicioService.listar().stream().map(espservicio -> modelMapper.map(espservicio, EspservicioDTO.class)).collect(Collectors.toList()));
            return "espservicio/inicio";
        }
        Espservicio espservicio = modelMapper.map(espservicioDTO, Espservicio.class);
        String rpta = espservicioService.registrar(espservicio);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/espservicio/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = espservicioService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/espservicio/";
    }
    
}
