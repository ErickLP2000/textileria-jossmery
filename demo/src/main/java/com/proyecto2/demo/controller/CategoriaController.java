package com.proyecto2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyecto2.demo.entidad.Categoria;
import com.proyecto2.demo.service.ICategoriaService;


@Controller
@RequestMapping ("/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;
	@RequestMapping ("/")
	public String inicio(Model model) {
		Categoria objCategoria = new Categoria();
		model.addAttribute("categoria", objCategoria);
		model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
		return"categoria/inicio";
	}
	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String guardar(Categoria categoria) {
		categoriaService.guardarCategoria(categoria);
		return"redirect:/categoria/";
	}
	
	@RequestMapping("editar/{id}")
	public String editar(@PathVariable(value = "id")Long id, Model model ) {
		Categoria objCategoria = categoriaService.buscarCategoria(id);
		model.addAttribute("categoria", objCategoria);
		model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
		
		return "categoria/inicio";
	}
	
	@RequestMapping("eliminar/{id}")
	public String eliminar(@PathVariable(value = "id")Long id) {
		categoriaService.eliminarCategoria(id);
		return "redirect:/categoria/";
	}
}
