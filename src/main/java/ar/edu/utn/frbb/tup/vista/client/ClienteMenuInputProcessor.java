package ar.edu.utn.frbb.tup.vista.client;

import ar.edu.utn.frbb.tup.modelo.Cliente;
import ar.edu.utn.frbb.tup.modelo.Clientes;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

public class ClienteMenuInputProcessor extends BaseInputProcessor {
    boolean exit = false;

    public void renderMenu(Clientes clientes) {

        while (!exit) {
            clearScreen();
            System.out.println("Menú de administración de Clientes");
            System.out.println("1. Alta de un nuevo Cliente");
            System.out.println("2. Baja de un Cliente");
            System.out.println("3. Modificación de un Cliente");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
                    Cliente c = clienteInputProcessor.ingresarCliente();
                    clientes.getClientes().add(c);
                    break;
                case 2:
                    DeleteClientProcessor deleteClientProcessor = new DeleteClientProcessor(clientes);
                    deleteClientProcessor.DeleteClient(clientes);
                    break;
                case 3:
                    ModifyClientProcessor modifyClientProcessor = new ModifyClientProcessor(clientes);
                    modifyClientProcessor.modifyClient();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-4.");
            }
            clearScreen();
        }
    }
}