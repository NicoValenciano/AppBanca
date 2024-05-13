package ar.edu.utn.frbb.tup.vista.account;

import ar.edu.utn.frbb.tup.modelo.*;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import java.time.LocalDate;

import static ar.edu.utn.frbb.tup.modelo.TipoMovimiento.CREACION_DE_CUENTA;

public class CreateAccountProcessor extends BaseInputProcessor {

    public Cuenta crearCuenta(Clientes clientes) {
        clearScreen();
        System.out.println("Ingrese el dni del cliente para asociarle una cuenta:");
        int dni = Integer.parseInt(scanner.nextLine());

        Cliente cliente = clientes.getClienteByDni(dni);
        if (cliente != null) {
            System.out.println("Cliente encontrado!");
            Cuenta cuenta = new Cuenta(null, 0, null, cliente);
            System.out.println("Ingrese los datos de la nueva cuenta:");
            int seleccion = 0;
            while (seleccion != 1 && seleccion != 2) {
                System.out.println("Ingrese 1 para cuenta corriente o 2 para caja de ahorro:");
                seleccion = Integer.parseInt(scanner.nextLine());
                if (seleccion == 1) {
                    TipoCuenta tipo = TipoCuenta.CUENTA_CORRIENTE;
                    cuenta.setTipo(tipo);
                } else if (seleccion == 2) {
                    TipoCuenta tipo = TipoCuenta.CAJA_DE_AHORROS;
                    cuenta.setTipo(tipo);
                } else {
                    System.out.println("Tipo de cuenta inválido, ingrese 1 ó 2.");
                }
                LocalDate fechaApertura = LocalDate.now();
                cuenta.setFechaApertura(fechaApertura);
                System.out.println("Cuenta creada con éxito!");
            }
            Movimientos.agregarMovimiento( new Movimiento(0, "Apertura de cuenta", cuenta.getId(), CREACION_DE_CUENTA));
            clearScreen();
            return cuenta;
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
        }
        clearScreen();
        return null;
    }
}