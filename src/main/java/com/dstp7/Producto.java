package com.dstp7;

public class Producto {

    public int Codigo;
    public String Descripcion;  
    public double Precio;
    public Rubro Rubro;


    public Producto(int codigo, String descripcion, double precio, Rubro rubro) {
        this.Codigo = codigo;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.Rubro = rubro;
    }

    public int getCodigo() {
        return Codigo;
    }
}
