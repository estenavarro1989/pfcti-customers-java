import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    
    public static void displayMainMenu() throws IOException {
        System.out.println("\n\nMenú Principal");
        System.out.println("1. Agregar un cliente nuevo");
        System.out.println("2. Editar un cliente");
        System.out.println("3. Eliminar un cliente");
        System.out.println("4. Consultar un cliente por id");
        System.out.println("5. Listar clientes por ordenados por fecha de nacimiento descendente");
        System.out.println("6. Listar clientes por ordenados por id");
        System.out.println("7. Listar clientes por nombre de manera ascendente");
        System.out.println("8. Salir");

        System.out.print("\nOpción Elegida: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String option = reader.readLine();
        switch (option) {
            case "1":
                Option.addCustomer();
                displayMainMenu();
                break;
            case "2":
                Option.editCustomer();
                displayMainMenu();
                break;
            case "3":
                Option.deleteCustomer();
                displayMainMenu();
                break;
            case "4":
                Option.getCustomerById();
                displayMainMenu();
                break;
            case "5":
                Option.getCustomersOrderByBirthDate();
                displayMainMenu();
                break;
            case "6":
                Option.getCustomersOrderById();
                displayMainMenu();
                break;
            case "7":
                Option.getCustomersOrderByName();
                displayMainMenu();
                break;
            case "8":
                System.out.println("\nSaliendo...");
                break;
            default:
                System.out.println("\nOpción Inválida");
                displayMainMenu();
                break;
        }
    }
}
