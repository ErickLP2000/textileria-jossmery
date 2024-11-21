package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Inventario;

public interface IInventarioService {

	public void guardarInventario(Inventario inventario);
	public List<Inventario> cargarInventarios();
	public Inventario buscarInventario(Long id);
	public void eliminarInventario(Long id);
	
}
