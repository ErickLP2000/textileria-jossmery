package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IEspservicioDAO;
import com.proyecto2.demo.entidad.Espservicio;

@Service
public class EspservicioServiceImp implements IEspservicioService{

    @Autowired
    private IEspservicioDAO espservicioDAO;

    @Override
	public String guardarEspservicio(Espservicio espservicio) {
		String rpta = "";
        try{
            espservicioDAO.save(espservicio);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Espservicio> cargarEspservicio() {
		return  (List<Espservicio>)espservicioDAO.findAll();
	}


	@Override
	public Espservicio buscarEspservicio(Long id) {
		return espservicioDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarEspservicio(Long id) {
		String rpta="";
        try{
            espservicioDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
