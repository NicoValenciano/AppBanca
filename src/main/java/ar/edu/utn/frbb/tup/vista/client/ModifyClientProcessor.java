package ar.edu.utn.frbb.tup.vista.client;

import ar.edu.utn.frbb.tup.modelo.Cliente;
import ar.edu.utn.frbb.tup.modelo.Clientes;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

public class ModifyClientProcessor extends BaseInputProcessor {
    private Clientes clientes;

    public ModifyClientProcessor(Clientes clientes) {
        this.clientes = clientes;
    }

    public void modifyClient() {

        clearScreen();
        System.out.println("Ingrese el dni del cliente que desea modificar:");
        int dni = Integer.parseInt(scanner.nextLine());

        Cliente cliente = null;

        for (Cliente c : clientes.getClientes()) {
            if (c.getDni() == dni) {
                cliente = c;
                break;
            }
        }
        if (cliente != null) {
            System.out.println("Cliente encontrado!");
            System.out.println("Ingrese los nuevos datos del cliente:");
            ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
            clienteInputProcessor.ingresarCliente();
            clientes.getClientes().set(clientes.getClientes().indexOf(cliente), cliente);
            System.out.println("Cliente modificado con éxito!");
        }
    }
}