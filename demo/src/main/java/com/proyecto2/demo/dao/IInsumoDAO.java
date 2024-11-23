package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Insumo;

public interface IInsumoDAO extends CrudRepository<Insumo,Long>{
    
}
