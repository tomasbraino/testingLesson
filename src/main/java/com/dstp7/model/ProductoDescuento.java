package main.java.com.dstp7.model;

public class ProductoDescuento {
    public ProductoDescuento() {
    }

    public ProductoDescuento(Producto producto) {
        Producto = producto;
        Cantidad = 1;
    }

    public Producto Producto;
    public int Cantidad;
}
