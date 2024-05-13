package ar.edu.utn.frbb.tup.vista.movement;

import ar.edu.utn.frbb.tup.modelo.Cuenta;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimiento;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.RETIRO;

public class ExtractionInputProcessor extends BaseInputProcessor {
    private Cuentas cuentas;


    public ExtractionInputProcessor(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void processExtraction() {
        clearScreen();
        System.out.println("Ingrese el número de cuenta donde va a realizar la extraccion:");
        int numeroCuenta = Integer.parseInt(scanner.nextLine());
        for (Cuenta cuenta : cuentas.getCuentas()) {
            if (cuenta.getId() == numeroCuenta) {
                System.out.println("Ingrese el monto a retirar:");
                double monto = Double.parseDouble(scanner.nextLine());
                cuenta.retirar(monto);
                Movimientos.agregarMovimiento(new Movimiento(monto, "Extracción de dinero", numeroCuenta,RETIRO));
            }else{
                System.out.println("La cuenta ingresada no existe");
            }
        }
    }
}