package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IServiciosDAO;
import com.proyecto2.demo.entidad.Servicios;

@Service
public class ServiciosServiceImp implements IServiciosService{

    @Autowired
    private IServiciosDAO serviciosDAO;

    @Override
	public String guardarServicios(Servicios servicios) {
		String rpta = "";
        try{
            serviciosDAO.save(servicios);
            rpta = "Se guardó el servicio correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Servicios> cargarServicios() {
		return  (List<Servicios>)serviciosDAO.findAll();
	}


	@Override
	public Servicios buscarServicios(Long id) {
		return serviciosDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarServicios(Long id) {
		String rpta="";
        try{
            serviciosDAO.deleteById(id);
            rpta = "Se ha eliminado el servicio correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}

    
}
