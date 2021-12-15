package reglas;

import com.dstp7.Negocio;
import com.dstp7.Producto;
import com.dstp7.Venta;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
        Regla 3: Jueves: llevando hasta 5 unidades iguales en “Lacteos” o “Verduras”, desde
        la segunda y hasta la quinta unidad se aplica un 30% de descuento a cada una.
*/


class Regla3Test {

    @Test
    public void cincoUnidadesIgualesLacteosVerdurasDesdeSegundaAQuintaRecibeDescuento() {

        Regla3 regla3 = new Regla3();
        //Venta venta1 = new Venta();
        Venta venta2 = new Venta(); //consulta para rubro verduras
        Negocio.Iniciar();
        venta2.AgregarDetalle(Negocio.Productos()[3], 5);
        //venta2.AgregarDetalle(Negocio.Productos()[3], 3);
        double descuento1 = regla3.RealizarDescuento(venta2);
        Assert.assertEquals(18,descuento1,0);

    }


}
