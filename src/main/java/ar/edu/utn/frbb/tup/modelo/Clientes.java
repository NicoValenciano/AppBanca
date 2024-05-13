package ar.edu.utn.frbb.tup.modelo;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean borrarCliente(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public Cliente getClienteByDni(int dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }
}
