package com.tuapp.enums;

public enum EstadoProveedor {

    ACTIVO("1"),
    INACTIVO("0");

    private final String codigo;

    EstadoProveedor(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static EstadoProveedor fromCodigo(String codigo) {
        for (EstadoProveedor estado : EstadoProveedor.values()) {
            if (estado.getCodigo().equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código inválido para EstadoProveedor: " + codigo);
    }
    
}
