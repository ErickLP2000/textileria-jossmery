package com.proyecto2.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto2.demo.dao.IDistritoDAO;
import com.proyecto2.demo.entidad.Distrito;

@Service
public class DistritoServiceImp implements IDistritoService{

    @Autowired
    private IDistritoDAO distritoDAO;

    @Override
    public List<Distrito> cargarDistrito(){
        return (List<Distrito>)distritoDAO.findAll();
    }

    @Override
    public Distrito buscarDistrito(Long id){
        return distritoDAO.findById(id).orElse(null);
    }
    
}
