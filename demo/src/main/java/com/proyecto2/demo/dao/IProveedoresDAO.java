package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Proveedores;

public interface IProveedoresDAO extends CrudRepository<Proveedores, Long>{

    public List<Proveedores> findAllByOrderByNombre();
	   public List<Proveedores> findByNombre(String nombre);
	   public List<Proveedores> findByIdLessThan(Long id);

}
