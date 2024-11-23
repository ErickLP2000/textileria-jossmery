package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Espservicio;

public interface IEspservicioService {

    public String guardarEspservicio(Espservicio espservicio);
    public List<Espservicio> cargarEspservicio();
    public Espservicio buscarEspservicio(Long id);
    public String eliminarEspservicio(Long id);
    
}
