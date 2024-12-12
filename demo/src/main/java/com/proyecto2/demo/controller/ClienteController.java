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
import com.proyecto2.demo.dto.DistritoDTO;
import com.proyecto2.demo.dto.DocumentoDTO;
import com.proyecto2.demo.dto.TipoclienteDTO;
import com.proyecto2.demo.entidad.Cliente;
import com.proyecto2.demo.serviceImp.ClientesServiceImp;
import com.proyecto2.demo.serviceImp.DistritoServiceImp;
import com.proyecto2.demo.serviceImp.DocumentoServiceImp;
import com.proyecto2.demo.serviceImp.TipoclienteServiceImp;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private DocumentoServiceImp documentoService;

    @Autowired
    private TipoclienteServiceImp tipoclienteService;

    @Autowired
    private DistritoServiceImp distritoService;

    @Autowired
    private ClientesServiceImp clientesService;
    
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/")
    public String inicio(Model model) throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO();
        model.addAttribute("cliente", clienteDTO);
        model.addAttribute("listaDocumento", documentoService.listar().stream()
                .map(doc -> modelMapper.map(doc, DocumentoDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaTipocliente", tipoclienteService.listar().stream()
                .map(tipocliente -> modelMapper.map(tipocliente, TipoclienteDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaDistrito", distritoService.listar().stream()
                .map(distrito -> modelMapper.map(distrito, DistritoDTO.class)).collect(Collectors.toList()));
        model.addAttribute("listaCliente", clientesService.listar().stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList()));
        return "cliente/inicio";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid ClienteDTO clienteDTO, BindingResult result, Model model, RedirectAttributes flash) throws Exception {
        if (result.hasErrors()) {
            model.addAttribute("listaDocumento", documentoService.listar().stream()
                    .map(doc -> modelMapper.map(doc, DocumentoDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaTipocliente", tipoclienteService.listar().stream()
                    .map(tipocliente -> modelMapper.map(tipocliente, TipoclienteDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaDistrito", distritoService.listar().stream()
                    .map(distrito -> modelMapper.map(distrito, DistritoDTO.class)).collect(Collectors.toList()));
            model.addAttribute("listaCliente", clientesService.listar().stream()
                    .map(cliente -> modelMapper.map(cliente, ClienteDTO.class)).collect(Collectors.toList()));
            return "cliente/inicio";
        }
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        String rpta = clientesService.registrar(cliente);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/cliente/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) throws Exception {
        String rpta = clientesService.eliminar(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/cliente/";
    }
}

