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

import com.proyecto2.demo.entidad.Cliente;
import com.proyecto2.demo.service.IClientesService;
import com.proyecto2.demo.service.IDistritoService;
import com.proyecto2.demo.service.IDocumentoService;
import com.proyecto2.demo.service.ITipoclienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private IDocumentoService documentoService;

    @Autowired
    private ITipoclienteService tipoclienteService;

    @Autowired
    private IDistritoService distritoService;

    @Autowired
    private IClientesService clientesService;

    @RequestMapping("/")
    public String inicio(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaDocumento", documentoService.cargarDocumento());
        model.addAttribute("listaTipocliente", tipoclienteService.cargarTipocliente());
        model.addAttribute("listaDistrito", distritoService.cargarDistrito());
        model.addAttribute("listaCliente", clientesService.cargarCliente());
        return "cliente/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash) {
        if(result.hasErrors()){
            model.addAttribute("listaDocumento", documentoService.cargarDocumento());
            model.addAttribute("listaTipocliente", tipoclienteService.cargarTipocliente());
            model.addAttribute("listaDistrito", distritoService.cargarDistrito());
            model.addAttribute("listaProductos", clientesService.cargarCliente());
            return "cliente/inicio";
        }
        String rpta = clientesService.guardarCliente(cliente);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/cliente/";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        String rpta = clientesService.eliminarCliente(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/cliente/";
    }

    
}
