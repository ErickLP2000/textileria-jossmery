package com.proyecto2.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto2.demo.entidad.Clientes;

public interface IClienteDAO extends CrudRepository<Clientes, Long> {

}
