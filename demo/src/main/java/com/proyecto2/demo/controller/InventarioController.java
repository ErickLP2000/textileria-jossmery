package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto2.demo.entidad.Inventario;
import com.proyecto2.demo.service.IInventarioService;


@Controller
@RequestMapping ("/inventario")
public class InventarioController {

	@Autowired
	private IInventarioService inventarioService;
	@RequestMapping ("/")
	public String inicio(Model model) {
		Inventario objInventario = new Inventario();
		model.addAttribute("inventario", objInventario);
		model.addAttribute("listaInventarios", inventarioService.cargarInventarios());
		return"inventario/inicio";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(Inventario inventario) {
		inventarioService.guardarInventario(inventario);
		return"redirect:/inventario/";
	}
	
	@RequestMapping("editar/{id}")
	public String editar(@PathVariable(value = "id")Long id, Model model ) {
		Inventario objInventario = inventarioService.buscarInventario(id);
		model.addAttribute("inventario", objInventario);
		model.addAttribute("listaInventarios", inventarioService.cargarInventarios());
		
		return "inventario/inicio";
	}
	
	@RequestMapping("eliminar/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		inventarioService.eliminarInventario(id);
		return "redirect:/inventario/";
	}
}
