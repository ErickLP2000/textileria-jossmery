package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Insumo;

public interface IInsumoService {

    public String guardarInsumo(Insumo insumo);
    public List<Insumo> cargarInsumo();
    public Insumo buscarInsumo(Long id);
    public String eliminarInsumo(Long id);
    
}
