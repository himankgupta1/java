import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankCustomerManagement {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static int idCounter = 1000;

    public static void main(String[] args) {
        // Preload 3 customers using parameterized constructor
        customers.add(new Customer(++idCounter, "Sandra", "sandra@gmail.com", "9988778877", "Savings"));
        customers.add(new Customer(++idCounter, "Michelle", "michelle@gmail.com", "9876543210", "Current"));
        customers.add(new Customer(++idCounter, "Steve", "steve@gmail.com", "9123456789", "Savings"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to Standard Chartered Bank");
            System.out.println("1 - Add new Customer");
            System.out.println("2 - Display Customers");
            System.out.println("3 - Search Customer");
            System.out.println("4 - Delete Customer");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        addCustomer(sc);
                    } catch (InvalidDataException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    displayCustomers();
                    break;
                case 3:
                    searchCustomer(sc);
                    break;
                case 4:
                    deleteCustomer(sc);
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addCustomer(Scanner sc) throws InvalidDataException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (!Pattern.matches("[a-zA-Z ]+", name))
            throw new InvalidDataException("Name can only have alphabets.");

        System.out.print("Enter email: ");
        String email = sc.nextLine();
        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email))
            throw new InvalidDataException("Invalid email format.");

        System.out.print("Enter contact number: ");
        String contact = sc.nextLine();
        if (!Pattern.matches("\\d{10}", contact))
            throw new InvalidDataException("Contact must be 10 digits.");

        System.out.print("Enter account type (Savings/Current): ");
        String accountType = sc.nextLine();
        if (!accountType.equalsIgnoreCase("Savings") && !accountType.equalsIgnoreCase("Current"))
            throw new InvalidDataException("Account type must be Savings or Current.");

        int customerId = ++idCounter;
        customers.add(new Customer(customerId, name, email, contact, accountType));
        System.out.println("Customer added successfully with ID " + customerId);
    }

    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    private static void searchCustomer(Scanner sc) {
        System.out.print("Enter customer ID to search: ");
        if (!sc.hasNextInt()) {
            System.out.println("Customer ID must be an integer.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();
        for (Customer c : customers) {
            if (c.getCustomerId() == id) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void deleteCustomer(Scanner sc) {
        System.out.print("Enter customer ID to delete: ");
        if (!sc.hasNextInt()) {
            System.out.println("Customer ID must be an integer.");
            sc.nextLine();
            return;
        }
        int id = sc.nextInt();
        sc.nextLine();
        boolean removed = customers.removeIf(c -> c.getCustomerId() == id);
        if (removed)
            System.out.println("Customer deleted successfully.");
        else
            System.out.println("Customer not found.");
    }
}
