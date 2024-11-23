package com.proyecto2.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Espservicio;

public interface IEspservicioDAO extends CrudRepository<Espservicio,Long>{

    public List<Espservicio> findAllByOrderByNombre();
	public List<Espservicio> findByNombre(String nombre);
	public List<Espservicio> findByIdLessThan(Long id);
    
}
