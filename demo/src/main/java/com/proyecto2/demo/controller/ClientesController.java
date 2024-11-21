package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto2.demo.entidad.Clientes;
import com.proyecto2.demo.service.IClienteService;

@Controller
@RequestMapping("/registro")
public class ClientesController {

		
	@Autowired
	private IClienteService clienteService;
	@RequestMapping ("/")
	public String inicio(Model model) {
		Clientes objCliente = new Clientes();
		model.addAttribute("cliente", objCliente);
		model.addAttribute("listacliente", clienteService.cargarclientes());
		return"vista/register";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(Clientes cliente) {
		clienteService.guardarcliente(cliente);
		return"redirect:/registro/";
	}
}
