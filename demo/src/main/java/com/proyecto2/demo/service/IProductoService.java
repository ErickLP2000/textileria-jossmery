package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Producto;

public interface IProductoService {
    public String guardarProducto(Producto producto);
    public List<Producto> cargarProductos();
    public String eliminarProducto(Long id);
}
