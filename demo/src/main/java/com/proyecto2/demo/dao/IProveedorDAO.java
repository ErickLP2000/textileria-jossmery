package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Proveedor;

public interface IProveedorDAO extends CrudRepository<Proveedor, Long> {
	public List<Proveedor> findAllByOrderByNombre();
	   public List<Proveedor> findByNombre(String nombre);
	   public List<Proveedor> findByIdLessThan(Long id);
	   
	   @Query(value = "SELECT * FROM proveedor WHERE prov_nombre LIKE ?1", nativeQuery = true)
	   public List<Proveedor> cualquierNombre(String nombre);
	
}
