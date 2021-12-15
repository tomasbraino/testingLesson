package reglas;

/*
*
* Regla 1: Lunes: llevando 2 o 3 productos iguales de “Panaderia”, la segunda y
tercera unidad van al 50% de su valor. Si se llevan más unidades el precio es el mismo
*
*
* */

import com.dstp7.LineaVenta;
import com.dstp7.ProductoDescuento;
import com.dstp7.Venta;

import java.util.ArrayList;

public class Regla1 implements IRegla {

    private static final double porcentaje = 0.5d;

    @Override
    public double RealizarDescuento(Venta venta) {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        for (LineaVenta Detalle : venta.Detalle()) {

            if ("Panaderia".equals(Detalle.Producto.Rubro.Descripcion)) {
                boolean existe = false;

                for (ProductoDescuento productoDescuento : productos) {
                    if (productoDescuento.Producto.Codigo == Detalle.Producto.Codigo) {
                        existe = true;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }

                if (!existe) {
                    productos.add(new ProductoDescuento(Detalle.Producto, Detalle.Cantidad));
                }
            }
        }
        for (ProductoDescuento productoDescuento : productos) {
            if (productoDescuento.Cantidad == 2 || productoDescuento.Cantidad == 3) { //para 2 o 3 unidades de panaderia hay 50% de descuento
                descuento += productoDescuento.Producto.Precio * porcentaje;
            } else if (productoDescuento.Cantidad > 3) {
                //descuento = productoDescuento.Producto.Precio * porcentaje; //si me llevo mas de 3 productos el precio es el mismo
                descuento = productoDescuento.Producto.Precio;
            }
        }
        return descuento;
    }
}

    

    

    

