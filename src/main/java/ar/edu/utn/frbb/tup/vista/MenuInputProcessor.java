package ar.edu.utn.frbb.tup.vista;

import ar.edu.utn.frbb.tup.modelo.Clientes;
import ar.edu.utn.frbb.tup.modelo.Cuenta;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.account.CreateAccountProcessor;
import ar.edu.utn.frbb.tup.vista.client.ClienteMenuInputProcessor;
import ar.edu.utn.frbb.tup.vista.movement.ConsultarMovimientosProcessor;
import ar.edu.utn.frbb.tup.vista.movement.OperationInputProcessor;

public class MenuInputProcessor extends BaseInputProcessor{
    boolean exit = false;

    public void renderMenu(Clientes clientes, Cuentas cuentas, Movimientos movimientos) {

        while (!exit) {
            System.out.println("Bienvenido a la aplicación de Banco!");
            System.out.println("1. Alta, baja o modificación de un Cliente");
            System.out.println("2. Crear una nueva Cuenta");
            System.out.println("3. Operar con una cuenta");
            System.out.println("4. Consultar movimientos");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    ClienteMenuInputProcessor clienteMenuInputProcessor = new ClienteMenuInputProcessor();
                    clienteMenuInputProcessor.renderMenu(clientes);
                    break;
                case 2:
                    CreateAccountProcessor createAccountProcessor = new CreateAccountProcessor();
                    Cuenta c = createAccountProcessor.crearCuenta(clientes);
                    cuentas.getCuentas().add(c);
                    break;
                case 3:
                    OperationInputProcessor operationInputProcessor = new OperationInputProcessor();
                    operationInputProcessor.renderMenu(cuentas);
                    break;
                case 4:
                    ConsultarMovimientosProcessor consultarMovimientosProcessor = new ConsultarMovimientosProcessor(movimientos);
                    consultarMovimientosProcessor.ConsultarMovimientos(movimientos);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            clearScreen();
        }
    }
}
