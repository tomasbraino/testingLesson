package reglas;

import com.dstp7.Negocio;
import com.dstp7.Venta;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*
   Reglar 4: Viernes, Sábado y Domingo: solo en compras superiores a $1000, se
    aplica un 10% de descuento a todos los productos con más de 3 unidades.
*/


class Regla4Test {

    @Test
    public void comprasSupMilMasDeTresUnidadesRecibeDescuento() {

        Regla4 regla4 = new Regla4();
        Venta venta = new Venta();
        Negocio.Iniciar();
        venta.AgregarDetalle(Negocio.Productos()[2], 3);
        double descuento = regla4.RealizarDescuento(venta);
        Assert.assertEquals(12,descuento,0);

    }


}

