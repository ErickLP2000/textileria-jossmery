package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Catproducto;

public interface ICatproductoService {

    public String guardarCatproducto(Catproducto catproducto);
    public List<Catproducto> cargarCatproducto();
    public Catproducto buscarCatproducto(Long id);
    public String eliminarCatproducto(Long id);
    
}
