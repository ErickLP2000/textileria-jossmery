package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Catproducto;

public interface ICatproductoDAO extends CrudRepository<Catproducto,Long>{

    public List<Catproducto> findAllByOrderByNombre();
	public List<Catproducto> findByNombre(String nombre);
	public List<Catproducto> findByIdLessThan(Long id);

    
    
}
