package ar.edu.utn.frbb.tup.vista.movement;

import ar.edu.utn.frbb.tup.modelo.Cuenta;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimiento;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.RETIRO;
import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.TRANSFERENCIA_ENTRE_CUENTAS;

public class TransferInputProcessor extends BaseInputProcessor {
    private Cuentas cuentas;
    Cuenta esCuentaOrigen;
    Cuenta esCuentaDestino;

    public TransferInputProcessor(Cuentas cuentas) {
        this.cuentas = cuentas;
    }

    public void processTransfer() {
        clearScreen();
        boolean cuentaOrigen = false;
        boolean cuentaDestino= false;


        while (!cuentaOrigen){
            System.out.println("Ingrese el número de cuenta origen:");
            int numeroCuentaOrigen = Integer.parseInt(scanner.nextLine());
            for (Cuenta cuenta : cuentas.getCuentas()) {
                if (cuenta.getId() == numeroCuentaOrigen) {
                    cuentaOrigen = true;
                    esCuentaOrigen = cuenta;
                    break;
                }else {
                    System.out.println("La cuenta origen ingresada no existe");
                }
            }
        }
        while (!cuentaDestino){
            System.out.println("Ingrese el número de cuenta destino:");
            int numeroCuentaDestino = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingrese el monto a transferir:");
            for (Cuenta cuenta : cuentas.getCuentas()) {
                if (cuenta.getId() == numeroCuentaDestino) {
                    cuentaDestino = true;
                    esCuentaDestino = cuenta;
                    break;
                }else {
                    System.out.println("La cuenta destino ingresada no existe");
                }
            }
        }
        if (cuentaOrigen && cuentaDestino) {
            double monto = Double.parseDouble(scanner.nextLine());
            esCuentaOrigen.retirar(monto);
            Movimientos.agregarMovimiento(new Movimiento(monto, "Extracción de dinero por trasnferencia", esCuentaOrigen.getId(), TRANSFERENCIA_ENTRE_CUENTAS));
            esCuentaDestino.depositar(monto);
            Movimientos.agregarMovimiento(new Movimiento(monto, "Depósito de dinero por trasnferencia", esCuentaDestino.getId(), TRANSFERENCIA_ENTRE_CUENTAS));
        }

    }
}
