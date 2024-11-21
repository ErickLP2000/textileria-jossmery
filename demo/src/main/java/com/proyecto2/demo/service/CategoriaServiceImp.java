package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ICategoriaDAO;
import com.proyecto2.demo.entidad.Categoria;

@Service
public class CategoriaServiceImp implements ICategoriaService {

	
	@Autowired
	private ICategoriaDAO categoriaDAO;
	
	
	@Override
	public void guardarCategoria(Categoria categoria) {
		categoriaDAO.save(categoria);
		
	}


	@Override
	public List<Categoria> cargarCategorias() {
		// TODO Auto-generated method stub
		return  (List<Categoria>)categoriaDAO.findAll();
	}


	@Override
	public Categoria buscarCategoria(Long id) {
		return categoriaDAO.findById(id).orElse(null);
	}


	@Override
	public void eliminarCategoria(Long id) {
		categoriaDAO.deleteById(id);
	}


	

}
