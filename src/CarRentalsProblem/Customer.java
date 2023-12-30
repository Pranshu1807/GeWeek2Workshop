package CarRentalsProblem;

import java.util.Scanner;

public class Customer {
    public String name, contactInformation;

    public Customer(String name, String contactInformation) {
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public static Customer createCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the customer");
        String name = sc.nextLine();
        System.out.println("Enter the contact of the customer");
        String contact = sc.nextLine();
        if (CarRentals.checkCustomer.containsKey(name)) {
            System.out.println("Customer with this name already exists");
            return null;
        }
        Customer customer = new Customer(name, contact);
        return customer;
    }
}
