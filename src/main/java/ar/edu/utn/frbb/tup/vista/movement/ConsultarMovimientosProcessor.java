package ar.edu.utn.frbb.tup.vista.movement;

import ar.edu.utn.frbb.tup.modelo.Movimiento;
import ar.edu.utn.frbb.tup.modelo.Movimientos;

//Acá se podría sumar lógica para que mustre los movimientos de una cuenta en particular, una fecha, un tipo, etc. Por ahora solo muestra todos los movimientos.

public class ConsultarMovimientosProcessor {
    private Movimientos movimientos;

    public ConsultarMovimientosProcessor(Movimientos movimientos) {
        this.movimientos = movimientos;
    }
        public void ConsultarMovimientos(Movimientos movimientos){
            for (Movimiento movimiento : movimientos.getMovimientos()) {
                System.out.println(movimiento.toString());
            }
        }
    }
