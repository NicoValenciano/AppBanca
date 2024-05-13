package ar.edu.utn.frbb.tup.vista.client;

import ar.edu.utn.frbb.tup.modelo.Cliente;
import ar.edu.utn.frbb.tup.modelo.Direccion;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

import java.time.LocalDate;

public class ClienteInputProcessor extends BaseInputProcessor {


    public Cliente ingresarCliente() {

        // Ingreso de datos del Cliente
        Cliente cliente = new Cliente(null, null, 0, 0, null, null);
        clearScreen();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        System.out.println("Ingrese el número de dni del cliente:");
        int dni = Integer.parseInt(scanner.nextLine().toUpperCase());
        cliente.setDni(dni);

        System.out.println("Ingrese el número de teléfono del cliente:");
        int telefono = Integer.parseInt(scanner.nextLine().toUpperCase());
        cliente.setTelefono(telefono);

        System.out.println("Ingrese el correo del cliente:");
        String correo = scanner.nextLine();
        cliente.setCorreo(correo);

        // private Direccion direccion;
        System.out.println("Ingrese la calle del cliente:");
        String calle = scanner.nextLine();
        System.out.println("Ingrese el número de la calle del cliente:");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la ciudad del cliente:");
        String ciudad = scanner.nextLine();
        System.out.println("Ingrese la provincia del cliente:");
        String provincia = scanner.nextLine();
        System.out.println("Ingrese el código postal del cliente:");
        int codigoPostal = Integer.parseInt(scanner.nextLine());
        Direccion direccion = new Direccion(calle, numero, ciudad, provincia, codigoPostal);
        cliente.setDireccion(direccion);

        System.out.println("Ingrese la fecha de alta del cliente (Formato: YYYY-MM-DD):");
        LocalDate fechaAlta = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                fechaAlta = LocalDate.parse(scanner.nextLine());
                fechaValida = true;
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Ingrese la fecha en formato YYYY-MM-DD:");
            }
        }
        cliente.setFechaAlta(fechaAlta);

        clearScreen();
        return cliente;
    }
}
