package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Distrito;

public interface IDistritoService {

    
    public List<Distrito> cargarDistrito();
    public Distrito buscarDistrito(Long id);
    
}