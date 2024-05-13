package ar.edu.utn.frbb.tup.vista.movement;

import ar.edu.utn.frbb.tup.modelo.Cuenta;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimiento;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.DEPOSITO;


public class DepositInputProcessor extends BaseInputProcessor {
    private Cuentas cuentas;

    public DepositInputProcessor(Cuentas cuentas){
        this.cuentas = cuentas;
    }

    public void processDeposit() {
        clearScreen();
        System.out.println("Ingrese el número de cuenta donde quiere depositar:");
        int numeroCuenta = Integer.parseInt(scanner.nextLine());
        for (Cuenta cuenta : cuentas.getCuentas()) {
            if (cuenta.getId() == numeroCuenta) {
                System.out.println("Ingrese el monto a depositar:");
                double monto = Double.parseDouble(scanner.nextLine());
                cuenta.depositar(monto);
                System.out.println("Deposito realizado con exito");
                Movimientos.agregarMovimiento(new Movimiento(monto, "Deposito", numeroCuenta,DEPOSITO));
            }else{
                System.out.println("La cuenta ingresada no existe");
            }
        }
    }
}
