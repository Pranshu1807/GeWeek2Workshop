package CarRentalsProblem;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

public class CarRentals {
    public static Map<String, Integer> checkCar = new HashMap<>();
    public static Map<String, Integer> checkCustomer = new HashMap<>();

    public static Car searchCar(String number) {
        for (int i = 0; i < CarManagement.cars.size(); i++) {
            if (CarManagement.cars.get(i).regNumber.equals(number)) {
                return CarManagement.cars.get(i);
            }
        }
        return null;
    }

    public static Customer searchCustomer(String name) {
        for (int i = 0; i < CustomerManagement.customers.size(); i++) {
            if (CustomerManagement.customers.get(i).name.equals(name)) {
                return CustomerManagement.customers.get(i);
            }
        }
        return null;
    }

    public static void rentCar(String number, String name, String date) {
        Car car = searchCar(number);
        Customer customer = searchCustomer(name);
        if (car == null) {
            System.out.println("Car doesn't exist");
        } else if (customer == null) {
            System.out.println("Customer doesn't exist");
        } else if (car.rented != null) {
            System.out.println("Car is already rented to someone else");
        } else {
            car.rented = customer;
            car.rentedDate = date;
            System.out.println("Car rented successfully");
        }

    }

    public static void displayAvaliableCar() {
        System.out.println("\nAvaliable cars: ");
        int cnt = 0;
        for (int i = 0; i < CarManagement.cars.size(); i++) {
            if (CarManagement.cars.get(i).rented == null) {
                System.out.println(CarManagement.cars.get(i).regNumber);
                cnt++;
            }
        }
        if (cnt == 0)
            System.out.println("No cars avaliable");
    }

    public static int calculateDifff(String rentDate, String returnDate) {
        LocalDate RentDate = LocalDate.parse(rentDate);
        LocalDate ReturnDate = LocalDate.parse(returnDate);

        Period interval = Period.between(RentDate, ReturnDate);
        int totaldays = (interval.getYears() * 365) + (interval.getMonths() * 30) + interval.getDays();
        return totaldays;
    }

    public static void returnCar(String number, String name, String date) {
        Car car = searchCar(number);
        Customer customer = searchCustomer(name);
        if (car == null) {
            System.out.println("Car doesn't exist");
        } else if (customer == null) {
            System.out.println("Customer doesn't exist");
        } else if (car.rented == null) {
            System.out.println("Car is already returned");
        } else if (car.rented.name.equals(customer.name) == false) {
            System.out.println("Car was not rented by this customer");
        } else {
            int totaldays = calculateDifff(car.rentedDate, date);
            Rent newRent = new Rent(car, customer, car.rentedDate, date, totaldays);
            RentalHistory.rentals.add(newRent);
            car.rented = null;
            car.rentedDate = null;
            System.out.println("Car returned succesfully");
        }
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Pranshu", "95802381321");
        Customer customer2 = new Customer("Rahul", "9731231231");
        Customer customer3 = new Customer("Rohit", "9712341412");

        CustomerManagement.customers.add(customer1);
        CustomerManagement.customers.add(customer2);
        CustomerManagement.customers.add(customer3);

        Car car1 = new Car("Audi", "2020", "Black", "2456789", "12345");
        Car car2 = new Car("BMW", "2021", "Blue", "3456789", "1234");
        Car car3 = new Car("Lambo", "2020", "Red", "3056789", "123");

        CarManagement.cars.add(car1);
        CarManagement.cars.add(car2);
        CarManagement.cars.add(car3);

        CarManagement.showCars();

        RentalHistory.RentalHistoryByCar("Audi");
        RentalHistory.RentalHistoryByCustomer("Pranshu");

        displayAvaliableCar();
        rentCar("12345", "Pranshu", "2022-04-12");
        rentCar("123456", "Pranshu", "2022-04-12");
        displayAvaliableCar();

        RentalHistory.RentalHistoryByCar("12345");
        RentalHistory.RentalHistoryByCustomer("Pranshu");

        returnCar("12345", "ajay", "2022-05-16");
        returnCar("12345", "Rahul", "2022-05-16");
        returnCar("12345", "Pranshu", "2022-05-16");

        displayAvaliableCar();

        RentalHistory.RentalHistoryByCar("12345");
        RentalHistory.RentalHistoryByCustomer("Pranshu");
    }
}
