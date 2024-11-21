package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProveedorDAO;
import com.proyecto2.demo.entidad.Proveedor;

@Service
public class ProveedorServiceImp implements IProveedorService {

	
	@Autowired
	private IProveedorDAO proveedorDAO;
	
	
	@Override
	public void guardarProveedor(Proveedor proveedor) {
		proveedorDAO.save(proveedor);
		
	}


	@Override
	public List<Proveedor> cargarProveedores() {
		// TODO Auto-generated method stub
		return  (List<Proveedor>)proveedorDAO.findAll();
	}


	@Override
	public Proveedor buscarProveedor(Long id) {
		return proveedorDAO.findById(id).orElse(null);
	}


	@Override
	public void eliminarProveedor(Long id) {
		proveedorDAO.deleteById(id);
	}


	

}
