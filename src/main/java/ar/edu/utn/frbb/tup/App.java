package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.modelo.Clientes;
import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.modelo.Movimientos;
import ar.edu.utn.frbb.tup.vista.MenuInputProcessor;

/**
 * Inicio de apliacion bancaria
 *
 */
public class App 
{
    public static void main(String[] args) {
        Clientes clientes = new Clientes();
        Cuentas cuentas = new Cuentas();
        Movimientos movimientos = new Movimientos();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(clientes, cuentas, movimientos);

    }
}
