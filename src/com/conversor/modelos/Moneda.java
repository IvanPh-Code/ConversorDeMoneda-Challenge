package com.conversor.modelos;

public class Moneda {
    private String nombre;
    private String codigo;

    public Moneda(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "]";
    }
}
