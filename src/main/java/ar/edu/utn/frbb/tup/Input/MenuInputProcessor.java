package ar.edu.utn.frbb.tup.Input;

import ar.edu.utn.frbb.tup.Model.Banco;
import ar.edu.utn.frbb.tup.Model.Cliente;
import ar.edu.utn.frbb.tup.Model.Cuenta;

import java.util.*;

public class MenuInputProcessor extends BaseInputProcessor {

    private Scanner scanner = new Scanner(System.in);
    private ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor();
    private CuentaInputProcessor cuentaInputProcessor = new CuentaInputProcessor();

    private boolean exit = false;

    public void renderMenu(Banco banco) {
        while (!exit) {
            System.out.println("Bienvenido a la aplicación de Banco!");
            System.out.println("1.- Cliente");
            System.out.println("2.- Cuenta");
            System.out.println("3.- Movimientos.");
            System.out.println("4.- Realizar una transferencia.");
            System.out.println("5.- Salir del programa.");
            System.out.print("Ingrese su opción (1-5): ");

            int choice = getUserChoice();

            clearScreen();
            switch (choice) {
                case 1: // Opcion 1: Menú de Cliente
                    renderCliente(banco);
                    break;
                case 2: // Opcion 2: Menú de Cuenta
                    renderCuenta(banco.getClientes());
                    break;
                case 3: // Opcion 3: Movimientos.
                    CuentaInputProcessor.mostrarMovimientos(banco.getClientes());
                    break;
                case 4: // Opcion 4: Transferencias.
                    TransferenciaInputProcessor.transferir(banco.getClientes());
                    break;
                case 5: // Opcion 4: Salir del programa.
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
                    break;
            }
        }
    }


    private void renderCliente(Banco banco) {
        boolean exitClienteMenu = false;
        while (!exitClienteMenu) {
            System.out.println("Bienvenido al menú de Clientes");
            System.out.println("1.- Generar un nuevo Cliente.");
            System.out.println("2.- Mostrar los Clientes generados.");
            System.out.println("3.- Modificar un Cliente generado.");
            System.out.println("4.- Eliminar un Cliente generado.");
            System.out.println("5.- Volver al menú principal.");
            System.out.print("\nIngrese su opción (1-5): ");

            int choice = getUserChoice();

            clearScreen();
            switch (choice) {
                case 1: // Opcion 1: Crear un nuevo Cliente.
                    Cliente c = clienteInputProcessor.ingresarCliente();
                    banco.getClientes().add(c);
                    break;
                case 2: // Opcion 2: Mostrar los clientes generados.
                    clienteInputProcessor.mostrarClientes(banco.getClientes());
                    break;
                case 3: // Opcion 3: Modifica Cliente
                    clienteInputProcessor.modificarCliente(banco.getClientes());
                    break;
                case 4: // Opcion 4: Elimina Cliente
                    clienteInputProcessor.eliminarCliente(banco.getClientes());
                    break;
                case 5: // Opcion 5: Volver al menú principal.
                    exitClienteMenu = true;
                    break;
                default:
                    System.out.print("Opción inválida. Por favor seleccione (1-5): ");
                    break;
            }
        }
    }

    public void renderCuenta(List<Cliente> clientes) {
        boolean exitCuentaMenu = false;

        while (!exitCuentaMenu) {
            System.out.println("Bienvenido al menú de Cuentas Bancarias");
            System.out.println("1.- Crear cuenta bancaria.");
            System.out.println("2.- Realizar depósito bancario.");
            System.out.println("3.- Realizar retiro bancario.");
            System.out.println("4.- Consultar saldo de la cuenta.");
            System.out.println("5.- Volver al menú principal.");
            System.out.print("\nIngrese su opción (1-5): ");

            int choice = getUserChoice();

            clearScreen();
            switch (choice) {
                case 1:
                    Cuenta c = cuentaInputProcessor.crearCuenta(clientes);
                    break;
                case 2: //Realiza Deposito
                    CuentaInputProcessor.realizarDeposito(clientes);
                    break;
                case 3: //Realiza RETIRO
                    CuentaInputProcessor.realizarRetiro(clientes);
                    break;
                case 4://Realiza CONSULTA
                    CuentaInputProcessor.consultarSaldo(clientes);
                    break;
                case 5:
                    exitCuentaMenu = true;
                    break;
                default:
                    System.out.print("Opción inválida. Por favor seleccione (1-5): ");
                    break;
            }
        }
    }

    // Método que verifica que el usuario ingrese correctamente las opciones.
    private int getUserChoice() {
        int choice = 0;
        boolean isValidInput = false;

        // En caso de no escribrir un numero válido devuelve un mensaje de error.
        while (!isValidInput) {
            try {
                choice = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.print("Opción inválida. Ingrese un número válido (1-5): ");
                scanner.next();
            }
        }
        return choice;
    }

}

