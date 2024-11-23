package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProductosDAO;
import com.proyecto2.demo.entidad.Productos;


@Service
public class ProductosServiceImp implements IProductosService{

    @Autowired
    private IProductosDAO productosDAO;

    @Override
	public String guardarProductos(Productos productos) {
		String rpta = "";
        try{
            productosDAO.save(productos);
            rpta = "Se guardó el insumo correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
		
	}


	@Override
	public List<Productos> cargarProductos() {
		return  (List<Productos>)productosDAO.findAll();
	}


	@Override
	public Productos buscarProductos(Long id) {
		return productosDAO.findById(id).orElse(null);
	}


	@Override
	public String eliminarProductos(Long id) {
		String rpta="";
        try{
            productosDAO.deleteById(id);
            rpta = "Se ha eliminado el insumo correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
	}
    
}
