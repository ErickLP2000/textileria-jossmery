package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Cliente;

public interface IClientesDAO extends CrudRepository<Cliente, Long>{
    
}
