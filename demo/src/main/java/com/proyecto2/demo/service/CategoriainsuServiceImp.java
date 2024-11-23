package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ICategoriainsuDAO;
import com.proyecto2.demo.entidad.Categoriainsu;

@Service
public class CategoriainsuServiceImp implements ICategoriainsuService{

    @Autowired
    private ICategoriainsuDAO categoriainsuDAO;

    @Override
	public String guardarCategoriainsu(Categoriainsu categoriainsu) {
		String rpta = "";
        try{
            categoriainsuDAO.save(categoriainsu);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Categoriainsu> cargarCategoriainsu() {
		return  (List<Categoriainsu>)categoriainsuDAO.findAll();
	}


	@Override
	public Categoriainsu buscarCategoriainsu(Long id) {
		return categoriainsuDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarCategoriainsu(Long id) {
		String rpta="";
        try{
            categoriainsuDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
