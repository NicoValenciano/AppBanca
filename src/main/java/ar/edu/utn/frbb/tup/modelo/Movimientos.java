package ar.edu.utn.frbb.tup.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Movimientos {
    private static List<Movimiento> movimientos = new ArrayList<>();

    public Movimientos() {
        movimientos = new ArrayList<>();
    }

    public static void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    public static List<Movimiento> getMovimientos() {
        return movimientos;
    }
}