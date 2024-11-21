package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto,Long>{
    
}
