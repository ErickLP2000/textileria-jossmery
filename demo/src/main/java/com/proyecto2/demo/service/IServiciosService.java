package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Servicios;

public interface IServiciosService {

    public String guardarServicios(Servicios servicios);
    public List<Servicios> cargarServicios();
    public Servicios buscarServicios(Long id);
    public String eliminarServicios(Long id);
    
}
