package ar.edu.utn.frbb.tup.vista.movement;

import ar.edu.utn.frbb.tup.modelo.Cuenta;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimiento;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.CONSULTA_DE_SALDO;

public class CheckBalanceProcessor extends BaseInputProcessor {
    private Cuentas cuentas;

    public CheckBalanceProcessor(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void processCheckBalance() {
        clearScreen();
        System.out.println("Ingrese el número de cuenta para consultar el saldo:");
        int numeroCuenta = Integer.parseInt(scanner.nextLine());
        for (Cuenta cuenta : cuentas.getCuentas()) {
            if (cuenta.getId() == numeroCuenta) {
                System.out.println("El saldo de la cuenta es: " + cuenta.getSaldo());
                Movimientos.agregarMovimiento(new Movimiento(cuenta.getSaldo(), "Consulta de saldo", numeroCuenta, CONSULTA_DE_SALDO));
            } else {
                System.out.println("La cuenta ingresada no existe");
            }
        }
    }
}
