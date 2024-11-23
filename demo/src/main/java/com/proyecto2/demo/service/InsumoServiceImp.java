package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IInsumoDAO;
import com.proyecto2.demo.entidad.Insumo;

@Service
public class InsumoServiceImp implements IInsumoService{

    @Autowired
    private IInsumoDAO insumoDAO;

    @Override
	public String guardarInsumo(Insumo insumo) {
		String rpta = "";
        try{
            insumoDAO.save(insumo);
            rpta = "Se guardó el insumo correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Insumo> cargarInsumo() {
		return  (List<Insumo>)insumoDAO.findAll();
	}


	@Override
	public Insumo buscarInsumo(Long id) {
		return insumoDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarInsumo(Long id) {
		String rpta="";
        try{
            insumoDAO.deleteById(id);
            rpta = "Se ha eliminado el insumo correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
