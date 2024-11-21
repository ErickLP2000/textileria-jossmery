package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Categoria;

public interface ICategoriaService {

	public void guardarCategoria(Categoria categoria);
	public List<Categoria> cargarCategorias();
	public Categoria buscarCategoria(Long id);
	public void eliminarCategoria(Long id);
	
}
