package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Proveedores;

public interface IProveedoresService {

    public String guardarProveedores(Proveedores proveedores);
    public List<Proveedores> cargarProveedores();
    public Proveedores buscarProveedores(Long id);
    public String eliminarProveedores(Long id);
    
}
