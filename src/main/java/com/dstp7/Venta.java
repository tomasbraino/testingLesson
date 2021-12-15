package com.dstp7;

import java.util.ArrayList;

public class Venta {

    private double _descuento;
    private final ArrayList<LineaVenta> detalle = new ArrayList<>();

    public void AgregarDetalle(Producto producto, int cantidad) {
        LineaVenta lv = new LineaVenta(producto, cantidad);
        detalle.add(lv);
    }

    public double Descuento() {

        return _descuento;
    }

    public LineaVenta[] Detalle() {
        LineaVenta[] lineas = new LineaVenta[detalle.size()];
        return detalle.toArray(lineas);
    }

    public void CalcularDescuentos(DiaSemana dia) {
        _descuento = Negocio.Reglas()[dia.getValue()].RealizarDescuento(this);
    }

    public double Total() {
        double total = 0d;
        if (Detalle() == null) return total;
        for (int i = 0; i < Detalle().length; i++) {
            total += Detalle()[i].SubTotal();
        }
        return total;
    }

    public double TotalGeneral() {
        return Total() - _descuento;
    }
}
