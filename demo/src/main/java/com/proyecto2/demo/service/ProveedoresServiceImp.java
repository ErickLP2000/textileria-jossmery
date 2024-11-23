package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProveedoresDAO;
import com.proyecto2.demo.entidad.Proveedores;

@Service
public class ProveedoresServiceImp implements IProveedoresService{

    @Autowired
    private IProveedoresDAO proveedoresDAO;

    @Override
	public String guardarProveedores(Proveedores proveedores) {
		String rpta = "";
        try{
            proveedoresDAO.save(proveedores);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Proveedores> cargarProveedores() {
		return  (List<Proveedores>)proveedoresDAO.findAll();
	}


	@Override
	public Proveedores buscarProveedores(Long id) {
		return proveedoresDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarProveedores(Long id) {
		String rpta="";
        try{
            proveedoresDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}

    
}
