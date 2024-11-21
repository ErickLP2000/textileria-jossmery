package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IClienteDAO;
import com.proyecto2.demo.entidad.Clientes;

@Service
public class ClienteServiceImp implements IClienteService{

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Override
	public void guardarcliente(Clientes cliente) {
	
		clienteDAO.save(cliente);
		
	}

	@Override
	public List<Clientes> cargarclientes() {
		return  (List<Clientes>)clienteDAO.findAll();
	}
	
}
