package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IClientesDAO;
import com.proyecto2.demo.entidad.Cliente;

@Service
public class ClientesServiceImp implements IClientesService{
    
    @Autowired
	private IClientesDAO clientesDAO;
	
	
	@Override
	public String guardarCliente(Cliente cliente) {
		String rpta = "";
        try{
            clientesDAO.save(cliente);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Cliente> cargarCliente() {
		return  (List<Cliente>)clientesDAO.findAll();
	}


	@Override
	public Cliente buscarCliente(Long id) {
		return clientesDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarCliente(Long id) {
		String rpta="";
        try{
            clientesDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
