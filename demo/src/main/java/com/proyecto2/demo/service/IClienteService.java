package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Clientes;

public interface IClienteService {
	public void guardarcliente(Clientes cliente);
	public List<Clientes> cargarclientes();
}
