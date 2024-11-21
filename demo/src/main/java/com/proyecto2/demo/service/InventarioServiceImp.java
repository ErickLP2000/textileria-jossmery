package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IInventarioDAO;
import com.proyecto2.demo.entidad.Inventario;

@Service
public class InventarioServiceImp implements IInventarioService {

	
	@Autowired
	private IInventarioDAO inventarioDAO;
	
	
	@Override
	public void guardarInventario(Inventario inventario) {
		inventarioDAO.save(inventario);
		
	}


	@Override
	public List<Inventario> cargarInventarios() {
		// TODO Auto-generated method stub
		return  (List<Inventario>)inventarioDAO.findAll();
	}


	@Override
	public Inventario buscarInventario(Long id) {
		return inventarioDAO.findById(id).orElse(null);
	}


	@Override
	public void eliminarInventario(Long id) {
		inventarioDAO.deleteById(id);
	}


	

}
