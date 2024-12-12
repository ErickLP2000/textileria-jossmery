package com.proyecto2.demo.service;

import java.util.List;

public interface ICRUD<T, ID> {
    public String registrar(T bean) throws Exception;
    public T actualizar(T bean) throws Exception;
    public String eliminar(ID cod) throws Exception;
    public List<T> listar() throws Exception;
    public T buscar(ID cod) throws Exception;
        
}
