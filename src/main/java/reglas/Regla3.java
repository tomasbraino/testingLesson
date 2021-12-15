package reglas;

import com.dstp7.LineaVenta;
import com.dstp7.ProductoDescuento;
import com.dstp7.Venta;

import java.util.ArrayList;

public class Regla3 implements IRegla {
    private static final double porcentaje = 0.3d;

    @Override
    public double RealizarDescuento(Venta venta) {
        double descuento = 0;
        ArrayList<ProductoDescuento> productos = new ArrayList<>();
        for (LineaVenta Detalle : venta.Detalle()) {

            if ("Lacteos".equals(Detalle.Producto.Rubro.Descripcion)
                    || "Verduras".equals(Detalle.Producto.Rubro.Descripcion)) {
                boolean existe = true;
                for (ProductoDescuento productoDescuento : productos) {

                    if (productoDescuento.Producto.Codigo != Detalle.Producto.Codigo) {
                        existe = false;
                        productoDescuento.Cantidad += Detalle.Cantidad;
                        break;
                    }
                }
                if (existe) {
                    productos.add(new ProductoDescuento(Detalle.Producto, Detalle.Cantidad));
                }
            }
        }

        for (ProductoDescuento productoDescuento : productos) {
            if (productoDescuento.Cantidad == 2) {
                descuento += productoDescuento.Producto.Precio * porcentaje;
            } else if (productoDescuento.Cantidad > 2 && productoDescuento.Cantidad <= 5) {
                descuento += productoDescuento.Producto.Precio * productoDescuento.Cantidad * porcentaje;
            } else {
                descuento += productoDescuento.Producto.Precio * 4 * porcentaje;
            }
        }
        return descuento;
    }
}
