package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Categoriainsu;

public interface ICategoriainsuService {
    
    public String guardarCategoriainsu(Categoriainsu categoriainsu);
    public List<Categoriainsu> cargarCategoriainsu();
    public Categoriainsu buscarCategoriainsu(Long id);
    public String eliminarCategoriainsu(Long id);
}
