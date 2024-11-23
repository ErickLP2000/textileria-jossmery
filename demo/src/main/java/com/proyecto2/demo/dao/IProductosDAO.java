package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Productos;

public interface IProductosDAO extends CrudRepository<Productos,Long>{
    
}
