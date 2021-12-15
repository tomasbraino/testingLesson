package reglas;

import com.dstp7.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class Regla1Test {

    /*
    Regla 1: Lunes: llevando 2 o 3 productos iguales de “Panaderia”, la segunda y
    tercera unidad van al 50% de su valor. Si se llevan más unidades el precio es el mismo.


    datos a comprobar:

     -si los productos son iguales
     -si lleva 0 productos
     -si lleva 1 o + productos
     -si lleva productos que no son de panaderia
    */

    @Test
    public void dosProductosIgualesDePanaderiaRecibeDescuento() {

        Regla1 regla1 = new Regla1();
        Venta venta1 = new Venta();
        Negocio.Iniciar();
        venta1.AgregarDetalle(Negocio.Productos()[0], 2);
        double descuento = regla1.RealizarDescuento(venta1);
        Assert.assertEquals(25.0, descuento, 0);

    }

    @Test
    public void tresProductosIgualesDePanaderiaRecibeDescuento() {

        Regla1 regla1 = new Regla1();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[6], 3);//rubro1 index nº6
        double descuento = regla1.RealizarDescuento(venta);
        Assert.assertEquals(14, descuento, 0);

    }
    @Test
    public void llevaMasDeTresProductosElPrecioEsElMismo() {

        Regla1 regla1 = new Regla1();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[6], 4); //funciona tambien para index[0] rubro1
        double descuento = regla1.RealizarDescuento(venta);
        Assert.assertEquals(28,descuento,0);

    }


}