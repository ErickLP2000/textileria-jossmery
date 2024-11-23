package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Productos;

public interface IProductosService {

    public String guardarProductos(Productos productos);
    public List<Productos> cargarProductos();
    public Productos buscarProductos(Long id);
    public String eliminarProductos(Long id);
    
}
