package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Tipocliente;

public interface ITipoclienteDAO extends CrudRepository<Tipocliente,Long>{


    public List<Tipocliente> findAllByOrderByNombre();
	   public List<Tipocliente> findByNombre(String nombre);
	   public List<Tipocliente> findByIdLessThan(Long id);
    
    
}
