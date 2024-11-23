package com.tuapp.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.tuapp.enums.EstadoProveedor;

@Converter(autoApply = true)
public class EstadoProveedorConverter implements AttributeConverter<EstadoProveedor, String> {

    @Override
    public String convertToDatabaseColumn(EstadoProveedor estado) {
        return estado != null ? estado.getCodigo() : null; // Convierte enum a código
    }

    @Override
    public EstadoProveedor convertToEntityAttribute(String codigo) {
        return EstadoProveedor.fromCodigo(codigo); // Convierte código a enum
    }
    
}
