package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Marcainsu;

public interface IMarcainsuService {
    
    public String guardarMarcainsu(Marcainsu marcainsu);
    public List<Marcainsu> cargarMarcainsu();
    public Marcainsu buscarMarcainsu(Long id);
    public String eliminarMarcainsu(Long id);
}
