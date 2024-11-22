package com.proyecto2.demo.service;

import java.util.List;

import com.proyecto2.demo.entidad.Documento;

public interface IDocumentoService {
    
    
    public List<Documento> cargarDocumento();
    public Documento buscarDocumento(Long id);
}
