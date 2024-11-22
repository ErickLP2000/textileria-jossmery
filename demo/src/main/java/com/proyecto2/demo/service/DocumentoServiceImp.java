package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IDocumentoDAO;
import com.proyecto2.demo.entidad.Documento;

@Service
public class DocumentoServiceImp implements IDocumentoService{
    
    @Autowired
    private IDocumentoDAO documentoDAO;

    @Override
	public List<Documento> cargarDocumento() {
		return  (List<Documento>)documentoDAO.findAll();
	}

    @Override
	public Documento buscarDocumento(Long id) {
		return documentoDAO.findById(id).orElse(null);
	}
}
