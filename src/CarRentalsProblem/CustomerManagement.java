package CarRentalsProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    public static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer() {
        Customer customer = Customer.createCustomer();
        if (customer != null) {
            customers.add(customer);
            CarRentals.checkCustomer.put(customer.name, 1);
        }
    }

    public static void deleteCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).name.equals(name)) {
                customers.remove(i);
                CarRentals.checkCustomer.remove(name);
                return;
            }
        }
        System.out.println("\nCustomer with this name does not exist");
    }

    public static void updateCustomer(String name) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).name.equals(name)) {
                System.out.println("Enter the name of the customer");
                String newName = sc.nextLine();
                System.out.println("Enter the contact of the customer");
                String contact = sc.nextLine();
                CarRentals.checkCustomer.remove(name);
                customers.get(i).name = newName;
                customers.get(i).contactInformation = contact;
                CarRentals.checkCustomer.put(newName, 1);
                return;
            }
        }
        System.out.println("\nCustomer with this name does not exist");
    }

    public static void showCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Details of Customer " + (i + 1));
            System.out.println("Name: " + customers.get(i).name);
            System.out.println("Contact Information: " + customers.get(i).contactInformation);
        }
    }
}
