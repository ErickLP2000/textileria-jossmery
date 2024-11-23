package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Categoriainsu;

public interface ICategoriainsuDAO extends CrudRepository<Categoriainsu, Long>{

    public List<Categoriainsu> findAllByOrderByNombre();
	public List<Categoriainsu> findByNombre(String nombre);
	public List<Categoriainsu> findByIdLessThan(Long id);
}
