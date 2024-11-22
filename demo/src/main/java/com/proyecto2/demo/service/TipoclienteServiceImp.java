package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ITipoclienteDAO;
import com.proyecto2.demo.entidad.Tipocliente;

@Service
public class TipoclienteServiceImp implements ITipoclienteService{

    @Autowired
    private ITipoclienteDAO tipoclienteDAO;

    @Override
	public List<Tipocliente> cargarTipocliente() {
		return  (List<Tipocliente>)tipoclienteDAO.findAll();
	}

    @Override
	public Tipocliente buscarTipocliente(Long id) {
		return tipoclienteDAO.findById(id).orElse(null);
	}
    
}
