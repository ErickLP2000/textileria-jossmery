package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Tipocliente;

public interface ITipoclienteService {
    
    
    public List<Tipocliente> cargarTipocliente();
    public Tipocliente buscarTipocliente(Long id);
}
