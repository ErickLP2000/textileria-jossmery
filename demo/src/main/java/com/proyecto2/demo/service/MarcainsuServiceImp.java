package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IMarcainsuDAO;
import com.proyecto2.demo.entidad.Marcainsu;

@Service
public class MarcainsuServiceImp implements IMarcainsuService{

    @Autowired
    private IMarcainsuDAO marcainsuDAO;

    @Override
	public String guardarMarcainsu(Marcainsu marcainsu) {
		String rpta = "";
        try{
            marcainsuDAO.save(marcainsu);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Marcainsu> cargarMarcainsu() {
		return  (List<Marcainsu>)marcainsuDAO.findAll();
	}


	@Override
	public Marcainsu buscarMarcainsu(Long id) {
		return marcainsuDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarMarcainsu(Long id) {
		String rpta="";
        try{
            marcainsuDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
