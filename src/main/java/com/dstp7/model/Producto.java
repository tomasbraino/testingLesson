package main.java.com.dstp7.model;

public class Producto {



    public Producto() {

    }

    public Producto(int codigo, String descripcion, double precio, Rubro rubro) {
        Codigo = codigo;
        Descripcion = descripcion;
        Precio = precio;
        Rubro = rubro;
    }
    public int Codigo;
    public String Descripcion;  //Error de semantica tener los atributos o campos debajo de los metodos
    public double Precio;
    public Rubro Rubro;

    //Error de semantica no tener los metodos equals() y hashCode()

}
