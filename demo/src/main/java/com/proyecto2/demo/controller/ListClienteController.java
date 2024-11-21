package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto2.demo.service.IClienteService;

@Controller
@RequestMapping("/listacliente")
public class ListClienteController {

	@Autowired
	private IClienteService clienteService;
	@RequestMapping ("/")
	public String inicio(Model model) {
		
		model.addAttribute("listacliente", clienteService.cargarclientes());
		return"clientes/inicio";
	}
}
