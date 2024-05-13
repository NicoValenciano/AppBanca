package ar.edu.utn.frbb.tup.vista.movement;


import ar.edu.utn.frbb.tup.modelo.Cuentas;
import ar.edu.utn.frbb.tup.vista.BaseInputProcessor;

public class OperationInputProcessor extends BaseInputProcessor {
    boolean exit = false;

    public void renderMenu(Cuentas cuentas) {

        while (!exit) {
            clearScreen();
            System.out.println("Menú de operaciones:");
            System.out.println("1. Realizar depósito");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Realizar transferencia");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    DepositInputProcessor depositInputProcessor = new DepositInputProcessor(cuentas);
                    depositInputProcessor.processDeposit();
                    break;
                case 2:
                    ExtractionInputProcessor extractionInputProcessor = new ExtractionInputProcessor(cuentas);
                    extractionInputProcessor.processExtraction();
                    break;
                case 3:
                    TransferInputProcessor transferInputProcessor = new TransferInputProcessor(cuentas);
                    transferInputProcessor.processTransfer();
                    break;
                case 4:
                    CheckBalanceProcessor checkBalanceProcessor = new CheckBalanceProcessor(cuentas);
                    checkBalanceProcessor.processCheckBalance();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
            }
            clearScreen();
        }
    }
}
