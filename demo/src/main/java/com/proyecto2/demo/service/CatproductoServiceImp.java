package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.ICatproductoDAO;
import com.proyecto2.demo.entidad.Catproducto;

@Service
public class CatproductoServiceImp implements ICatproductoService{

    @Autowired
    private ICatproductoDAO catproductoDAO;

    @Override
	public String guardarCatproducto(Catproducto catproducto) {
		String rpta = "";
        try{
            catproductoDAO.save(catproducto);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Catproducto> cargarCatproducto() {
		return  (List<Catproducto>)catproductoDAO.findAll();
	}


	@Override
	public Catproducto buscarCatproducto(Long id) {
		return catproductoDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarCatproducto(Long id) {
		String rpta="";
        try{
            catproductoDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
