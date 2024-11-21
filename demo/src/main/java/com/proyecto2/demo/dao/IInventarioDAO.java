package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Inventario;

public interface IInventarioDAO extends CrudRepository<Inventario, Long> {
	public List<Inventario> findAllByOrderByArticulo();
	   public List<Inventario> findByArticulo(String articulo);
	   public List<Inventario> findByIdLessThan(Long id);
	   
	   @Query(value = "SELECT * FROM inventario WHERE inve_articulo LIKE ?1", nativeQuery = true)
	   public List<Inventario> cualquierArticulo(String articulo);
	
}
