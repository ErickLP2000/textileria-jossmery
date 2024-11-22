package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Cliente;

public interface IClientesService {

    public String guardarCliente(Cliente cliente);
    public List<Cliente> cargarCliente();
    public Cliente buscarCliente(Long id);
    public String eliminarCliente(Long id);

    
}
