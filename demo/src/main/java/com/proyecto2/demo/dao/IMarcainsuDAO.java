package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Marcainsu;

public interface IMarcainsuDAO extends CrudRepository<Marcainsu, Long>{
    
    public List<Marcainsu> findAllByOrderByNombre();
	public List<Marcainsu> findByNombre(String nombre);
	public List<Marcainsu> findByIdLessThan(Long id);
}
