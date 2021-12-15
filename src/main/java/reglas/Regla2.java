package reglas;

import com.dstp7.Venta;

public class Regla2 implements IRegla {
    private static final double porcentaje1 = 0.03d;
    private static final double porcentaje2 = 0.05d;
    private static final double porcentaje3 = 0.065d;

    @Override
    public double RealizarDescuento(Venta venta) {
        double total = venta.Total();
        if (total >= 500 && total <= 1000) { //correccion de operadores
            return total * porcentaje1;
        }
        if (total >= 1000 && total <= 2500) { //correccion de operadores
            return total * porcentaje2; //correccion calculo de porcentaje
        } else if (total >= 2500) {
            return total * porcentaje3;
        }
        return 0;
    }

}
