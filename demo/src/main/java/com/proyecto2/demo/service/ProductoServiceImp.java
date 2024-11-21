package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IProductoDAO;
import com.proyecto2.demo.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService{

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public String guardarProducto(Producto producto) {
        String rpta = "";
        try{
            productoDAO.save(producto);
            rpta = "Se guardó el producto correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
    }

    @Override
    public List<Producto> cargarProductos() {
        return (List<Producto>)productoDAO.findAll();
    }

    @Override
    public String eliminarProducto(Long id) {
        String rpta="";
        try{
            productoDAO.deleteById(id);
            rpta = "Se ha eliminado el producto correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
    }
    
}
