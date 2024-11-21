package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long> {
	public List<Categoria> findAllByOrderByNombre();
	   public List<Categoria> findByNombre(String nombre);
	   public List<Categoria> findByIdLessThan(Long id);
	   
	   @Query(value = "SELECT * FROM categoria WHERE cat_nom LIKE ?1", nativeQuery = true)
	   public List<Categoria> cualquierNombre(String nombre);
	
}
