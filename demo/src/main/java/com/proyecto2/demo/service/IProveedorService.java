package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Proveedor;

public interface IProveedorService {

	public void guardarProveedor(Proveedor proveedor);
	public List<Proveedor> cargarProveedores();
	public Proveedor buscarProveedor(Long id);
	public void eliminarProveedor(Long id);
	
}
