import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Option {
    public static void addCustomer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("\nId del Cliente: ");
            Customer customer = new Customer();
            customer.setId(reader.readLine());
            System.out.print("Nombre del Cliente: ");
            customer.setFirstName(reader.readLine());
            System.out.print("Apellido del Cliente: ");
            customer.setLastName(reader.readLine());
            System.out.print("Teléfono del Cliente: ");
            customer.setPhone(reader.readLine());
            System.out.print("Fecha de Nacimiento del Cliente(1990-01-01): ");
            try {
                customer.setBirthDate(LocalDate.parse(reader.readLine()));
            } catch (Exception e) {
                System.out.print("\nError: Formato de fecha incorrecto");
                return;
            }

            boolean success = Api.addCustomer(customer);
            if (success) System.out.print("\nCliente agregado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void editCustomer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("\nId del Cliente que desea editar: ");
            Customer customer = new Customer();
            String id = reader.readLine();
            customer.setId(id);
            System.out.print("Nombre del Cliente: ");
            customer.setFirstName(reader.readLine());
            System.out.print("Apellido del Cliente: ");
            customer.setLastName(reader.readLine());
            System.out.print("Teléfono del Cliente: ");
            customer.setPhone(reader.readLine());
            System.out.print("Fecha de Nacimiento del Cliente(1990-01-01): ");
            try {
                customer.setBirthDate(LocalDate.parse(reader.readLine()));
            } catch (Exception e) {
                System.out.print("\nError: Formato de fecha incorrecto");
                return;
            }

            boolean success = Api.editCustomer(id, customer);
            if (success) System.out.print("\nCliente editado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void deleteCustomer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("\nDigite el id del cliente: ");
            String id = reader.readLine();

            boolean success = Api.deleteCustomer(id);
            if (success) System.out.print("{\nCliente eliminado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void getCustomerById() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("\nDigite el id del cliente: ");
            String id = reader.readLine();

            boolean success = Api.getCustomerById(id);
            //if (success) System.out.print("{\nCliente eliminado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void getCustomersOrderById() {
        
        try {

            boolean success = Api.getCustomersList("id");
            //if (success) System.out.print("{\nCliente eliminado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void getCustomersOrderByName() {
        
        try {

            boolean success = Api.getCustomersList("name");
            //if (success) System.out.print("{\nCliente eliminado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void getCustomersOrderByBirthDate() {
        
        try {

            boolean success = Api.getCustomersList("birthDate");
            //if (success) System.out.print("{\nCliente eliminado con éxito");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
