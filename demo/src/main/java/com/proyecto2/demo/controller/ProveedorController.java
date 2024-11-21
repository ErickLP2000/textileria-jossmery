package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto2.demo.entidad.Proveedor;
import com.proyecto2.demo.service.IProveedorService;


@Controller
@RequestMapping ("/proveedor")
public class ProveedorController {

	@Autowired
	private IProveedorService proveedorService;
	@RequestMapping ("/")
	public String inicio(Model model) {
		Proveedor objProveedor = new Proveedor();
		model.addAttribute("proveedor", objProveedor);
		model.addAttribute("listaProveedores", proveedorService.cargarProveedores());
		return"proveedor/inicio";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(Proveedor proveedor) {
		proveedorService.guardarProveedor(proveedor);
		return"redirect:/proveedor/";
	}
	
	@RequestMapping("editar/{id}")
	public String editar(@PathVariable(value = "id")Long id, Model model ) {
		Proveedor objProveedor = proveedorService.buscarProveedor(id);
		model.addAttribute("proveedor", objProveedor);
		model.addAttribute("listaProveedores", proveedorService.cargarProveedores());
		
		return "proveedor/inicio";
	}
	
	@RequestMapping("eliminar/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		proveedorService.eliminarProveedor(id);
		return "redirect:/proveedor/";
	}
}
