package ar.edu.utn.frbb.tup.vista.client;

import ar.edu.utn.frbb.tup.modelo.Clientes;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

public class DeleteClientProcessor extends BaseInputProcessor {
    private final Clientes clientes;

    public DeleteClientProcessor(Clientes clientes) {
        this.clientes = clientes;
    }

    public void DeleteClient(Clientes clientes) {
        clearScreen();
        System.out.println("Ingrese el dni del cliente que desea borrar:");
        int dni = Integer.parseInt(scanner.nextLine());

        if (clientes.borrarCliente(dni)) {
            System.out.println("Cliente borrado con éxito!");
        } else {
            System.out.println("No se encontró ningún cliente con ese DNI.");
        }
    }
}