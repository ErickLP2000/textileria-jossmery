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

import com.proyecto2.demo.dto.ClienteDTO;
import com.proyecto2.demo.dto.EspservicioDTO;
import com.proyecto2.demo.dto.ServiciosDTO;
import com.proyecto2.demo.entidad.Servicios;
import com.proyecto2.demo.serviceImp.ClientesServiceImp;
import com.proyecto2.demo.serviceImp.EspservicioServiceImp;
import com.proyecto2.demo.serviceImp.ServiciosServiceImp;

@Controller
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private ClientesServiceImp clientesService;

    @Autowired
    private EspservicioServiceImp espservicioService;

    @Autowired
    private ServiciosServiceImp serviciosService;
    
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception{
        ServiciosDTO serviciosdDTO = new ServiciosDTO();
        model.addAttribute("servicios", serviciosdDTO);
        model.addAttribute("listaClientes", clientesService.listar().stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaEspservicio", espservicioService.listar().stream().map(espservicios -> modelMapper.map(espservicios, EspservicioDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaServicios", serviciosService.listar().stream().map(servicios -> modelMapper.map(servicios, ServiciosDTO.class)).collect(Collectors.toList()));
        return "servicios/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid ServiciosDTO serviciosDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception{
        if(result.hasErrors()){
            model.addAttribute("listaClientes", clientesService.listar().stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaEspservicio", espservicioService.listar().stream().map(espservicios -> modelMapper.map(espservicios, EspservicioDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaServicios", serviciosService.listar().stream().map(servicios -> modelMapper.map(servicios, ServiciosDTO.class)).collect(Collectors.toList()));
            return "servicios/inicio";
        }
        Servicios servicios = modelMapper.map(serviciosDTO, Servicios.class);
        String rpta = serviciosService.registrar(servicios);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/servicios/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception{
        String rpta = serviciosService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/servicios/";
    }
    
}
