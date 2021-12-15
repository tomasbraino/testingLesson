package reglas;

import com.dstp7.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
        Regla 2: Martes y Miércoles: en compras superiores a $500 y hasta $1000
        (inclusive), se aplica un 3% de descuento al total de la venta. En compras superiores a
        $1000 y hasta $2500 (inclusive), se aplica un 5%. En compras superiores a 2500
        corresponde un 6,5%.
*/

class Regla2Test {

    @Test
    public void compraSuperiorQuinientosRecibeDescuentoDeTres() {

        Regla2 regla2 = new Regla2();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[6], 1);
        double descuento = regla2.RealizarDescuento(venta);
        Assert.assertEquals(15, descuento, 0);

    }

    @Test
    public void compraSuperiorMilRecibeDescuentoDeCinco() {

        Regla2 regla2 = new Regla2();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[6], 1);
        double descuento = regla2.RealizarDescuento(venta);
        Assert.assertEquals(60, descuento, 0);

    }

    @Test
    public void compraSuperiorDosQuinientosRecibeDescuentoDeSeis() {
        Regla2 regla2 = new Regla2();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[6], 1);
        double descuento = regla2.RealizarDescuento(venta);
        Assert.assertEquals(162.5, descuento, 0);

    }


}