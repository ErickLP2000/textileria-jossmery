package com.proyecto2.demo.serviceImp;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto2.demo.service.ICRUD;

public abstract class ICRUDImp<T, ID> implements ICRUD<T, ID>{

    public abstract JpaRepository<T, ID> getJpaRepository();

    @Override
    public String registrar(T bean) throws Exception {
        String rpta = "";
        try{
            getJpaRepository().save(bean);
            rpta = "Se guardó correctamente";
        }catch(Exception e){
            rpta = e.toString();
        }
        return rpta;
    } 

    @Override
    public T actualizar(T bean) throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().save(bean);
    }

    @Override
    public T buscar(ID cod) throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().findById(cod).orElse(null);
    }

    @Override
    public String eliminar(ID cod) throws Exception {
    String rpta;
    try {
        getJpaRepository().deleteById(cod);
        rpta = "Se ha eliminado correctamente";
    } catch (Exception e) {
        rpta = "Error al eliminar: " + e.getMessage();
    }
    return rpta;
}


    @Override
    public List<T> listar() throws Exception {
        // TODO Auto-generated method stub
        return getJpaRepository().findAll();
    }
}
